package ${lowerCase(package)}.${camelCase(module)}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.buc.base.controller.BaseController;
import com.buc.base.model.DataGrid;
import com.buc.base.model.Json;
import ${lowerCase(package)}.${camelCase(module)}.entity.${camelFirstUpper(module)};
import ${lowerCase(package)}.${camelCase(module)}.service.${camelFirstUpper(module)}Service;

@Controller
@RequestMapping(value = "/${camelCase(module)}")
public class ${camelFirstUpper(module)}Controller extends BaseController{

    @Autowired
    private ${camelFirstUpper(module)}Service ${camelCase(module)}Service;

    @RequestMapping(value = { "/list${camelFirstUpper(module)}"}, method = { RequestMethod.POST },produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String list${camelFirstUpper(module)}(HttpServletRequest request,
        HttpServletResponse response,${camelFirstUpper(module)} ${camelCase(module)}) {
        DataGrid dataGrid=productService.list${camelFirstUpper(module)}(${camelCase(module)});
        return super.writeJson(dataGrid);
    }

    @RequestMapping(value ={"/add${camelFirstUpper(module)}"}, method = { RequestMethod.POST },produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String add${camelFirstUpper(module)}(HttpServletRequest request,
        HttpServletResponse response,${camelFirstUpper(module)} ${camelCase(module)}){
        Json j=new Json();
        try {
            productService.add${camelFirstUpper(module)}(${camelCase(module)});
            j.setSuccess(true);
            j.setMsg("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            j.setSuccess(false);
            j.setMsg("添加失败,原因:"+e.getMessage());
        }
        return writeJson(j);
    }

    @RequestMapping(value ={"/edit${camelFirstUpper(module)}"}, method = { RequestMethod.POST },produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String edit${camelFirstUpper(module)}(HttpServletRequest request,
        HttpServletResponse response,${camelFirstUpper(module)} ${camelCase(module)}){
        Json j=new Json();
        try {
            productService.editProduct(${camelCase(module)});
            j.setSuccess(true);
            j.setMsg("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            j.setSuccess(false);
            j.setMsg("修改失败,原因:"+e.getMessage());
        }
        return writeJson(j);
    }

    @RequestMapping(value ={"/delete${camelFirstUpper(module)}"}, method = { RequestMethod.GET },produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String delete${camelFirstUpper(module)}(HttpServletRequest request,
        HttpServletResponse response,${camelFirstUpper(module)} ${camelCase(module)}){
        Json j=new Json();
        try {
            productService.delete${camelFirstUpper(module)}(${camelCase(module)});
            j.setSuccess(true);
            j.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            j.setSuccess(false);
            j.setMsg("删除失败,原因:"+e.getMessage());
        }
        return writeJson(j);
    }

}
