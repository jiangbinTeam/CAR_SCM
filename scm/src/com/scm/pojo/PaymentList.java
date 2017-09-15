package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class PaymentList implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * 打款单表
	 * 
	 * 打款表主键 paymentListId 
	 * 打款日期 paymentListDate 
	 * 汇率 paymentListRate 
	 * 打款金额paymentListMoney 
	 * 打款车辆数 paymentListCount
	 */

	private Integer paymentListId;
	private Date paymentListDate;
	private Double paymentListRate;
	private Double paymentListMoney;
	private Integer paymentListCount;

	public PaymentList() {
		super();
	}

	public PaymentList(Integer paymentListId, Date paymentListDate, Double paymentListRate, Double paymentListMoney,
			Integer paymentListCount) {
		super();
		this.paymentListId = paymentListId;
		this.paymentListDate = paymentListDate;
		this.paymentListRate = paymentListRate;
		this.paymentListMoney = paymentListMoney;
		this.paymentListCount = paymentListCount;
	}

	public Integer getPaymentListId() {
		return paymentListId;
	}

	public void setPaymentListId(Integer paymentListId) {
		this.paymentListId = paymentListId;
	}

	public Date getPaymentListDate() {
		return paymentListDate;
	}

	public void setPaymentListDate(Date paymentListDate) {
		this.paymentListDate = paymentListDate;
	}

	public double getPaymentListRate() {
		return paymentListRate;
	}

	public void setPaymentListRate(Double paymentListRate) {
		this.paymentListRate = paymentListRate;
	}

	public double getPaymentListMoney() {
		return paymentListMoney;
	}

	public void setPaymentListMoney(Double paymentListMoney) {
		this.paymentListMoney = paymentListMoney;
	}

	public Integer getPaymentListCount() {
		return paymentListCount;
	}

	public void setPaymentListCount(Integer paymentListCount) {
		this.paymentListCount = paymentListCount;
	}

	@Override
	public String toString() {
		return "PaymentList [paymentListId=" + paymentListId + ", paymentListDate=" + paymentListDate
				+ ", paymentListRate=" + paymentListRate + ", paymentListMoney=" + paymentListMoney
				+ ", paymentListCount=" + paymentListCount + "]";
	}

}
