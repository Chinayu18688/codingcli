package coding.db;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    /**
     * 获取数据库中所有的表名List
     * @param connection
     * @return
     */
    public static List<TableInfo> getTableInfos(Connection connection) throws SQLException {
        List<TableInfo> tableNames=new ArrayList<TableInfo>();
        DatabaseMetaData metaData=connection.getMetaData();
        ResultSet tableRet = metaData.getTables(null, "%","%",new String[]{"TABLE"});
        while(tableRet.next()) {
            TableInfo tableInfo=new TableInfo();
            tableInfo.setTableName(tableRet.getString("TABLE_NAME"));
            tableInfo.setTableType(tableRet.getString("TABLE_TYPE"));
            tableInfo.setColumnInfos(getColumnsInfos(connection,tableInfo.getTableName()));
            System.out.println(tableInfo.toString());
        }
        return tableNames;
    }

    /**
     * 获取列信息
     * @param connection
     * @param tableName
     * @return
     */
    public static List<ColumnInfo> getColumnsInfos(Connection connection,String tableName) throws SQLException{
        List<ColumnInfo> columnInfos=new ArrayList<ColumnInfo>();
        DatabaseMetaData metaData=connection.getMetaData();
        ResultSet colRet = metaData.getColumns(null,"%", tableName ,"%");
        while(colRet.next()) {
            ColumnInfo columnInfo=new ColumnInfo();
            columnInfo.setColumnName(colRet.getString("COLUMN_NAME"));
            columnInfo.setColumnSize(colRet.getInt("COLUMN_SIZE"));
            columnInfo.setNullAble(colRet.getInt("NULLABLE"));
            columnInfo.setTypeName(colRet.getString("TYPE_NAME"));
            System.out.println(columnInfo.toString());
            columnInfos.add(columnInfo);
        }
        return columnInfos;
    }
}
