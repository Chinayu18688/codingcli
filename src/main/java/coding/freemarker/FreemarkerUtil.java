package coding.freemarker;

import coding.conf.Config;
import freemarker.template.*;

import java.io.*;
import java.util.*;

/**
 * Created by 宇 on 2017/11/6.
 */
public class FreemarkerUtil {
    private static Configuration config = new Configuration();

    public static void configInstall(){
        config.setObjectWrapper(new DefaultObjectWrapper());
        config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
    }

    public static void processTemplate(String templateName,String templatePath,String outputPath, Map<String, Object> root){
        try{
            if(templatePath!=null && !templatePath.equals("")){
                //指定模版位置
            }else{
                templatePath= Config.confs.get("template_path");//获取默认模版地址
            }
            File f=new File(templatePath);
            configInstall();
            config.setDirectoryForTemplateLoading(f);
            Template template=config.getTemplate(templateName,"utf-8");
            File file = new File(outputPath);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
