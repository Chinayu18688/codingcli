package coding.job;

import coding.exception.TemplateException;
import coding.service.Task;

import java.util.*;

/**
 * Created by 宇 on 2017/11/7.
 */
public interface UDFreemarker {
    /**
     * 输出模板中参数设置
     * @return
     */
    public Map<String,Object> outputParams() throws Exception;

    /**
     * 任务设置
     * 包括包路径设置
     * 包中模板选择，输出路径匹配信息
     * ps：流程语法
     * @return
     */
    public List<Task> setTask() throws Exception;

}
