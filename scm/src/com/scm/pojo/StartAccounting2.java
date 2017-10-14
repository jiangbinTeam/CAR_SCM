package com.scm.pojo;

import java.io.Serializable;
//发车台账管理
public class StartAccounting2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String typeCode;//车型编码
	private String brand;//汽车品牌
	private String carCharacter;//汽车型号
	private String colorCode;//颜色编码
	private String colorName;//颜色
	private String addAccessorizeNote;//加装说明
    private Integer startAccountingId;//发车台帐表ID
    private String vinNumber;//vin号
    private Integer dealerOrderId;//经销商订单ID
    private Integer invoiceId;//发货单主键
    private Integer startAccountingStates;//发车状态
    private Double sellPrice;//销售价格
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
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getAddAccessorizeNote() {
		return addAccessorizeNote;
	}
	public void setAddAccessorizeNote(String addAccessorizeNote) {
		this.addAccessorizeNote = addAccessorizeNote;
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
	public Integer getDealerOrderId() {
		return dealerOrderId;
	}
	public void setDealerOrderId(Integer dealerOrderId) {
		this.dealerOrderId = dealerOrderId;
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
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public StartAccounting2(String typeCode, String brand, String carCharacter, String colorCode, String colorName,
			String addAccessorizeNote, Integer startAccountingId, String vinNumber, Integer dealerOrderId,
			Integer invoiceId, Integer startAccountingStates, Double sellPrice) {
		super();
		this.typeCode = typeCode;
		this.brand = brand;
		this.carCharacter = carCharacter;
		this.colorCode = colorCode;
		this.colorName = colorName;
		this.addAccessorizeNote = addAccessorizeNote;
		this.startAccountingId = startAccountingId;
		this.vinNumber = vinNumber;
		this.dealerOrderId = dealerOrderId;
		this.invoiceId = invoiceId;
		this.startAccountingStates = startAccountingStates;
		this.sellPrice = sellPrice;
	}
	public StartAccounting2() {
		super();
	}
	@Override
	public String toString() {
		return "StartAccounting2 [typeCode=" + typeCode + ", brand=" + brand + ", carCharacter=" + carCharacter
				+ ", colorCode=" + colorCode + ", colorName=" + colorName + ", addAccessorizeNote=" + addAccessorizeNote
				+ ", startAccountingId=" + startAccountingId + ", vinNumber=" + vinNumber + ", dealerOrderId="
				+ dealerOrderId + ", invoiceId=" + invoiceId + ", startAccountingStates=" + startAccountingStates
				+ ", sellPrice=" + sellPrice + "]";
	}
    
    
    

}
