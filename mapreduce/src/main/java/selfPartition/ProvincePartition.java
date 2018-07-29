package selfPartition;

import flowcount.MapReduceClass;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

/**
 * Copyright@XiangSongNd.
 * Author:XiangSong
 * Date:2018/7/28
 * Description:
 */
public class ProvincePartition extends Partitioner<Text, MapReduceClass.FlowBean> {

    public static HashMap<String,Integer>provinceDict  = new HashMap<String, Integer>(){{
        put("136",0);
        put("137",1);
        put("138",2);
        put("139",3);
    }};
    static {

    }
    @Override
    public int getPartition(Text text, MapReduceClass.FlowBean flowBean, int i) {
            String prefix = text.toString().substring(0,3);
            Integer provinceId= provinceDict.get(prefix);
            if(provinceId == null){
                return Integer.parseInt(prefix);
            }else{
                return provinceId;
            }
    }
}
