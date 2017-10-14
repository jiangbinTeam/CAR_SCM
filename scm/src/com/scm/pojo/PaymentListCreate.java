package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class PaymentListCreate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer carProcurementListId;
	private String vinNumber;
	private Date expectedPaymentDate;
	private Double stockPrice;

	public PaymentListCreate() {
		super();
	}

	public PaymentListCreate(Integer carProcurementListId, String vinNumber, Date expectedPaymentDate,
			Double stockPrice) {
		super();
		this.carProcurementListId = carProcurementListId;
		this.vinNumber = vinNumber;
		this.expectedPaymentDate = expectedPaymentDate;
		this.stockPrice = stockPrice;
	}

	public Integer getCarProcurementListId() {
		return carProcurementListId;
	}

	public void setCarProcurementListId(Integer carProcurementListId) {
		this.carProcurementListId = carProcurementListId;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public Date getExpectedPaymentDate() {
		return expectedPaymentDate;
	}

	public void setExpectedPaymentDate(Date expectedPaymentDate) {
		this.expectedPaymentDate = expectedPaymentDate;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Override
	public String toString() {
		return "PaymentListCreate [carProcurementListId=" + carProcurementListId + ", vinNumber=" + vinNumber
				+ ", expectedPaymentDate=" + expectedPaymentDate + ", stockPrice=" + stockPrice + "]";
	}

}
