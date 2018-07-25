import cn.nd.bigdata.analytics.github_events;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.freedom.bigdata.CompleteInfo;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.security.UserGroupInformation;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.security.PrivilegedExceptionAction;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/04
 */

public class testAvro {

    @Test
    public void testAvro() throws IOException {
        github_events.Builder builder = github_events.newBuilder();

        String path = "./game-analyse2.avro"; // avro文件存放目录
        List<github_events> list = new ArrayList<>();

        for(int i=0;i<1000000;i++){
            github_events build = builder.setEventId(i).build();
            list.add(build);
        }

        DatumWriter<github_events> userDatumWriter = new SpecificDatumWriter<github_events>(github_events.class);
        DataFileWriter<github_events> dataFileWriter = new DataFileWriter<github_events>(userDatumWriter);
        dataFileWriter.create(list.get(0).getSchema(),  new File(path));
        // 把生成的user对象写入到avro文件
        for(github_events build:list){
            dataFileWriter.append(build);
        }
        dataFileWriter.close();

    }




    @Test
    public void downloadFileFromHDFS()throws Exception{
        String username = "bigdata";


        Set<String>set = new HashSet<>();
        Configuration conf = new Configuration();
                System.setProperty("HADOOP_USER_NAME",username);
        UserGroupInformation createProxyUser =UserGroupInformation.createProxyUser(username,UserGroupInformation.getCurrentUser());
        createProxyUser.doAs(new PrivilegedExceptionAction<Long>() {
            @Override
            public Long run() throws Exception {
                FileSystem fs = FileSystem.get(URI.create("hdfs://192.168.19.25:11000"),conf,username);
                String relative = "/analytics/testdata/githubarchive/source/yearly/2015/";
                Path target = Path.mergePaths(fs.getHomeDirectory(),new Path(relative));
                long written = 0;
                //列出所有的文件:
                RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator = fs.listFiles(target, true);
                CompleteInfo completeInfo = new CompleteInfo();
                while(locatedFileStatusRemoteIterator.hasNext()){
                    LocatedFileStatus fileStatus = locatedFileStatusRemoteIterator.next();
                    String path = fileStatus.getPath().toString();
                    completeInfo.add(path);
                }
                CompleteInfo.Serializable(completeInfo);
                //FileOutputStream output = new FileOutputStream();
                //IOUtils.
                
               
                fs.close();
                return written;
            }
        });
    }

    @Test
  public void createDirToHDFS() throws Exception{
    System.setProperty("HADOOP_USER_NAME","spark");
        Configuration conf = new Configuration();
        UserGroupInformation createProxyUser =UserGroupInformation.createProxyUser("spark",UserGroupInformation.getCurrentUser());
        createProxyUser.doAs(new PrivilegedExceptionAction<Long>() {
            @Override
            public Long run() throws Exception {
                FileSystem fs = FileSystem.get(URI.create("hdfs://192.168.19.25:11000"),conf,"spark");
                String relative = "/warehouse/game_analysis.db/songxiang_avro/";
                Path target = Path.mergePaths(fs.getHomeDirectory(),new Path(relative));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date oneDay =df.parse("2014-12-31");

                Long written = 0L;
                for(int i=0;i<365;i++){
                    oneDay = DateUtils.addDays(oneDay, 1);
                    String result =  "/time_date="+df.format(oneDay);
                    fs.mkdirs(Path.mergePaths(target,new Path(result)));
                }
                fs.close();
                return written;
            }
        });
    }

    @Test
    public void test() throws ParseException {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2017-06-06 10:20:30");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        //calendar.set(Calendar.DAY_OF_WEEK,1);
        calendar.set(Calendar.DAY_OF_MONTH,1);//设置当前月份为1日

        System.out.println(calendar.getTime());
    }

