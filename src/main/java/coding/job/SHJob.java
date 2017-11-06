package coding.job;


import coding.db.JdbcPojo;
import coding.db.JdbcUtil;
import coding.db.TableInfo;
import coding.freemarker.FreemarkerUtil;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by zhangyu on 2017/11/5.
 * SH表示应用spring mvc+hibernate构建的应用
 */
public class SHJob extends Job{

    public SHJob(JdbcPojo jdbcPojo) {
        super(jdbcPojo);
        jdbcPojo.toString();
    }

    @Override
    public void execJob() throws SQLException {
        super.execJob();
        List<TableInfo> tableInfo=JdbcUtil.getTableInfos(super.connection);
        //生成pojo
        FreemarkerUtil.processTemplate("test.flt",null,null);
    }
}
