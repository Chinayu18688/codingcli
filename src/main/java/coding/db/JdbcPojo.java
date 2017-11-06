package coding.db;

/**
 * Created by zhangyu on 2017/11/5.
 */
public class JdbcPojo{

    private String dbUrl;
    private String dbDriver;
    private String dbUsername;
    private String dbPassword;

    public JdbcPojo() {
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    @Override
    public String toString() {
        return "JdbcPojo{" +
                "dbUrl='" + dbUrl + '\'' +
                ", dbDriver='" + dbDriver + '\'' +
                ", dbUsername='" + dbUsername + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                '}';
    }
}
