package flowcount;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import selfPartition.ProvincePartition;

import java.io.IOException;

/**
 * Copyright@XiangSongNd.
 * Author:XiangSong
 * Date:2018/7/28
 * Description:
 */
public class MapReduceSort {

    public static  class FlowCountSortMapper extends Mapper<LongWritable,Text, MapReduceClass.FlowBean,Text>{


        static  MapReduceClass.FlowBean flowBean = new MapReduceClass.FlowBean();
        public static Text  v = new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String [] fields  = line.split("\t");
            String phoneNumber = fields[0];
            long upFlow = Long.parseLong(fields[1]);
            long dFlow = Long.parseLong(fields[2]);
            flowBean.setDownloadFlow(dFlow);
            flowBean.setUpFlow(upFlow);
            v.set(phoneNumber);
            //在输出的时候，虽然是同一个对象，但是write出去，会被序列化，
            context.write(flowBean,v);

        }

    }
    public  static  class FlowCountSortReducer extends Reducer<MapReduceClass.FlowBean,Text,Text, MapReduceClass.FlowBean>{
        @Override
        protected void reduce(MapReduceClass.FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
             //values只会有一个

            context.write(values.iterator().next(),key);
        }
    }


    public static  void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {

        Job job = Job.getInstance();

        job.setJarByClass(MapReduceSort.class);

        job.setMapperClass(FlowCountSortMapper.class);
        job.setReducerClass(FlowCountSortReducer.class);

        job.setMapOutputKeyClass(MapReduceClass.FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(MapReduceClass.FlowBean.class);
        job.setOutputValueClass(Text.class);


        //设置自定义分区:
        job.setPartitionerClass(ProvincePartition.class);
        //设置相应分区数量的reduce：
        job.setNumReduceTasks(1);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);




    }
}
