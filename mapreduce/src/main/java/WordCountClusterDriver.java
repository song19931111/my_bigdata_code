import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Copyright@XiangSongNd.
 * Author:XiangSong
 * Date:2018/7/23
 * Description:
 */
public class WordCountClusterDriver {

    public static void main(String []args) throws IOException, ClassNotFoundException, InterruptedException {


        Configuration conf = new Configuration();

        System.setProperty("HADOOP_USER_NAME","hadoop");
        //提交到本地:
        conf.set("mapreduce.framework.name", "yarn");
        conf.set("fs.defaults", "hdfs://192.168.199.200:9000");
        conf.set("yarn.resourcemanager.hostname","192.168.199.200:8032");
//        conf.set("mapreduce.framework.name","yarn");
//        conf.set("yarn.resourcemanager.hostname","192.168.199.200:8032");
       // System.setProperty("HADOOP_USER","hadoop");
        Job job = Job.getInstance(conf);

        //job.setJarByClass(WordCountClusterDriver.class);
       job.setJar("D:\\bigdata\\mapreduce\\target\\mapreduce-1.0.0-jar-with-dependencies.jar");
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //制定需要combinder:
        job.setCombinerClass(WordCountCombinder.class);


        //如果不设置，默认InputFormat
      //  job.setInputFormatClass(CombineFileInputFormat.class);
        //CombineFileInputFormat.setMaxInputSplitSize();
        //CombineFileInputFormat.setMinInputSplitSize();

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));





        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);
    }
}
