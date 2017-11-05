package coding.job;

import coding.db.JdbcPojo;

import java.sql.*;

/**
 * Created by zhangyu on 2017/11/5.
 */
public abstract class Job {

    public JdbcPojo jdbcPojo;

    public Connection connection = null;
    public PreparedStatement preparedStatement = null;
    private ResultSet resultSet=null;

    public Job(JdbcPojo jdbcPojo) {
        this.jdbcPojo = jdbcPojo;
    }

    /**
     * 建立连接
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName(jdbcPojo.getDbDriver()); // 注册驱动
            connection = DriverManager.getConnection(
                    jdbcPojo.getDbUrl(), jdbcPojo.getDbUsername(), jdbcPojo.getDbPassword()); // 获取连接
        } catch (Exception e) {
            throw new RuntimeException("get connection error!", e);
        }
        return connection;
    }

    public void initializationJob() throws SQLException {
        getConnection();
        execJob();
        releaseConnection();
    }

    /**
     * 写自己的执行过程
     */
    public void execJob() throws SQLException {};


    /**
     * 释放资源
     */
    public void releaseConnection() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
