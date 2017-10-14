package com.scm.pojo;

import java.io.Serializable;

public class DealerOrderDetails2 implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer dealerOrderDetailsId;
	private Integer  dealerOrderId;
	private String typeCode;
	private String brand;
	private String carCharacter;
	private String colorName;
	private String  addAccessorizeNote;
	private Integer ifCreateStartAccounting;
	
	public Integer getDealerOrderDetailsId() {
		return dealerOrderDetailsId;
	}
	public void setDealerOrderDetailsId(Integer dealerOrderDetailsId) {
		this.dealerOrderDetailsId = dealerOrderDetailsId;
	}
	public Integer getDealerOrderId() {
		return dealerOrderId;
	}
	public void setDealerOrderId(Integer dealerOrderId) {
		this.dealerOrderId = dealerOrderId;
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
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public Integer getIfCreateStartAccounting() {
		return ifCreateStartAccounting;
	}
	public void setIfCreateStartAccounting(Integer ifCreateStartAccounting) {
		this.ifCreateStartAccounting = ifCreateStartAccounting;
	}

	
	public String getAddAccessorizeNote() {
		return addAccessorizeNote;
	}
	public void setAddAccessorizeNote(String addAccessorizeNote) {
		this.addAccessorizeNote = addAccessorizeNote;
	}
	
	
	@Override
	public String toString() {
		return "DealerOrderDetails2 [dealerOrderDetailsId=" + dealerOrderDetailsId + ", dealerOrderId=" + dealerOrderId
				+ ", typeCode=" + typeCode + ", brand=" + brand + ", carCharacter=" + carCharacter + ", colorName="
				+ colorName + ", addAccessorizeNote=" + addAccessorizeNote + ", ifCreateStartAccounting="
				+ ifCreateStartAccounting + "]";
	}
	public DealerOrderDetails2(Integer dealerOrderDetailsId, Integer dealerOrderId, String typeCode, String brand,
			String carCharacter, String colorName, String addAccessorizeNote, Integer ifCreateStartAccounting) {
		super();
		this.dealerOrderDetailsId = dealerOrderDetailsId;
		this.dealerOrderId = dealerOrderId;
		this.typeCode = typeCode;
		this.brand = brand;
		this.carCharacter = carCharacter;
		this.colorName = colorName;
		this.addAccessorizeNote = addAccessorizeNote;
		this.ifCreateStartAccounting = ifCreateStartAccounting;
	}
	public DealerOrderDetails2() {
		super();
	}
	
	

}
