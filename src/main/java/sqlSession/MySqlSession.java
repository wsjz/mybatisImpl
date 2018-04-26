package sqlSession;

import bean.User;
import mapper.UserMapper;

import java.lang.reflect.Proxy;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/26 at 17:34
 */

public class MySqlSession {
    private Executor excutor = new MyExecutor();
    private MyConfiguration configuration = new MyConfiguration();

    public <T> T selectOne(String statement, Object parameter) {
        return excutor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MyMapperProxy(configuration,this));
    }

    public static void main(String[] args) {
        MySqlSession session=new MySqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById("1");
        System.out.println(user);
    }



}