    @Test
    public  void getAvro() throws IOException, ParseException {
        File file = new File("2015-01-01-1.json");
        BufferedReader read = new BufferedReader(new FileReader(file));
        String line  = StringUtils.EMPTY;
        List<github_events>list = new ArrayList<>();
        github_events.Builder builder = github_events.newBuilder();
        Integer i=0;
        while (StringUtils.EMPTY != (line= read.readLine()) && line != null){

            if(line.matches("^(\\s*)") || line == null){
                continue;
            }
            JSONObject json = JSON.parseObject(line);
            System.out.println(i++);
            builder.setEventId(Long.parseLong(json.getOrDefault("id","-1").toString()));
            builder.setEventName(json.get("type").toString());
            builder.setEventPublic(Boolean.parseBoolean(json.get("public").toString()));
            //create time :
            String createTime = json.getString("created_at");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            DateTime time = new DateTime(sdf.parse(createTime));

            builder.setEventCreatedAt(time);
            builder.setEventReceivedAt(time);
            builder.setUserId(((JSONObject)json.get("actor")).getIntValue("id"));
            builder.setUserLogin(((JSONObject)json.get("actor")).getString("login"));
            builder.setUserGravatarId(((JSONObject)json.get("actor")).getString("gravatar_id"));
            builder.setUserAvatarUrl(((JSONObject)json.get("actor")).getString("avatar_url"));
            builder.setUserUrl(((JSONObject)json.get("actor")).getString("url"));
            builder.setRepoId(((JSONObject)json.get("repo")).getIntValue("id"));
            builder.setRepoUrl(((JSONObject)json.get("repo")).getString("url"));
            builder.setOrgId(((JSONObject)json.get("actor")).getIntValue("id"));
            builder.setOrgLogin(((JSONObject)json.get("actor")).getString("login"));
            builder.setOrgAvatarUrl(((JSONObject)json.get("actor")).getString("avatar_url"));
            builder.setOrgUrl(((JSONObject)json.get("actor")).getString("url"));
            builder.setEventPayload(json.getOrDefault("payload","default_payload").toString());
            //按每一天:
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time.toDate());
            calendar.set(Calendar.DAY_OF_MONTH,1);//设置当前月份为1日
            calendar.add(Calendar.MONTH, 0);//加上月份
            Date  dateOfMonth= calendar.getTime();
            LocalDate localDate = LocalDate.fromDateFields(dateOfMonth);
            builder.setTimeDateMonth(localDate);
            //按小时
            calendar.clear();
            calendar.setTime(time.toDate());
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            DateTime dtHour = new DateTime(calendar.getTime());
            builder.setTimeDateHour(dtHour);
            //按周
            calendar.set(Calendar.DAY_OF_WEEK,1);
            LocalDate ldWeek = LocalDate.fromDateFields(calendar.getTime());
            builder.setTimeDateWeek(ldWeek);
            calendar.clear();
         //按分钟:
            calendar.setTime(time.toDate());
            calendar.set(Calendar.SECOND, 0);
            DateTime dMinute = new DateTime(calendar.getTime());
            builder.setTimeDateHourMinute(dMinute);

            //整个时间
            builder.setTimeDatetime(new DateTime(time));
            //至今毫秒数:
            builder.setTimeMillis(time.getMillis());
            list.add(builder.build());

        }
        DatumWriter<github_events> userDatumWriter = new SpecificDatumWriter<github_events>(github_events.class);
        DataFileWriter<github_events> dataFileWriter = new DataFileWriter<github_events>(userDatumWriter);
        dataFileWriter.setCodec(CodecFactory.snappyCodec());
        String path = "./game-analyse.avro.snappy"; // avro文件存放目录
        dataFileWriter.create(list.get(0).getSchema(),  new File(path));
        // 把生成的user对象写入到avro文件
        for(github_events build:list){
            dataFileWriter.append(build);
        }
        dataFileWriter.close();
    }


    @Test
    public void testProcess() throws Exception{
        HDFSUtils util = new HDFSUtils();
        AvroTask avroTask = new AvroTask();


        util.download("bigdata","/analytics/testdata/githubarchive/source/yearly/2015/2015-01-16-19.json.gz");
        String uploadname= avroTask.ExcuteAvroTask("2015-01-16-19.json.gz");
        util.upload("spark",uploadname,"/warehouse/game_analysis.db/songxiang_avro/time_date=2015-01-16/"+uploadname);
    }

}