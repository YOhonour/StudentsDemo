package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBUtil {

    private static final String ip = "127.0.0.1";
    private static final String loginName = "root";
    private static final String password = "123456zaq";
    private static final String URL = "jdbc:mysql://localhost:3306/JDBCdemo?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT&userSSL=false";

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        //String url = String.format("jdb%s", ip, port, database, encoding);c:mysql://%s:%d/%s?characterEncoding=
        return DriverManager.getConnection(URL, loginName, password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());

    }

}