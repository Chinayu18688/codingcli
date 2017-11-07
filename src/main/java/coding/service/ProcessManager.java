package coding.service;

import coding.exception.TemplateException;

import java.util.*;

/**
 * 流程管理者
 * 将用户定义路程转换成process
 * Created by 宇 on 2017/11/7.
 */
public class ProcessManager {


    protected static Map<String,Template> templateMap;

    static {
        templateMap=new HashMap<String, Template>();
    }

    public static Task matchTemplate(String packagePath, String fileName, String templateName) throws TemplateException {
        Task task;
        Template template=templateMap.get(templateName);
        if(template!=null){
            task=new Task(packagePath,template,fileName);
        }else{
            throw new TemplateException("Template does not exist");
        }
        return task;
    }




}
