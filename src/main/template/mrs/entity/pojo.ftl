package ${lowerCase(package)}.${camelCase(module)}.entity;

import com.buc.base.model.BaseModel;

public class ${camelFirstUpper(module)} extends BaseModel{

<#if columnsList?exists >
	<#list columnsList as column>
    private String ${camelColumnName(column.columnName)};//<#if column.pemark?exists>${column.pemark}</#if>
	</#list>
</#if>

	public ${camelFirstUpper(module)}() {}

<#if columnsList?exists >
	<#list columnsList as column>
    public String get${camelFirstUpper(column.columnName)}() {
    	return ${camelColumnName(column.columnName)};
    }
    public void set${camelFirstUpper(column.columnName)}(String ${camelColumnName(column.columnName)}) {
    	this.${camelColumnName(column.columnName)} = ${camelColumnName(column.columnName)};
    }
	</#list>
</#if>


}
