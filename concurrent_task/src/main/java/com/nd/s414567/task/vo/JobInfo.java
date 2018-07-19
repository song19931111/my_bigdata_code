package com.nd.s414567.task.vo;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * describe:提交给框架执行的工作实体类
 *
 * @author nd.414567
 * @date 2018/07/19
 */
public class JobInfo<R> {

    /**
     * 区分一个唯一的工作
     */
    private final String jobName;
    /**
     *  工作任务的个数
     */
    private final int jobLength;

    /**
     * 任务处理器
     */
    private final ITaskProcessor<?,?>taskProcessor;
    /**
     * 成功的个数
     */
    private AtomicInteger successCount ;

    /**
     *成功的总个数
     */
    private  AtomicInteger taskProcessorCount ;

    /**
     *保存任务的工作结果,拿结果从头拿，放结果从尾部放，减少拿放冲突
     */
    private LinkedBlockingDeque<TaskResult<R>> taskDetailQueue;

    /**
     * 任务过期时间
     */
    private final long expireTime;




    public JobInfo(String jobName, int jobLength, ITaskProcessor<?, ?> taskProcessor, long expireTime) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.taskProcessor = taskProcessor;
        this.expireTime = expireTime;
        this.successCount = new AtomicInteger(0);
        this.taskProcessorCount = new AtomicInteger(0);
    }



    public int getSuccessCount() {
        return successCount.get();
    }

    public int getTaskProcessorCount() {
        return taskProcessorCount.get();
    }

    public List<TaskResult<R>>getTaskDetail(){
        List<TaskResult<R>>taskResults = new ArrayList<>();
        TaskResult<R>taskResult = null;
        while((taskResult = taskDetailQueue.pollFirst())!= null){
            taskResults.add(taskResult);
        }
        return  taskResults;

    }
    //保证最终一致性，不需要对方法加锁
    public void addTaskResult(TaskResult<R>taskResult){
        if(taskResult.getResultType().equals(TaskResultType.Success)){
            successCount.incrementAndGet();
        }
        taskDetailQueue.addLast(taskResult);
        taskProcessorCount.incrementAndGet();
    }

}
