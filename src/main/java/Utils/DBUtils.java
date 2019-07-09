package Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static String className = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;


    static {
        Properties properties = new Properties();
        try {
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            className = properties.getProperty("className");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static Connection getConnection(){
        Connection Connection = null;
        try {
            Class.forName(className);
            Connection = DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Connection;
    }
}
