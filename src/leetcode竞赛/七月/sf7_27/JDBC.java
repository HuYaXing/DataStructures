package leetcode¾ºÈü.ÆßÔÂ.sf7_27;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @Author HYStar
 * @Date 2020/7/28 15:59
 */
public class JDBC {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test";
    static final String USER = "root";
    static final String PASS = "000000";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Person person = new Person("jack", "24", new SimpleDateFormat("yyy-MM-dd HH:mm:ss").parse("1995/10/24 00:00:00"));
            String inset_sql = "insert into person (name, age, birthday) values(?,?,?)";
            stm = conn.prepareStatement(inset_sql);

            stm.setString(1, person.getName());
            stm.setString(2, person.getAge());
            stm.setDate(3, new java.sql.Date(person.getBirthday().getTime()));

            int result = stm.executeUpdate();

            stm.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
