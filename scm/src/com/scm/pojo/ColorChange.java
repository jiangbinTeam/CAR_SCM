package com.scm.pojo;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.print.attribute.standard.MediaName;

//颜色转换表
public class ColorChange implements Serializable {

	private static final long serialVersionUID = 1L;

	private TypeDictionary typeDictionary;
	private String typeCode;
	private String colorName;
	private String colorCode;

	public ColorChange() {

	}

	public ColorChange(TypeDictionary typeDictionary, String typeCode, String colorName, String colorCode) {
		super();
		this.typeDictionary = typeDictionary;
		this.typeCode = typeCode;
		this.colorName = colorName;
		this.colorCode = colorCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public TypeDictionary getTypeDictionary() {
		return typeDictionary;
	}

	public void setTypeDictionary(TypeDictionary typeDictionary) {
		this.typeDictionary = typeDictionary;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return "ColorChange [typeDictionary=" + typeDictionary + ", typeCode=" + typeCode + ", colorName=" + colorName
				+ ", colorCode=" + colorCode + "]";
	}

}
