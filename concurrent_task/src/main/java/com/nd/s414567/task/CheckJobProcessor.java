package com.nd.s414567.task;

import com.nd.s414567.task.vo.ItemVo;

import java.util.Map;
import java.util.concurrent.DelayQueue;

/**
 * describe:检查结构
 *
 * @author nd.414567
 * @date 2018/07/19
 */
public class CheckJobProcessor {
    private static DelayQueue<ItemVo<String>> queue
    	= new DelayQueue<ItemVo<String>>();//存放任务的队列


    //单例模式:
    private CheckJobProcessor(){

    }

    private static class JobPollHolder{

        public static  CheckJobProcessor checkJobProcessor = new CheckJobProcessor();
    }


    public static  CheckJobProcessor getInstance(){
        return  JobPollHolder.checkJobProcessor;
    }

    //处理队列中到期任务的线程
    private static class FetchJob implements Runnable{

		@Override
		public void run() {
		    while(true){
		        try{
                    ItemVo<String> item = queue.take();
                    String jobName = item.getDate();
                    PendingJobPool.getMap().remove(jobName);
                    System.out.println(jobName+"is out of date");
                }catch (Exception e){
                        e.printStackTrace();
                }

		    }
        }

    }
    
    /*任务完成后，放入队列，经过expireTime时间后，从整个框架中移除*/
    public void putJob(String jobName,long expireTime) {
        ItemVo<String> item = new ItemVo<String>(expireTime,jobName);
        queue.offer(item);
        System.out.println("Job ["+jobName+"放入过期检查缓存"+"  过期时间"+"["+expireTime+"]");
    }
    static {
        Thread thread = new Thread(new FetchJob());
        thread.setDaemon(true);
        thread.start();
        System.out.println("检查过期线程开启");
    }
    
}
