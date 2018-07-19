package com.nd.s414567.task;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.nd.s414567.task.vo.ITaskProcessor;
import com.nd.s414567.task.vo.JobInfo;
import com.nd.s414567.task.vo.TaskResult;
import com.nd.s414567.task.vo.TaskResultType;

/**
 * describe:主体类
 *
 * @author nd.414567
 * @date 2018/07/19
 */
public class PendingJobPool {

    private static final int THREAD_COUNTS =Runtime.getRuntime().availableProcessors();
    private static BlockingQueue<Runnable>taskQueue = new ArrayBlockingQueue<Runnable>(5000);
    private static ExecutorService taskExecutor =
            new ThreadPoolExecutor(THREAD_COUNTS,THREAD_COUNTS,
                    60,
                    TimeUnit.SECONDS,
                    taskQueue);
    //工作job的存放容器:
    private static ConcurrentHashMap<String,JobInfo<?>>jobInfoMap = new ConcurrentHashMap<>();
    private static CheckJobProcessor checkJobProcessor = CheckJobProcessor.getInstance();

	//单例模式:
    private PendingJobPool(){

    }

    private static class JobPollHolder{

	    public static  PendingJobPool pendingJobPool = new PendingJobPool();
    }
    public static Map<String,JobInfo<?>>getMap(){
        return jobInfoMap;
    }


    public static PendingJobPool getInstance(){
	    return  JobPollHolder.pendingJobPool;
    }

    private <R> JobInfo<R>getJob(String jobName){
        JobInfo<R> jobInfo = (JobInfo<R>) jobInfoMap.get(jobName);
        if (jobInfo == null){
            throw new RuntimeException(jobName+"是非法任务");
        }
        return jobInfo;
    }


	//调用者提交工作中的任务
	public <T,R> void putTask(String jobName,T t) {
		// 拿到任务的详情:
        JobInfo<R> jobInfo = getJob(jobName);
        PendingTask<T, R> pendingTask = new PendingTask<>(jobInfo, t);
        taskExecutor.execute(pendingTask);
	}

    //对工作中的任务进行包装，提交给线程池使用，并处理任务的结果，写入缓存以供查询
    private static class PendingTask<T,R> implements Runnable{

        private JobInfo<R> jobInfo;
        private T processData;
        public PendingTask(JobInfo<R> jobInfo, T processData) {
            super();
            this.jobInfo = jobInfo;
            this.processData = processData;
        }

        @SuppressWarnings("unchecked")
        @Override
        public void run() {
            R r = null;
            ITaskProcessor<T, R> taskProcessor = (ITaskProcessor<T, R>) jobInfo.getTaskProcessor();
            TaskResult<R> taskResult = null;
            try{
                taskResult = taskProcessor.executeTask(processData);
                //防止处理不当
                if(taskResult == null){
                    taskResult = new TaskResult<R>(TaskResultType.Exception,r,"result is null");
                }
                if(taskResult.getResultType() == null){

                    if(taskResult.getReason() == null){
                        taskResult = new TaskResult<R>(TaskResultType.Exception,r,"result is null");
                    }else{
                        taskResult = new TaskResult<R>(TaskResultType.Exception,r,"result is null but reason"+taskResult.getReason());
                    }
                }
            }catch (Exception e){
                    e.printStackTrace();
                taskResult = new TaskResult<R>(TaskResultType.Exception,r,e.getMessage());
            }finally {
                jobInfo.addTaskResult(taskResult,checkJobProcessor);

            }
        }
    }
	
	//调用者注册工作，如工作名，任务的处理器等，打包成jobInfo，放入到容器中去:
	public <R> void registerJob(String jobName, int jobLength,
								ITaskProcessor<?, ?> taskProcessor, long expireTime) {
        JobInfo<R>jobInfo = new JobInfo(jobName, jobLength, taskProcessor, expireTime);
        if(jobInfoMap.putIfAbsent(jobName, jobInfo) != null){
            throw  new RuntimeException(jobName+"已经注册");
        }
    }
	//获得每个任务的处理详情
	public <R> List<TaskResult<R>> getTaskDetail(String jobName){

        JobInfo<R> job = getJob(jobName);
        return  job.getTaskDetail();
	}
	
	//获得工作的整体处理进度
	public <R> String getTaskProgress(String jobName) {
        JobInfo<R> job = getJob(jobName);
        String totalProcess = job.getTotalProcess();

        return totalProcess;
    }
	
}
