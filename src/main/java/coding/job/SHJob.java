package coding.job;


import coding.db.ColumnInfo;
import coding.db.JdbcPojo;
import coding.db.JdbcUtil;
import coding.db.TableInfo;
import coding.exception.TemplateException;
import coding.freemarker.FreemarkerUtil;
import coding.freemarker.StringUril;
import coding.service.ProcessManager;
import coding.service.Task;

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
    public void execJob() throws Exception {
        super.execJob();
    }

    @Override
    public Map<String, Object> outputParams()  {
        Map<String,Object> root=new HashMap<String, Object>();
        root.put("package","com.buc.gamemust.game");
        TableInfo tableInfo=super.tablesInfo.get("user");
        root.put("table",tableInfo);
        root.put("className", StringUril.camelCaseFirstUpper(tableInfo.getTableName(),"_"));
        List<ColumnInfo> columns=tableInfo.getColumnInfos();
        root.put("columnsList",columns);
        root.put("tableName",tableInfo.getTableName().toUpperCase());
        return root;
    }

    @Override
    public List<Task> setTask() throws Exception{
        List<Task> tasks=new ArrayList<Task>();
        Task task1=ProcessManager.matchTemplate("com/buc/gamemust/game/","TGame.java","sh-entity.ftl");
        //Task task2=ProcessManager.matchTemplate("com.buc.gamemust.game","Game.java","sh-pojo.ftl");
        tasks.add(task1);
        //tasks.add(task2);
        return tasks;
    }
}
