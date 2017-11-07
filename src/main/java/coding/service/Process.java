package coding.service;

import java.util.List;

/**
 * 标记符号 +号表示层级 -表示当前层内容
 * 栗子1 org.cli.db
 * +-org
 * ++-cli
 * +++-db Jdbc.java
 * 栗子2 com.company.service
 * +-com
 * ++-company
 * +++-service XXService.java,
 * ++++-impl XXServiceImpl.java,XXXXServiceImpl.java(逗号隔开)
 * Created by 宇 on 2017/11/7.
 */
public class Process {

    private String path;//文件输出位置
    private String id;
    private String sign;
    private String packageName;
    private String parentId;
    private List<TemplateHome> templateHomes;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TemplateHome> getTemplateHomes() {
        return templateHomes;
    }

    public void setTemplateHomes(List<TemplateHome> templateHomes) {
        this.templateHomes = templateHomes;
    }
}
