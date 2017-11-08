package ${lowerCase(package)}.${camelCase(module)}.dao.impl;

import java.util.*;
import org.springframework.stereotype.Service;

import com.buc.base.dao.impl.BaseDaoImpl;
import ${lowerCase(package)}.${camelCase(module)}.dao.${camelFirstUpper(module)}Dao;
import ${lowerCase(package)}.${camelCase(module)}.entity.${camelFirstUpper(table.tableName)};

@Service("${lowerCase(module)}Dao")
public class ${camelFirstUpper(module)}DaoImpl extends BaseDaoImpl<${camelFirstUpper(table.tableName)}> implements ${camelFirstUpper(module)}Dao{

 }
