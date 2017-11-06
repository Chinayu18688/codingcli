package coding.conf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyu on 2017/11/6.
 */
public class Config {

    public static Map<String,String> confs=new HashMap<String, String>();

    /**
     * 默认模版路径
     */
    public static String template_path=System.getProperty("user.dir")+ "/template/";

    static {
        confs.put("template_path",template_path);
    }

}
