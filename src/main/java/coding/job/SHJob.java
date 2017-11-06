package coding.job;


import coding.db.ColumnInfo;
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
        Map<String,Object> root=new HashMap<String, Object>();
        root.put("package","com.buc.epg");
        root.put("modal","user");
        root.put("className",tableInfo.get(0).getTableName());
        List<String> columns=new ArrayList<String>();
        for(ColumnInfo columnInfo:tableInfo.get(0).getColumnInfos()){
            columns.add(columnInfo.getColumnName());
        }
        root.put("columnList",columns);
        root.put("upperTableName",tableInfo.get(0).getTableName().toUpperCase());
        //生成pojo
        FreemarkerUtil.processTemplate("sh-entity.flt",null,"/Volumes/BANQ/freemakerDir/entity.java",root);
    }
}
