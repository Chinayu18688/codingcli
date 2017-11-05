package coding.db;

/**
 * Created by zhangyu on 2017/11/5.
 */
public class JdbcUtil {
    private static JdbcPojo jdbcPojo;

    public static synchronized JdbcPojo getInstance() {
        if (jdbcPojo == null)
            jdbcPojo = new JdbcPojo();
        return jdbcPojo;
    }
}
