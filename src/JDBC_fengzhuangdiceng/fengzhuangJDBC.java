package JDBC_fengzhuangdiceng;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class fengzhuangJDBC {
        static  Properties properties;//必须公共
        static {//连接配置文件
            properties = new Properties();
            ClassLoader classLoader = fengzhuangJDBC.class.getClassLoader();
            InputStream input = classLoader.getResourceAsStream("fengzhuang.properties");
            try {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //封装连接数据库方法
    public static Connection lianjie() throws ClassNotFoundException, SQLException {
            Class.forName(properties.getProperty("Driver"));
            String lj = properties.getProperty("connection");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

        return DriverManager.getConnection(lj, user, password);
    }
    //封装关闭资源方法
    public static void close(Connection connection, Statement statement,ResultSet resultSet){
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

}
