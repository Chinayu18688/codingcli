package coding.service;

/**
 * 模板记录在内存中
 * 用户自定义模板需要注册
 * 再次执行时需要重新添加（推荐使用脚本）
 * Created by 宇 on 2017/11/7.
 */
public class Template {

    private String name;
    private String path;
    private String type;//类型，由于模板.ftl 例如java代码建议类型.java

    public Template() {}

    public Template(String name, String path, String type) {
        this.name = name;
        this.path = path;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

enum TemplateType{
    JAVA,JSP,CSS,SCALA,PHP,JS,FTL
}
