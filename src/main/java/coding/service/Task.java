package coding.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 没生成一个文件就是一个任务
 * Created by 宇 on 2017/11/7.
 */
public class Task {

    private String outputPath;//文件输出位置
    private Template template;//模板（必须是已配置过的模板）
    private String outputFileName;//输出文件名称
    private Map<String,Object> root=new HashMap<String,Object>();//匹配参数

    public Task() {}

    public Task(String outputPath, Template template, String outputFileName) {
        this.outputPath = outputPath;
        this.template = template;
        this.outputFileName = outputFileName;
    }

    public Task(String outputPath, Template template, String outputFileName, Map<String, Object> root) {
        this.outputPath = outputPath;
        this.template = template;
        this.outputFileName = outputFileName;
        this.root = root;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public Map<String, Object> getRoot() {
        return root;
    }

    public void setRoot(Map<String, Object> root) {
        this.root = root;
    }
}
