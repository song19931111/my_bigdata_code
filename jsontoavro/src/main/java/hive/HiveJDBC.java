package hive;

import org.apache.hadoop.security.UserGroupInformation;

import java.security.PrivilegedExceptionAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/08
 */
public class HiveJDBC {


    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void  main(String args[]) throws  Exception{

        Class.forName(driverName);

        System.setProperty("HADOOP_USER_NAME","hadoop");
        System.out.println(UserGroupInformation.getCurrentUser());
        System.out.println(UserGroupInformation.getLoginUser());
        System.out.println(UserGroupInformation.getLoginUser());
        UserGroupInformation loginUser = UserGroupInformation.getLoginUser();
        loginUser.doAs(new PrivilegedExceptionAction<Long>() {

            @Override
            public Long run() throws Exception {
                Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.19.27:10000/game_analysis;hive.server2.proxy.user=spark", "spark", "123abc,.");

                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("select count(event_id) from songxiang_avro where time_date='2015-01-01' limit 10");
                while(resultSet.next()){
                    System.out.println(resultSet.getObject(1));
                }
                resultSet.close();
                stmt.close();
                conn.close();


                return 1L;
            }
        });


    }
}
