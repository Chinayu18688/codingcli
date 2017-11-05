package coding.job;


import coding.db.JdbcPojo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangyu on 2017/11/5.
 * SH表示应用spring mvc+hibernate构建的应用
 */
public class SHJob extends Job{

    public SHJob(JdbcPojo jdbcPojo) {
        super(jdbcPojo);
    }

    @Override
    public void execJob() throws SQLException {
        super.execJob();
        DatabaseMetaData metaData=super.connection.getMetaData();
        ResultSet tableRet = metaData.getTables(null, "%","%",new String[]{"TABLE"});
        while(tableRet.next())
            System.out.println(tableRet.getString("TABLE_NAME"));
    }
}
