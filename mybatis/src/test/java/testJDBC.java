import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/12
 */
public class testJDBC {

    @Test
    public void testJDBC() throws SQLException {
        Connection connection = null;
        Statement statement = null;


    try{
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接:
        connection = DriverManager.getConnection("jdbc:mysql://120.77.82.142:3306/business?characterEncoding=utf8", "root", "3167309qq");
        //获取Statement:
        statement = connection.createStatement();

        boolean execute = statement.execute("insert into bus_user(username,password) values('aaanb','123')");
        connection.setAutoCommit(false);
        connection.commit();
    }catch (Exception e){

    }finally {
        statement.close();
        connection.close();
    }


    }
}
