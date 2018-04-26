package sqlSession;

import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/26 at 17:37
 */

public class MyExecutor implements Executor {

    MyConfiguration configuration = new MyConfiguration();

    @Override
    public <T> T query(String statement, Object parameter) {
        Connection connection = getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(statement);
            ps.setString(1, parameter.toString());
            rs = ps.executeQuery();
            //
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));

            }
            return (T) user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e) {
                    e.printStackTrace();
            }
        }
        return null;
    }

    private Connection getConnection() {
        Connection connection = configuration.build("config.xml");
        return connection;
    }
}
