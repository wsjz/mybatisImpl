import java.sql.*;
import java.util.Properties;
/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/26 at 16:26
 */

public class MariaDB {
    private static final String dbClassName = "org.mariadb.jdbc.Driver";
    private static final String CONNECTION =
            "jdbc:mariadb://localhost:3307/test";
    public static void main(String[] args) throws
            ClassNotFoundException,SQLException
    {
//        System.out.println(dbClassName);
//        Class.forName(dbClassName);
        Properties p = new Properties();
        p.put("user","root");
        p.put("password","123456");
        // Now try to connect
        Connection c = DriverManager.getConnection(CONNECTION,p);
        PreparedStatement sql = c.prepareStatement("select * from USER");
        System.out.println("It works !");
        ResultSet rs = sql.executeQuery();
        rs.next();
        System.out.println(rs.getString(2));
        c.close();
    }
}

