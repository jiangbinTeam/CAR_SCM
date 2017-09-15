package com.scm.pojo;

import java.io.Serializable;

//颜色转换表
public class ColorChange implements Serializable {

	private static final long serialVersionUID = 1L;

	private TypeDictionary typeDictionary;
	private String colorName;
	private String colorCode;

	public ColorChange() {

	}

	public ColorChange(TypeDictionary typeDictionary, String colorName, String colorCode) {
		super();
		this.typeDictionary = typeDictionary;
		this.colorName = colorName;
		this.colorCode = colorCode;
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
		return "ScmColorChange [typeDictionary=" + typeDictionary + ", colorName=" + colorName + ", colorCode="
				+ colorCode + "]";
	}

}
