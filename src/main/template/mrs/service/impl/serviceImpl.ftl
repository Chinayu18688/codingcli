package ${lowerCase(package)}.${camelCase(module)}.service.impl;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;

import com.buc.base.model.DataGrid;

import ${lowerCase(package)}.${camelCase(module)}.dao.${camelFirstUpper(module)}Dao;
import ${lowerCase(package)}.${camelCase(module)}.entity.${camelFirstUpper(module)};
import ${lowerCase(package)}.${camelCase(module)}.entity.${camelFirstUpper(table.tableName)};
import ${lowerCase(package)}.${camelCase(module)}.service.${camelFirstUpper(module)}Service;


@Service("${camelCase(module)}Service")
public class ${camelFirstUpper(module)}ServiceImpl implements ${camelFirstUpper(module)}Service {

@Autowired
private ${camelFirstUpper(module)}Dao ${camelCase(module)}Dao;

    @Override
    public DataGrid list${camelFirstUpper(module)}(${camelFirstUpper(module)} ${camelCase(module)}) {
        DataGrid dg = new DataGrid();
        String hql = " from ${camelFirstUpper(table.tableName)} t";
        Map<String, Object> params = new HashMap<String, Object>();
        hql = createSearch(${camelCase(module)}, hql, params);
        String totalHql = "select count(*) " + hql;
        if (${camelCase(module)}.getSort() != null) {
            hql += " order by  " + ${camelCase(module)}.getSort() + "  "+ ${camelCase(module)}.getOrder();
        }
        List<${camelFirstUpper(table.tableName)}> list = ${camelCase(module)}Dao.find(hql, params, ${camelCase(module)}.getPage(),${camelCase(module)}.getRows());
        List<${camelFirstUpper(module)}> entities = new ArrayList<${camelFirstUpper(module)}>();
        changeModel(list, entities);
        dg.setRows(entities);
        dg.setTotal(${lowerCase(module)}Dao.count(totalHql, params));
        return dg;
    }

    private String createSearch(${camelFirstUpper(module)} ${camelCase(module)}, String hql,Map<String, Object> params) {
        hql += " where 1=1 ";
        /**if (${camelCase(module)}.getId() != null && !${camelCase(module)}.getId().trim().equals("")) {
            hql += " and t.id= :id ";
            params.put("id", ${camelCase(module)}.getId().trim());
        }*/

        /**if (${camelCase(module)}.getName() != null && !${camelCase(module)}.getName().trim().equals("")) {
            hql += " and t.name like  :name ";
            params.put("name", "%%" + ${camelCase(module)}.getName().trim() + "%%");
        }*/
        return hql;
    }

    private void changeModel(List<${camelFirstUpper(table.tableName)}> list, List<${camelFirstUpper(module)}> entities) {
        if (list != null && list.size() > 0) {
            for (${camelFirstUpper(table.tableName)} ${camelColumnName(table.tableName)} : list) {
                ${camelFirstUpper(module)} entity = new ${camelFirstUpper(module)}();
                BeanUtils.copyProperties(${camelColumnName(table.tableName)}, entity);
                entities.add(entity);
            }
        }
    }

    @Override
    public void add${camelFirstUpper(module)}(${camelFirstUpper(module)} ${camelCase(module)}) {
        ${camelFirstUpper(table.tableName)} ${camelCase(table.tableName)}=new ${camelFirstUpper(table.tableName)}();
        BeanUtils.copyProperties(${camelCase(table.tableName)}, ${camelCase(module)});
        ${camelCase(module)}Dao.save(${camelCase(table.tableName)});
    }

    @Override
    public void edit${camelFirstUpper(module)}(${camelFirstUpper(module)} ${camelCase(module)}) {
        ${camelFirstUpper(table.tableName)} ${camelCase(table.tableName)}=${camelCase(module)}Dao.getById(${camelCase(module)}.getStbId());
        BeanUtils.copyProperties(${camelCase(table.tableName)}, ${camelCase(table.tableName)});
        ${camelCase(module)}Dao.update(${camelCase(table.tableName)});
    }

    @Override
    public void delete${camelFirstUpper(module)}(${camelFirstUpper(module)} ${camelCase(module)}) {
        ${camelCase(module)}Dao.delete(${camelCase(module)}.getId());
    }
}
