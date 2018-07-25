import com.freedom.bigdata.CompleteInfo;

import java.util.concurrent.BlockingDeque;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/07
 */
public class Worker implements   Runnable{
    private  String filePath;
    private String fileName;
    private BlockingDeque<String>queue;
    private IAvroToThread avroTask;

    Worker(IAvroToThread avroTask){
        this.avroTask =avroTask;

    }
    @Override
    public void run() {
        String path = CompleteInfo.queue.poll();
        try {
            avroTask.excute(path);
            CompleteInfo.completequeue.add(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
