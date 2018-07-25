package morphline;
import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.Days;
import org.kitesdk.morphline.api.Command;
import org.kitesdk.morphline.api.MorphlineContext;
import org.kitesdk.morphline.api.Record;
import org.kitesdk.morphline.base.Compiler;
import org.kitesdk.morphline.base.Fields;
import org.kitesdk.morphline.base.Notifications;


/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/14
 *
 *
 *
 */
public class MorphlineDemo {
    public static  void main(String args[]) throws Exception {


        File file = new File("2015-01-01-1.json.gz");
        InputStream inputStream = new GZIPInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = reader.readLine();
    //String s = "110.87.60.97";
        //morphlineDemoSplit.conf
        String path = MorphlineDemo.class.getResource("/geoip.conf").getPath();
        File configFile = new File(path);
        MorphlineContext context = new MorphlineContext.Builder().build();
       // String s = "<164>Feb  4 10:46:14 syslog sshd[607]: listening on 0.0.0.0 port 22.";
       // String s = "Feb  6 12:04:42 IN=eth1 OUT=eth0 SRC=1.2.3.4 DST=6.7.8.9 ACK DF WINDOW=0";
       //StringUtils.contains()
       // Days.daysBetween()





        Command morphline = new Compiler().compile(configFile, null, context, null);
      //  Notifications.notifyBeginTransaction(morphline);
        Record  record = new Record();
        record.put("first_name","Song");
        String pattern = "yyyy-MM-dd'T'HH:mm:ss:SSS";
        String s1 = new Date().toString();
        System.out.println(DateFormatUtils.format(new Date(),pattern));
        record.put("time",DateFormatUtils.format(new Date(),pattern));
        record.put("my_uri",DateFormatUtils.format(new Date(),pattern));

        record.put(Fields.ATTACHMENT_BODY,s.getBytes());
        Object firstValue = record.getFirstValue(Fields.ATTACHMENT_BODY);
        boolean process = morphline.process(record);
        Notifications.notifyCommitTransaction(morphline);
    }

}
