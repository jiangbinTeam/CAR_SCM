package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Vin implements Serializable {

	private static final long serialVersionUID = 1L;
	private String vinNumber;
	private Integer waybillId;
	private Integer yearPlanDealerAnalyzeId;
	private Integer carProcurementListId;
	private Integer paymentListId;
	private String typeCode;
	private String colorCode;
	private Integer ifsell;
	private Date productionDate;
	private Integer procedureComplete;
	private String invoiceNumber;
	private String engineCode;
	private Date invoiceDate;
	private String produceCountry;
	private Integer stockPrice;
	private Integer sellPrice;
	private Integer issell;
	private Integer outOfStorage;
	private Date actualPaymentDate;
	private String vinLast;
	private Date sellDate;
	private Integer ifRetrofitting;
	private String addAccessorizeNote;

	public Vin(String vinNumber, Integer waybillId, Integer yearPlanDealerAnalyzeId, Integer carProcurementListId,
			Integer paymentListId, String typeCode, String colorCode, Integer ifsell, Date productionDate,
			Integer procedureComplete, String invoiceNumber, String engineCode, Date invoiceDate, String produceCountry,
			Integer stockPrice, Integer sellPrice, Integer issell, Integer outOfStorage, Date actualPaymentDate,
			String vinLast, Date sellDate, Integer ifRetrofitting, String addAccessorizeNote) {
		super();
		this.vinNumber = vinNumber;
		this.waybillId = waybillId;
		this.yearPlanDealerAnalyzeId = yearPlanDealerAnalyzeId;
		this.carProcurementListId = carProcurementListId;
		this.paymentListId = paymentListId;
		this.typeCode = typeCode;
		this.colorCode = colorCode;
		this.ifsell = ifsell;
		this.productionDate = productionDate;
		this.procedureComplete = procedureComplete;
		this.invoiceNumber = invoiceNumber;
		this.engineCode = engineCode;
		this.invoiceDate = invoiceDate;
		this.produceCountry = produceCountry;
		this.stockPrice = stockPrice;
		this.sellPrice = sellPrice;
		this.issell = issell;
		this.outOfStorage = outOfStorage;
		this.actualPaymentDate = actualPaymentDate;
		this.vinLast = vinLast;
		this.sellDate = sellDate;
		this.ifRetrofitting = ifRetrofitting;
		this.addAccessorizeNote = addAccessorizeNote;
	}

	public Vin() {
		super();
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public Integer getWaybillId() {
		return waybillId;
	}

	public void setWaybillId(Integer waybillId) {
		this.waybillId = waybillId;
	}

	public Integer getYearPlanDealerAnalyzeId() {
		return yearPlanDealerAnalyzeId;
	}

	public void setYearPlanDealerAnalyzeId(Integer yearPlanDealerAnalyzeId) {
		this.yearPlanDealerAnalyzeId = yearPlanDealerAnalyzeId;
	}

	public Integer getCarProcurementListId() {
		return carProcurementListId;
	}

	public void setCarProcurementListId(Integer carProcurementListId) {
		this.carProcurementListId = carProcurementListId;
	}

	public Integer getPaymentListId() {
		return paymentListId;
	}

	public void setPaymentListId(Integer paymentListId) {
		this.paymentListId = paymentListId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public Integer getIfsell() {
		return ifsell;
	}

	public void setIfsell(Integer ifsell) {
		this.ifsell = ifsell;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Integer getProcedureComplete() {
		return procedureComplete;
	}

	public void setProcedureComplete(Integer procedureComplete) {
		this.procedureComplete = procedureComplete;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getProduceCountry() {
		return produceCountry;
	}

	public void setProduceCountry(String produceCountry) {
		this.produceCountry = produceCountry;
	}

	public Integer getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Integer stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Integer getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Integer sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getIssell() {
		return issell;
	}

	public void setIssell(Integer issell) {
		this.issell = issell;
	}

	public Integer getOutOfStorage() {
		return outOfStorage;
	}

	public void setOutOfStorage(Integer outOfStorage) {
		this.outOfStorage = outOfStorage;
	}

	public Date getActualPaymentDate() {
		return actualPaymentDate;
	}

	public void setActualPaymentDate(Date actualPaymentDate) {
		this.actualPaymentDate = actualPaymentDate;
	}

	public String getVinLast() {
		return vinLast;
	}

	public void setVinLast(String vinLast) {
		this.vinLast = vinLast;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public Integer getIfRetrofitting() {
		return ifRetrofitting;
	}

	public void setIfRetrofitting(Integer ifRetrofitting) {
		this.ifRetrofitting = ifRetrofitting;
	}

	public String getAddAccessorizeNote() {
		return addAccessorizeNote;
	}

	public void setAddAccessorizeNote(String addAccessorizeNote) {
		this.addAccessorizeNote = addAccessorizeNote;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
