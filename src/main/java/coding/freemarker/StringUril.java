package coding.freemarker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提供一些字符串常用工具
 * Created by 宇 on 2017/11/7.
 */
public class StringUril {

    /**
     * 将有结构的英文转换成驼峰命名
     * 适用场景将表名生成类名
     * @param str
     * @param delimiter
     * @return
     */
    public static String camelCase(String str,String delimiter){
        if(str!=null && delimiter!=null){
            String[] names=str.split(delimiter);
            if(names != null && names.length > 0){
                if(names.length==1){
                    return names[0].toLowerCase();
                }else{
                    StringBuffer sbf=new StringBuffer();
                    for(int i=0;i<names.length;i++){
                        if(i==0){
                            sbf.append(names[0].toLowerCase());
                        }else{
                            String tmpNamePart=names[i].toUpperCase().substring(0,1)+names[i].toLowerCase().substring(1);
                            sbf.append(tmpNamePart);
                        }
                    }
                    return sbf.toString();
                }
            }
        }
        return null;
    }

    /**
     * 驼峰命名发首字母大写
     * @param str
     * @param delimiter
     * @return
     */
    public static String camelCaseFirstUpper(String str,String delimiter){
        if(str!=null && delimiter!=null){
            String[] names=str.split(delimiter);
            if(names != null && names.length > 0){
                if(names.length==1){
                    return names[0].toLowerCase();
                }else{
                    StringBuffer sbf=new StringBuffer();
                    for(int i=0;i<names.length;i++){
                        String tmpNamePart=names[i].toUpperCase().substring(0,1)+names[i].toLowerCase().substring(1);
                        sbf.append(tmpNamePart);
                    }
                    return sbf.toString();
                }
            }
        }
        return null;
    }


    public static String normalCase(String camelCaseStr,String delimiter){
        Matcher matcher = Pattern.compile("[A-Z]").matcher(camelCaseStr);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, delimiter+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String tableName="hello_world";
        String str=camelCase(tableName,"_");
        System.out.println(str);
        System.out.println(normalCase(str,","));
    }
}
