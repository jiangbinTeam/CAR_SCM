package com.scm.pojo;

import java.io.Serializable;

/*
 * 汽车车型字典表
 */
public class TypeDictionary implements Serializable{
	
	// 车型编码 typeCode
	// 品牌 brand
	// 车型特征 carCharacter
	private static final long serialVersionUID = 1L;
	private String typeCode;
	private String brand;
	private String carCharacter;

	public TypeDictionary() {
		super();
	}

	public TypeDictionary(String typeCode, String brand, String carCharacter) {
		super();
		this.typeCode = typeCode;
		this.brand = brand;
		this.carCharacter = carCharacter;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCarCharacter() {
		return carCharacter;
	}

	public void setCarCharacter(String carCharacter) {
		this.carCharacter = carCharacter;
	}

	@Override
	public String toString() {
		return "ScmTypeDictionary [typeCode=" + typeCode + ", brand=" + brand + ", carCharacter=" + carCharacter + "]";
	}

}
