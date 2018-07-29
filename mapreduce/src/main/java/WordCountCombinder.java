import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Copyright@XiangSongNd.
 * Author:XiangSong
 * Date:2018/7/29
 * Description:
 */
public class WordCountCombinder  extends Reducer<Text,IntWritable,Text,IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum =  0;
        for(IntWritable value:values){
            sum+=value.get();
        }
        context.write(key,new IntWritable(sum));

    }
}
