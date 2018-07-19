package com.nd.s414567.task.vo;

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
     *  ��������ĸ���
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
    //��֤����һ���ԣ�����Ҫ�Է�������
    public void addTaskResult(TaskResult<R>taskResult){
        if(taskResult.getResultType().equals(TaskResultType.Success)){
            successCount.incrementAndGet();
        }
        taskDetailQueue.addLast(taskResult);
        taskProcessorCount.incrementAndGet();
    }

}
