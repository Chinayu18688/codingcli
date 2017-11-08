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
        root.put("package","com.buc.gamemust");
        TableInfo tableInfo=super.tablesInfo.get("t_test");
        root.put("table",tableInfo);
        System.out.println(tableInfo.toString());
        List<ColumnInfo> columns=tableInfo.getColumnInfos();
        root.put("columnsList",columns);
        root.put("module","user_info");
        root=plusDefalutFunction(root);//添加默认方法
        return root;
    }

    @Override
    public List<Task> setTask() throws Exception{
        List<Task> tasks=new ArrayList<Task>();
        //Task task1=ProcessManager.matchTemplate("com/buc/gamemust/game/","TGame.java","SH/sh-entity.ftl");
        //Task task2=ProcessManager.matchTemplate("com.buc.gamemust.game","Game.java","sh-pojo.ftl");
        Task task3=ProcessManager.matchTemplate("com/buc/gamemust/","UserInfoController.java","mrs/controller/controller.ftl");
        Task task4=ProcessManager.matchTemplate("com/buc/gamemust/","UserInfo.java","mrs/entity/pojo.ftl");
        Task task9=ProcessManager.matchTemplate("com/buc/gamemust/","TUserInfo.java","mrs/entity/entity.ftl");
        Task task5=ProcessManager.matchTemplate("com/buc/gamemust/","UserInfoServiceImpl.java","mrs/service/impl/serviceImpl.ftl");
        Task task6=ProcessManager.matchTemplate("com/buc/gamemust/","UserInfoService.java","mrs/service/service.ftl");
        Task task7=ProcessManager.matchTemplate("com/buc/gamemust/","UserInfoDao.java","mrs/dao/dao.ftl");
        Task task8=ProcessManager.matchTemplate("com/buc/gamemust/","UserInfoDaoImpl.java","mrs/dao/impl/daoImpl.ftl");
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task9);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);
        //tasks.add(task8);
        return tasks;
    }
}
