import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.*;
import java.net.URI;
import java.security.PrivilegedExceptionAction;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/07
 */
public class HDFSUtils {

    public static final String HDFS_URL = "hdfs://192.168.19.25:11000";

    public  void upload(String username,String localPath,String uploadPath) throws Exception{
        System.setProperty("HADOOP_USER_NAME",username);
        Configuration conf = new Configuration();
        UserGroupInformation createProxyUser =UserGroupInformation.createProxyUser(username,UserGroupInformation.getCurrentUser());
        createProxyUser.doAs(new PrivilegedExceptionAction<Long>() {
            @Override
            public Long run() throws Exception {
                FileSystem fs = FileSystem.get(URI.create(HDFS_URL),conf,username);
                long written =0L;
                File f = new File(localPath);
                FileInputStream fileInputStream = new FileInputStream(f);
                //String relative =uploadPath;
                //Path target = Path.mergePaths(fs.getHomeDirectory(),new Path(relative));
                FSDataOutputStream outputStream = fs.create(new Path(uploadPath));
                IOUtils.copyBytes(fileInputStream,outputStream,4096);
                outputStream.close();
                fileInputStream.close();
                fs.close();
                return written;
            };
        });
    };
    public void download(String username,String path) throws  Exception{

        Configuration conf = new Configuration();
        System.setProperty("HADOOP_USER_NAME",username);
        UserGroupInformation createProxyUser =UserGroupInformation.createProxyUser(username,UserGroupInformation.getCurrentUser());
        createProxyUser.doAs(new PrivilegedExceptionAction<Long>() {
            @Override
            public Long run() throws Exception {
                FileSystem fs = FileSystem.get(URI.create(HDFS_URL),conf,username);

                long written = 0;
                    String []arrTemp =  path.split("/");
                    String fileName = arrTemp[arrTemp.length-1];
                    InputStream fsDataInputStream = fs.open(new Path(path));
                    OutputStream fileOutputStream = new FileOutputStream(new File(fileName));
                    IOUtils.copyBytes(fsDataInputStream,fileOutputStream,4096,true);
                fs.close();
                return written;
                }
        });

    }
}
