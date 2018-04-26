package sqlSession;

/**
 * @author Created by Darling
 * @version CreatedDate: 2018/4/26 at 17:35
 */

public interface Executor {
    public <T> T query(String statement, Object parameter);
}
