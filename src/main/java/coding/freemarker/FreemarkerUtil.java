package coding.freemarker;

import freemarker.template.*;

import java.io.*;
import java.util.*;

/**
 * Created by 宇 on 2017/11/6.
 */
public class FreemarkerUtil {
    private static Configuration config = new Configuration();

    public static void processTemplate(String templateName, Map<String, String> root, Writer out){
        try{
            //System.out.println(System.getProperty("user.dir"));
            //System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
            File f=new File(System.getProperty("user.dir")+ "/template/");
            config.setDirectoryForTemplateLoading(f);
            config.setObjectWrapper(new DefaultObjectWrapper());
            config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            root=new HashMap();
            root.put("tableName","hello world");
            Template template=config.getTemplate(templateName,"utf-8");
            File file = new File("D:/helloworld.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();
            //template.process(root, out);
            /*out.flush();
            out.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
