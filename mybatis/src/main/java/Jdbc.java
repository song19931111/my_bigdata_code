import java.sql.*;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/12
 */
public class Jdbc {




    public static  void main(String args[]) throws  Exception{

        Connection connection = null;
        Statement statement = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接:
             connection = DriverManager.getConnection("jdbc:mysql://120.77.82.142:3306/business?characterEncoding=utf8", "root", "3167309qq");
            //获取Statement:
             statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from bus_user");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
            }
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }



    }
}
