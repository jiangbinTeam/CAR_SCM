package com.scm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ListView {
	
	 
	private String typeCode;
	private String brand;
	private String carProcurementNumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  carProcurementListDate;
	private Integer carProcurementListCount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  expectedPaymentDate;
	private Double carProcurementAmount;
	private Double procurementPrice;
	private Integer carProcurementListId;
	private String COLORNAME;
	
	 
	
	
	public ListView() {
		
	}
	
	
	public String getCOLORNAME() {
		return COLORNAME;
	}


	public void setCOLORNAME(String cOLORNAME) {
		COLORNAME = cOLORNAME;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getCarProcurementNumber() {
		return carProcurementNumber;
	}
	public void setCarProcurementNumber(String carProcurementNumber) {
		this.carProcurementNumber = carProcurementNumber;
	}
	public Date getCarProcurementListDate() {
		return carProcurementListDate;
	}
	public void setCarProcurementListDate(Date carProcurementListDate) {
		this.carProcurementListDate = carProcurementListDate;
	}
	public Integer getCarProcurementListCount() {
		return carProcurementListCount;
	}
	public void setCarProcurementListCount(Integer carProcurementListCount) {
		this.carProcurementListCount = carProcurementListCount;
	}
	public Date getExpectedPaymentDate() {
		return expectedPaymentDate;
	}
	public void setExpectedPaymentDate(Date expectedPaymentDate) {
		this.expectedPaymentDate = expectedPaymentDate;
	}
	public Double getCarProcurementAmount() {
		return carProcurementAmount;
	}
	public void setCarProcurementAmount(Double carProcurementAmount) {
		this.carProcurementAmount = carProcurementAmount;
	}
	public Double getProcurementPrice() {
		return procurementPrice;
	}
	public void setProcurementPrice(Double procurementPrice) {
		this.procurementPrice = procurementPrice;
	}
	public Integer getCarProcurementListId() {
		return carProcurementListId;
	}
	public void setCarProcurementListId(Integer carProcurementListId) {
		this.carProcurementListId = carProcurementListId;
	}
	
	
	

}
