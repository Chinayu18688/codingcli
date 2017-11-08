package ${lowerCase(package)}.${camelCase(module)}.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ${camelFirstUpper(table.tableName)} entity. @author coding cli server
 */
@Entity
@Table(name = "${upperCase(table.tableName)}")
public class ${camelFirstUpper(table.tableName)} implements java.io.Serializable {

	// Fields
    <#if columnsList?exists >
        <#list columnsList as column>
	private String ${camelColumnName(column.columnName)};//<#if column.pemark?exists>${column.pemark}</#if>
        </#list>
    </#if>
	// Constructors

	/** default constructor */
	public ${camelFirstUpper(table.tableName)}() {}

	/** full constructor */

    <#if columnsList?exists >
        <#list columnsList as column>
            <#if column.columnName==table.pkColumnName>
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
    @Column(name = "${upperColumnName(column.columnName)}", unique = <#if column.nullAble==0>true<#else>false</#if>, nullable = false, length = ${column.columnSize})
            <#else>
    @Column(name = "${upperColumnName(column.columnName)}", length = ${column.columnSize})
            </#if>
    public String get${camelFirstUpper(column.columnName)}() {
		return this.${camelColumnName(column.columnName)};
	}

    public void set${camelFirstUpper(column.columnName)}(String ${camelColumnName(column.columnName)}) {
        this.${camelColumnName(column.columnName)} = ${camelColumnName(column.columnName)};
    }
        </#list>
    </#if>


}