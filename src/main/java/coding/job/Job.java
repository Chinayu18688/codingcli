package coding.job;

import coding.db.JdbcPojo;
import coding.db.JdbcUtil;
import coding.db.TableInfo;
import coding.exception.TemplateException;
import coding.freemarker.FreemarkerUtil;
import coding.service.Task;
import java.sql.*;
import java.util.*;
/**
 * Created by zhangyu on 2017/11/5.
 */
public abstract class Job implements UDFreemarker{

    public JdbcPojo jdbcPojo;

    public Connection connection = null;
    public PreparedStatement preparedStatement = null;
    private ResultSet resultSet=null;

    Map<String,TableInfo> tablesInfo=new HashMap<String, TableInfo>();

    public Job(JdbcPojo jdbcPojo) {
        this.jdbcPojo = jdbcPojo;
    }

    /**
     * 建立连接
     * @return
     */
    public Connection getConnection() {
        try {
            jdbcPojo.toString();
            Class.forName(jdbcPojo.getDbDriver()); // 注册驱动
            connection = DriverManager.getConnection(
                    jdbcPojo.getDbUrl(), jdbcPojo.getDbUsername(), jdbcPojo.getDbPassword()); // 获取连接
        } catch (Exception e) {
            throw new RuntimeException("get connection error!", e);
        }
        return connection;
    }

    public void initializationJob() throws Exception {
        getConnection();
        initBaseParams();//初始化基本参数
        execJob();
        releaseConnection();
    }

    public void initBaseParams() throws SQLException {
        tablesInfo= JdbcUtil.getTablesInfo(connection);
    }

    /**
     * 写自己的执行过程
     */
    public void execJob() throws Exception {
        Map<String,Object> root=outputParams();
        List<Task> tasks=setTask();
        //执行任务
        execTasks(tasks,root);
    }

    /**
     * 执行任务计划
     * @param tasks
     * @param root
     */
    public static void execTasks(List<Task> tasks, Map<String, Object> root) {
        if(tasks!=null && tasks.size()>0){
            for(Task task:tasks){
                //验证计划可执行性(创建文件夹)
                FreemarkerUtil.processTemplate(
                        task.getTemplate().getName(),
                        task.getTemplate().getPath(),
                        task.getOutputPath()+task.getOutputFileName(),root);
            }
        }else{
            System.out.println("No task end execution was found");
        }
    }


    /**
     * 必须覆盖实现
     * 这里可以使用的基本参数tablesInfo包括表数据信息
     * 其他参数需要用户自定义传输
     * @return
     * @throws TemplateException
     */
    public Map<String, Object> outputParams() throws Exception {
        System.out.println("开始设置参数模板使用的参数...");
        return null;
    }

    /**
     * 必须覆盖实现
     * @return
     */
    public List<Task> setTask() throws Exception{
        System.out.println("开始规划任务方案...");
        return null;
    }

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
