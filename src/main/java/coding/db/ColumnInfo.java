package coding.db;

/**
 * Created by 宇 on 2017/11/6.
 */
public class ColumnInfo {

    private String columnName;
    private String TypeName;
    private int columnSize;
    private int nullAble;
    private String pemark;//列说明
    private String pkName;//主键的名称
    private Short keySeq;//主键中的序列号（值 1 表示主键中的第一列，值 2 表示主键中的第二列）

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public int getNullAble() {
        return nullAble;
    }

    public void setNullAble(int nullAble) {
        this.nullAble = nullAble;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public Short getKeySeq() {
        return keySeq;
    }

    public void setKeySeq(Short keySeq) {
        this.keySeq = keySeq;
    }

    public String getPemark() {
        return pemark;
    }

    public void setPemark(String pemark) {
        this.pemark = pemark;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "columnName='" + columnName + '\'' +
                ", TypeName='" + TypeName + '\'' +
                ", columnSize=" + columnSize +
                ", nullAble=" + nullAble +
                ", pkName='" + pkName + '\'' +
                ", keySeq=" + keySeq +
                '}';
    }
}
