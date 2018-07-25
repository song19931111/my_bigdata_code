package com.nd.s414567.task.vo;

import com.nd.s414567.task.CheckJobProcessor;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * describe:�ύ�����ִ�еĹ���ʵ����
 *
 * @author nd.414567
 * @date 2018/07/19
 */
public class JobInfo<R> {

    /**
     * ����һ��Ψһ�Ĺ���
     */
    private final String jobName;
    /**
     *  ��������ĸ������ж��ٸ�task
     */
    private final int jobLength;

    /**
     * ��������
     */
    private final ITaskProcessor<?,?>taskProcessor;
    /**
     * �ɹ��ĸ���
     */
    private AtomicInteger successCount ;

    /**
     *�ɹ����ܸ���
     */
    private  AtomicInteger taskProcessorCount ;

    /**
     *��������Ĺ������,�ý����ͷ�ã��Ž����β���ţ������÷ų�ͻ
     */
    private LinkedBlockingDeque<TaskResult<R>> taskDetailQueue;

    /**
     * �������ʱ��
     */
    private final long expireTime;

    public ITaskProcessor<?, ?> getTaskProcessor() {
        return taskProcessor;
    }

    public JobInfo(String jobName, int jobLength, ITaskProcessor<?, ?> taskProcessor, long expireTime) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.taskProcessor = taskProcessor;
        this.expireTime = expireTime;
        this.successCount = new AtomicInteger(0);
        this.taskProcessorCount = new AtomicInteger(0);
        this.taskDetailQueue = new LinkedBlockingDeque<TaskResult<R>>(jobLength);
    }



    public int getSuccessCount() {
        return successCount.get();
    }

    public int getTaskProcessorCount() {
        return taskProcessorCount.get();
    }


    public int getFailCount(){
        return taskProcessorCount.get()-successCount.get();
    }

    public List<TaskResult<R>>getTaskDetail(){
        List<TaskResult<R>>taskResults = new ArrayList<>();
        TaskResult<R>taskResult = null;
        while((taskResult = taskDetailQueue.pollFirst())!= null){
            taskResults.add(taskResult);
        }
        return  taskResults;

    }
    public String getTotalProcess(){

        return  "Success["+successCount.get()+"]"+" /Current["+taskProcessorCount.get()+"] "+"Total["+jobLength+"]";
    }
    //��֤����һ���ԣ�����Ҫ�Է�������
    public void addTaskResult(TaskResult<R>taskResult, CheckJobProcessor checkJobProcessor){
        if(taskResult.getResultType().equals(TaskResultType.Success)){
            successCount.incrementAndGet();
        }
        taskDetailQueue.addLast(taskResult);
        taskProcessorCount.incrementAndGet();
        if(taskProcessorCount.get() == jobLength){
            checkJobProcessor.putJob(jobName,expireTime);
        }
    }

}