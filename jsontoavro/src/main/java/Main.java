import com.freedom.bigdata.CompleteInfo;
import org.mariadb.jdbc.internal.util.scheduler.FixedSizedSchedulerImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/07
 */
public class Main {

    public static void main(String args[]) throws  Exception{
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(10240);
        ThreadPoolExecutor executor= new FixedSizedSchedulerImpl(16,"avroTask");

        CompleteInfo info = CompleteInfo.UnSerializable();
        AvroTask avroTask = new AvroTask();
        Map<String,Future<?>> futureMap = new HashMap<String,Future<?>>();

        //线程中:
        Worker worker = new Worker(avroTask);

        for(int i=0;i<info.hashSet.size();i++){
            Future<?> future = executor.submit(worker);
        }
        while(true){
            String completePath = CompleteInfo.completequeue.poll();
            if(completePath == null){
                continue;
            }
            info.remove(completePath);
            System.out.println("完成"+completePath);
            CompleteInfo.Serializable(info);
            Thread.sleep(100);
        }
    }
}
