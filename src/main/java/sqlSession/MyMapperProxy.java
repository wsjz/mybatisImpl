package sqlSession;

import config.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/26 at 17:45
 */

public class MyMapperProxy implements InvocationHandler {
    private MySqlSession session;
    private MyConfiguration configuration;

    public MyMapperProxy(MyConfiguration configuration, MySqlSession session) {
        this.session = session;
        this.configuration = configuration;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean readMapper = configuration.readMapper("UserMapper.xml");
        if (!method.getDeclaringClass().getName().equals(readMapper.getInterfaceName())) {
            return null;
        }
        List<Function> list = readMapper.getList();
        if (list != null || list.size() != 0) {
            for (Function function : list) {
                if (method.getName().equals(function.getFuncName())) {
                    return session.selectOne(function.getSql(), String.valueOf(args[0]));
                }
            }
        }
        return null;
    }
}
