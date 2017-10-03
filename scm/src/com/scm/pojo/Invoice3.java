package com.scm.pojo;

import java.io.Serializable;

public class Invoice3 implements Serializable{

	private static final long serialVersionUID = 1L;
	private String typeCode;//车型编码
	private String brand;//品牌
	private String carCharacter;//车型
	private String orderNumber;//订单号
	private Integer startAccountingId;//发车台账状态
	private String vinNumber;//Vin号
	private Integer dealerorderId;//订单表ID
	private Integer invoiceId;//发货单ID
	private Integer startAccountingStates;//发车台账表发车状态
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
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getStartAccountingId() {
		return startAccountingId;
	}
	public void setStartAccountingId(Integer startAccountingId) {
		this.startAccountingId = startAccountingId;
	}
	public String getVinNumber() {
		return vinNumber;
	}
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	public Integer getDealerorderId() {
		return dealerorderId;
	}
	public void setDealerorderId(Integer dealerorderId) {
		this.dealerorderId = dealerorderId;
	}
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Integer getStartAccountingStates() {
		return startAccountingStates;
	}
	public void setStartAccountingStates(Integer startAccountingStates) {
		this.startAccountingStates = startAccountingStates;
	}
	@Override
	public String toString() {
		return "Invoice3 [typeCode=" + typeCode + ", brand=" + brand + ", carCharacter=" + carCharacter
				+ ", orderNumber=" + orderNumber + ", startAccountingId=" + startAccountingId + ", vinNumber="
				+ vinNumber + ", dealerorderId=" + dealerorderId + ", invoiceId=" + invoiceId
				+ ", startAccountingStates=" + startAccountingStates + "]";
	}
	public Invoice3(String typeCode, String brand, String carCharacter, String orderNumber, Integer startAccountingId,
			String vinNumber, Integer dealerorderId, Integer invoiceId, Integer startAccountingStates) {
		super();
		this.typeCode = typeCode;
		this.brand = brand;
		this.carCharacter = carCharacter;
		this.orderNumber = orderNumber;
		this.startAccountingId = startAccountingId;
		this.vinNumber = vinNumber;
		this.dealerorderId = dealerorderId;
		this.invoiceId = invoiceId;
		this.startAccountingStates = startAccountingStates;
	}
	public Invoice3() {
		super();
	}
	
	

}
