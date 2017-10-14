package com.scm.pojo;



import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.Serializable;

public class ExcelBean implements Serializable{
   
	private static final long serialVersionUID = 1L;
	private String headTextName; //列头（标题）名
    private String propertyName; //对应字段名
    private Integer cols; //合并单元格数
    private XSSFCellStyle cellStyle;
    public ExcelBean(){
    }
    public ExcelBean(String headTextName, String propertyName){
        this.headTextName = headTextName;
        this.propertyName = propertyName;
    }
    public ExcelBean(String headTextName, String propertyName, Integer cols) {
        super();
        this.headTextName = headTextName;
        this.propertyName = propertyName;
        this.cols = cols;
    }

    public void setHeadTextName(String headTextName) {
        this.headTextName = headTextName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public void setCellStyle(XSSFCellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    public String getHeadTextName() {
        return headTextName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Integer getCols() {
        return cols;
    }

    public XSSFCellStyle getCellStyle() {
        return cellStyle;
    }
}
