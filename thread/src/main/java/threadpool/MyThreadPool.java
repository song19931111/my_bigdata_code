package threadpool;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/16
 */
public class MyThreadPool {

    public static int WORK_NUM =5;
    public static int TASK_COUNT=100;
    private final BlockingQueue<Runnable>taskQueue;
    private WorkThread[]workThreads;
    private final int workerNum;
    private final int taskCount;


    MyThreadPool(){
        this(WORK_NUM,TASK_COUNT);
    }
    public MyThreadPool(int workerNum,int taskCount) {
        this.taskQueue = new ArrayBlockingQueue<Runnable>(workerNum);
        this.workerNum = workerNum;
        this.taskCount =taskCount;
        workThreads = new WorkThread[workerNum];
        for(int i=0;i<workerNum;i++){
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }
    public void destory(){
        for(int i=0;i<workerNum;i++){
            workThreads[i] = new WorkThread();
            workThreads[i].stopWorker();
            workThreads[i]=  null; //help gc
        }
        taskQueue.clear();
    }

    public void execute(Runnable runnable) throws InterruptedException {
        taskQueue.put(runnable);

    }
    private class WorkThread extends  Thread{

        @Override
        public void run() {
            Runnable r = null;

            while(!isInterrupted()){
                try {
                    r = taskQueue.take();
                    if(r != null){
                        r.run();
                    }
                    r  =null;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

            }

        }
        public void stopWorker(){
            interrupt();
        }
    }

}
