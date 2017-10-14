package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

/*
 * 经销商销售明细
 */
public class DealerSellPlanCensorList implements Serializable {

	private static final long serialVersionUID = 1L;

	private String typeCode;// 车型编码
	private Integer dealerId;// 经销商Id
	private String storefrontName;// 经销商名称
	private String brand;// 车型
	private String vinNumber;// Vin码
	private Double sellPrice;// 销售价格
	private Double addAccessorizeCharge;// 改装费用
	private Date sellDate;// 销售日期
	private Date invoiceDate;// 开票日期

	public DealerSellPlanCensorList() {
		super();
	}

	public DealerSellPlanCensorList(String typeCode, Integer dealerId, String storefrontName, String brand,
			String vinNumber, Double sellPrice, Double addAccessorizeCharge, Date sellDate, Date invoiceDate) {
		super();
		this.typeCode = typeCode;
		this.dealerId = dealerId;
		this.storefrontName = storefrontName;
		this.brand = brand;
		this.vinNumber = vinNumber;
		this.sellPrice = sellPrice;
		this.addAccessorizeCharge = addAccessorizeCharge;
		this.sellDate = sellDate;
		this.invoiceDate = invoiceDate;
	}

	public String getStorefrontName() {
		return storefrontName;
	}

	public void setStorefrontName(String storefrontName) {
		this.storefrontName = storefrontName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getAddAccessorizeCharge() {
		return addAccessorizeCharge;
	}

	public void setAddAccessorizeCharge(Double addAccessorizeCharge) {
		this.addAccessorizeCharge = addAccessorizeCharge;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	@Override
	public String toString() {
		return "DealerSellPlanCensorList [typeCode=" + typeCode + ", dealerId=" + dealerId + ", storefrontName="
				+ storefrontName + ", brand=" + brand + ", vinNumber=" + vinNumber + ", sellPrice=" + sellPrice
				+ ", addAccessorizeCharge=" + addAccessorizeCharge + ", sellDate=" + sellDate + ", invoiceDate="
				+ invoiceDate + "]";
	}

}
