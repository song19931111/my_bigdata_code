import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Copyright@XiangSongNd.
 * Author:XiangSong
 * Date:2018/7/23
 * Description:
 */

/**
 * 输入key 输入value  输出key 输出value
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split(" ");
        for(String word:split){
            context.write(new Text(word),new IntWritable(1));
        }

    }
}
