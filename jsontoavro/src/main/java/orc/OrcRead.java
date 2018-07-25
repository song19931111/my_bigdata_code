package orc;

import com.alibaba.fastjson.JSON;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.exec.vector.BytesColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.apache.orc.OrcFile;
import org.apache.orc.Reader;
import org.apache.orc.RecordReader;
import org.apache.orc.TypeDescription;

import java.io.IOException;
import java.util.List;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/20
 */
public class OrcRead {



    public static  void main(String args[]) throws IOException {



        Configuration conf = new Configuration();
        conf.set("hive.exec.orc.default.compress","SNAPPY");
        Reader reader = OrcFile.createReader(new Path("hdfs://192.168.19.25:11000/user/spark/warehouse/game_analysis.db/github_orc/time_date=2015-01-01/000000_0"),
                OrcFile.readerOptions(conf));
        RecordReader rows = reader.rows();
        TypeDescription schema = reader.getSchema();
        List<String> fieldNames = schema.getFieldNames();
        System.out.println(schema.toJson());;
        List<TypeDescription> children = schema.getChildren();

        for(TypeDescription description:children){
            System.out.println(description.toJson());
        }


//        TypeDescription.Category category = schema.getCategory();
//        List<String> fieldNames = schema.getFieldNames();
//        schema.toJson();
//        System.out.println(category.getName());
        //String s = schema.toJson();



       // System.out.println(schema.toString());

        //System.out.println(s);
//      VectorizedRowBatch batch = reader.getSchema().createRowBatch();
//        //VectorizedRowBatch batch = new VectorizedRowBatch(24);
//
//
//        Integer i  = 0;
//        while (rows.nextBatch(batch)) {
//            for(int r=0; r < batch.size; ++r) {
//                //rows.seekToRow();
//                StringBuilder builder = new StringBuilder();
//
//
//                System.out.println(((BytesColumnVector)batch.cols[3]).toString(r));
//                i++;
//            }
//        }
//        System.out.println(i);
        rows.close();

    }


}
