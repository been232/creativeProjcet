package Project.Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicDAOImpl implements BasicDAO {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://14.45.204.156:3306/project?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
    static final String USER = "shj";
    static final String PW = "tmdgus9435";
    public Connection conn = null;

    static {
        try {
            Class.forName(DRIVER);
        } catch(ClassNotFoundException e) {
            System.out.println("MySql JDBC Driver 로딩 실패");
            e.printStackTrace();
        }
    }

    @Override
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USER, PW);
            //System.out.println("연결성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}