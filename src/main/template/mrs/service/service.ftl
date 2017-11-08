package ${lowerCase(package)}.${camelCase(module)}.service;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import com.buc.base.model.DataGrid;
import ${lowerCase(package)}.${camelCase(module)}.entity.${camelFirstUpper(module)};
import ${lowerCase(package)}.${camelCase(module)}.entity.${camelFirstUpper(table.tableName)};

public interface ${camelFirstUpper(module)}Service {

    DataGrid list${camelFirstUpper(module)}(${camelFirstUpper(module)} ${camelCase(module)});

    void add${camelFirstUpper(module)}(${camelFirstUpper(module)} ${camelCase(module)});

    void edit${camelFirstUpper(module)}(${camelFirstUpper(module)} ${camelCase(module)});

    void delete${camelFirstUpper(module)}(${camelFirstUpper(module)} ${camelCase(module)});

}
