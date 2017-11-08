package coding.db;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 时间比较仅，这个jdbc工具类缺少很多很多功能
 * 甚至定义的tableInfo columnInfo两个类缺少大量的相关字段
 * 由于本人对jdbc甚至说是对表的高级功能理解有限
 * 其他高级功能一点点的补充
 * 本类需要重构
 * Created by zhangyu on 2017/11/5.
 */
public class JdbcUtil {
    private static JdbcPojo jdbcPojo;

    public static synchronized JdbcPojo getInstance() {
        if (jdbcPojo == null)
            jdbcPojo = new JdbcPojo();
        return jdbcPojo;
    }

    /**
     * 获取数据库中所有的表名List
     * @param connection
     * @return
     */
    public static List<TableInfo> getTableInfos(Connection connection) throws SQLException {
        System.out.println("Start reading table structure information");
        List<TableInfo> tables=new ArrayList<TableInfo>();
        DatabaseMetaData metaData=connection.getMetaData();
        ResultSet tableRet = metaData.getTables(null, "%","%",new String[]{"TABLE"});
        while(tableRet.next()) {
            TableInfo tableInfo=new TableInfo();
            tableInfo.setTableName(tableRet.getString("TABLE_NAME"));
            tableInfo.setTableType(tableRet.getString("TABLE_TYPE"));
            tableInfo.setColumnInfos(getColumnsInfos(connection,tableInfo.getTableName()));
            String pkColumnName=getPkColumnName(connection,tableInfo.getTableName());
            tableInfo.setPkColumnName(pkColumnName);//设置主键
            tables.add(tableInfo);
            //System.out.println(tableInfo.toString());
        }
        return tables;
    }

    public static List<TableInfo> getTableInfoByTableName(Connection connection,String tableName) throws SQLException {
        System.out.println("Start reading table structure information");
        List<TableInfo> tables=new ArrayList<TableInfo>();
        DatabaseMetaData metaData=connection.getMetaData();
        ResultSet tableRet = metaData.getTables(null, "%",tableName,new String[]{"TABLE"});
        while(tableRet.next()) {
            TableInfo tableInfo=new TableInfo();
            tableInfo.setTableName(tableRet.getString("TABLE_NAME"));
            tableInfo.setTableType(tableRet.getString("TABLE_TYPE"));
            tableInfo.setColumnInfos(getColumnsInfos(connection,tableInfo.getTableName()));
            String pkColumnName=getPkColumnName(connection,tableInfo.getTableName());
            tableInfo.setPkColumnName(pkColumnName);//设置主键
            System.out.println(tableInfo.toString());
            tables.add(tableInfo);
        }
        return tables;
    }

    /**
     * 获取表主键
     * 这里有个问题：一张表能有很多主键吗？为啥jdbc中要使用set集合
     * @param connection
     * @param tableName
     * @return
     * @throws SQLException
     */
    public static String getPkColumnName(Connection connection,String tableName) throws SQLException {
        System.out.println("The primary key name in the query table");
        DatabaseMetaData metaData=connection.getMetaData();
        ResultSet primaryKeyResultSet = metaData.getPrimaryKeys(connection.getCatalog(),null,tableName);
        String primaryKeyColumnName = null;
        while(primaryKeyResultSet.next()){
            primaryKeyColumnName = primaryKeyResultSet.getString("COLUMN_NAME");
        }
        System.out.println("Current table primary key name is "+primaryKeyColumnName);
        return primaryKeyColumnName;

    }

    /**
     * 获取列信息
     * @param connection
     * @param tableName
     * @return
     */
    public static List<ColumnInfo> getColumnsInfos(Connection connection,String tableName) throws SQLException{
        System.out.println("Start reading column information");
        List<ColumnInfo> columnInfos=new ArrayList<ColumnInfo>();
        DatabaseMetaData metaData=connection.getMetaData();
        ResultSet colRet = metaData.getColumns(null,"%", tableName ,"%");
        while(colRet.next()) {
            ColumnInfo columnInfo=new ColumnInfo();
            columnInfo.setColumnName(colRet.getString("COLUMN_NAME"));
            columnInfo.setColumnSize(colRet.getInt("COLUMN_SIZE"));
            columnInfo.setNullAble(colRet.getInt("NULLABLE"));
            columnInfo.setTypeName(colRet.getString("TYPE_NAME"));
            columnInfo.setPemark(colRet.getString("REMARKS"));
            columnInfos.add(columnInfo);
        }
        return columnInfos;
    }

    public static Map<String,TableInfo> getTablesInfo(Connection connection) throws SQLException {
        Map<String,TableInfo> tablesInfo=new HashMap<String, TableInfo>();
        List<TableInfo> tableInfos= JdbcUtil.getTableInfos(connection);
        if(tableInfos!=null && tableInfos.size()>0){
            for(TableInfo tableInfo:tableInfos){
                tablesInfo.put(tableInfo.getTableName(),tableInfo);
            }
        }
        return tablesInfo;
    }

    /**
     * 获取单张表信息
     * @param connection
     * @param tableName
     * @return
     * @throws SQLException
     */
    public static Map<String,TableInfo> getTableInfo(Connection connection,String tableName) throws SQLException {
        Map<String,TableInfo> tablesInfo=new HashMap<String, TableInfo>();
        List<TableInfo> tableInfos= JdbcUtil.getTableInfoByTableName(connection,tableName);
        if(tableInfos!=null && tableInfos.size()>0){
            for(TableInfo tableInfo:tableInfos){
                tablesInfo.put(tableInfo.getTableName(),tableInfo);
            }
        }
        return tablesInfo;
    }
}
