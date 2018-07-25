package flowcount;

import com.sun.tools.javac.comp.Flow;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Copyright@XiangSongNd.
 * Author:XiangSong
 * Date:2018/7/23
 * Description:
 */
public class MapReduceClass {

    public static class FlowBean implements Writable{
        private long upFlow;
        private long downloadFlow;
        private long sumFlow;
        //反序列化的时候，需要写空参数构造
        public FlowBean(){

        }
        public FlowBean(long upFlow, long downloadFlow) {
            this.upFlow = upFlow;
            this.downloadFlow = downloadFlow;
            sumFlow = upFlow+downloadFlow;
        }

        public long getUpFlow() {
            return upFlow;
        }

        public void setUpFlow(long upFlow) {
            this.upFlow = upFlow;
        }

        public long getDownloadFlow() {
            return downloadFlow;
        }

        public void setDownloadFlow(long downloadFlow) {
            this.downloadFlow = downloadFlow;
        }

        @Override
        public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeLong(upFlow);
            dataOutput.writeLong(downloadFlow);
        }

        @Override
        public void readFields(DataInput dataInput) throws IOException {
            this.upFlow = dataInput.readLong();
            this.downloadFlow = dataInput.readLong();
        }

        @Override
        public String toString() {
            return "FlowBean{" +
                    "upFlow=" + upFlow +
                    ", downloadFlow=" + downloadFlow +
                    ", sumFlow=" + sumFlow +
                    '}';
        }
    }


    public static class FlowMapper extends Mapper<LongWritable,Text,Text,FlowBean>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split("\t");
            String phoneNum =split[1];

            //获取上行流量
            long upload  = Long.parseLong(split[split.length-3]);
            //获取下行流量
            long down = Long.parseLong(split[split.length-2]);
            context.write(new Text(phoneNum),new FlowBean(upload,down));;
        }
    }
    public static  class FlowReducer extends Reducer<Text,FlowBean,Text,FlowBean>{
        @Override
        protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
            long sumUpLoad =  0;
            long sumDownload = 0 ;
            for(FlowBean flowBean:values){
                sumDownload +=flowBean.getDownloadFlow();
                sumDownload  +=flowBean.getUpFlow();
            }
            FlowBean flowBean = new FlowBean(sumUpLoad,sumDownload);
            context.write(key,flowBean);
        }
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
//        conf.set("mapreduce.framework.name","yarn");
//        conf.set("yarn.resourcemanager.hostname","192.168.199.200:8032");
        // System.setProperty("HADOOP_USER","hadoop");
        Job job = Job.getInstance();

        job.setJarByClass(MapReduceClass.class);

        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputKeyClass(FlowBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);

    }
}
