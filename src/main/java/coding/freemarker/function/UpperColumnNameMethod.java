package coding.freemarker.function;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 宇 on 2017/11/8.
 */
public class UpperColumnNameMethod implements TemplateMethodModelEx{


    public  Object exec(List args) throws TemplateModelException {
       if(args != null && args.size()>0) {
           String arg=args.get(0).toString();
           return arg.toUpperCase();
       }else{
           throw new TemplateModelException("The column name conversion parameter is incorrect");
       }
    }


}



