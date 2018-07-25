import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.io.orc.OrcInputFormat;
import org.apache.hadoop.hive.ql.io.orc.OrcSerde;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.security.UserGroupInformation;
import org.junit.Test;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/13
 */
public class orcRead {
    public static final String HDFS_URL = "hdfs://192.168.19.25:11000";

    @Test
    public void send() throws Exception{

        Socket socket = new Socket("192.168.181.227",12345);
        OutputStream outputStream = socket.getOutputStream();
        for(int i=0;i<100000;i++){
            outputStream.write(("test avro"+IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
        }
        outputStream.close();


    }

    @Test
    public void generageAvro() throws  Exception{
        new AvroTask().ExcuteAvroTask("2015-01-01-1.json.gz");

    }



    @Test
    public void readOrc() throws  Exception{

        String username ="spark";


        System.setProperty("HADOOP_USER_NAME",username);
        Configuration config= new Configuration();
        UserGroupInformation createProxyUser =UserGroupInformation.createProxyUser(username,UserGroupInformation.getCurrentUser());
        createProxyUser.doAs(new PrivilegedExceptionAction<Long>() {
            @Override
            public Long run() throws Exception {
                String path="/warehouse/game_analysis.db/github_orc/time_date=2015-01-01";



                return 1L;
            };
        });




//        JobConf conf=new JobConf();
//        conf.set("fs.default.name","hdfs://master:9000");
//        OrcSerde serde=new OrcSerde();
//        Properties p=new Properties();
//        p.setProperty("columns", "date_id,referrer_type,referrer_shopid,is_test,referrer_id,user_unique,apply_mobile");
//        p.setProperty("columns.types", "string,string,string,int,string,string,string");
//        serde.initialize(conf, p);
//        StructObjectInspector inspector = (StructObjectInspector) serde.getObjectInspector();
//        InputFormat in = new OrcInputFormat();
//        FileInputFormat.setInputPaths(conf, new Path(path));
//        InputSplit[] splits = in.getSplits(conf, 1);
//        conf.set("hive.io.file.readcolumn.ids", "1");//hive.io.file.readcolumn.ids的默认值是空，如果没有字段名 ，就会产生空值，在Integer.parseInt(element)就会报错。
//        RecordReader reader = in.getRecordReader(splits[0], conf, Reporter.NULL);
//        Object key = reader.createKey();
//        Object value = reader.createValue();
//        List<? extends StructField> fields = inspector.getAllStructFieldRefs();
//        long offset = reader.getPos();
//        while(reader.next(key, value)) {
//            Object date_id = inspector.getStructFieldData(value, fields.get(0));
//            Object referrer_type = inspector.getStructFieldData(value, fields.get(1));
//            Object referrer_shopid = inspector.getStructFieldData(value, fields.get(2));
//            Object is_test = inspector.getStructFieldData(value, fields.get(3));
//            Object referrer_id = inspector.getStructFieldData(value, fields.get(4));
//            Object user_unique = inspector.getStructFieldData(value, fields.get(5));
//            Object apply_mobile = inspector.getStructFieldData(value, fields.get(6));
//            offset = reader.getPos();
//            System.out.println(date_id + "|" + referrer_type + "|" + referrer_shopid + "|" + is_test+ "|" + referrer_id+ "|" + user_unique+ "|" + apply_mobile);
//        }

    }
}
