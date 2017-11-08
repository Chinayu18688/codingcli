package coding.freemarker.function;

import coding.freemarker.StringUril;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * Created by 宇 on 2017/11/8.
 */
public class CamelFirstUpperMethod implements TemplateMethodModelEx{
    public Object exec(List args) throws TemplateModelException {
        if(args != null && args.size()>0) {
            String arg=args.get(0).toString();
            return StringUril.camelCaseFirstUpper(arg,"_");
        }else{
            throw new TemplateModelException("The column name format conversion parameter is incorrect");
        }
    }

}
