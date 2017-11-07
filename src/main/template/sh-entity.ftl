package ${package}.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ${className} entity. @author coding cli server
 */
@Entity
@Table(name = "${tableName}")
public class ${className} implements java.io.Serializable {

	// Fields
    <#if columnsList?exists >
        <#list columnsList as column>
            private String ${column.columnName};//
        </#list>
    </#if>


	// Constructors

	/** default constructor */
	public ${className}() {}

	/** full constructor */

    <#if columnsList?exists >
        <#list columnsList as column>
            <#if column.columnName==table.tableName>
                @GenericGenerator(name = "generator", strategy = "uuid.hex")
            	@Id
            	@Column(name = "${column.columnName}", unique = true, nullable = false, length = 36)
            	public String getStbId() {
            		return this.stbId;
            	}
            	public void setStbId(String stbId) {
                		this.stbId = stbId;
                }

            <#else>
                    @Column(name = "${column.columnName}", length = ${column.columnSize})
                	public String getUserId() {
                		return this.userId;
                	}

                	public void setUserId(String userId) {
                		this.userId = userId;
                	}
            </#if>
        </#list>
    </#if>


}