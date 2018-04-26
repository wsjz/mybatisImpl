package config;

import sqlSession.Function;

import java.util.List;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/26 at 17:05
 */

public class MapperBean {
    private String interfaceName;
    private List<Function> list;

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public List<Function> getList() {
        return list;
    }

    public void setList(List<Function> list) {
        this.list = list;
    }
}
