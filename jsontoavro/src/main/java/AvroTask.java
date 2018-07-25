import cn.nd.bigdata.analytics.github_events;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/07
 */
public class AvroTask implements  IAvroToThread{

    public String ExcuteAvroTask(String path) throws Exception {
        File file = new File(path);
        BufferedReader read = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(file))));
        String line  = StringUtils.EMPTY;
        List<github_events> list = new ArrayList<>();
        github_events.Builder builder = github_events.newBuilder();
        Integer i=0;
        while (StringUtils.EMPTY != (line= read.readLine()) && line != null){

            if(line.matches("^(\\s*)") || line == null){
                continue;
            }
            JSONObject json = JSON.parseObject(line);
          //  System.out.println(i++);
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
            Date dateOfMonth= calendar.getTime();
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
            builder.setTimeDate(LocalDate.fromDateFields(time.toDate()));
            list.add(builder.build());

        }
        DatumWriter<github_events> userDatumWriter = new SpecificDatumWriter<github_events>(github_events.class);
        DataFileWriter<github_events> dataFileWriter = new DataFileWriter<github_events>(userDatumWriter);
        dataFileWriter.setCodec(CodecFactory.snappyCodec());
        String writepath = path+".avro.snappy"; // avro文件存放目录
        dataFileWriter.create(list.get(0).getSchema(),  new File(writepath));
        // 把生成的user对象写入到avro文件
        for(github_events build:list){
            dataFileWriter.append(build);
        }
        dataFileWriter.close();
        return writepath;
    }
    public void excute(String path) throws  Exception{
        HDFSUtils util = new HDFSUtils();
        String arr[] = path.split("/");
        String filename = arr[arr.length-1];
        util.download("bigdata",path);
        String localPath= ExcuteAvroTask(filename);
        String uploadPath = HDFSUtils.HDFS_URL+"/user/spark"+"/warehouse/game_analysis.db/songxiang_avro/time_date="+filename.substring(0,10)+"/"+localPath;
        util.upload("spark",localPath,uploadPath);
    }
}
