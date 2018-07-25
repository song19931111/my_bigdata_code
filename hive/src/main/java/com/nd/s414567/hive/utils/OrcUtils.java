package com.nd.s414567.hive.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.orc.OrcFile;
import org.apache.orc.Reader;
import org.apache.orc.TypeDescription;

import java.io.IOException;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/20
 */
public class OrcUtils {


    /**
     *
     * @param path1
     * @param path2
     * @return 0 same 1 large than  -1 more than
     */
    public static int Compare(String path1,String path2) throws IOException {

        Configuration conf = new Configuration();
        conf.set("hive.exec.orc.default.compress","SNAPPY");
        Reader reader1 = OrcFile.createReader(new Path(path1), OrcFile.readerOptions(conf));
        Reader reader2 = OrcFile.createReader(new Path(path2), OrcFile.readerOptions(conf));
        TypeDescription schema1 = reader1.getSchema();
        TypeDescription schema2 = reader2.getSchema();


        return 0;
    }




}
