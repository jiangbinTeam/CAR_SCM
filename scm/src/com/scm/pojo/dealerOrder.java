package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DealerOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * 28.经销商订单表（scm_dealerOrder） 经销商订单ID dealerOrderId 经销商表主键 dealerId 订单编号
	 * orderNumber 下单日期 certificateDate
	 */

	private Integer dealerOrderId;
	private Integer dealerId;
	private String orderNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date certificateDate;
	private Dealer dealer = new Dealer();

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public DealerOrder() {
		super();
	}

	public Integer getDealerOrderId() {
		return dealerOrderId;
	}

	public void setDealerOrderId(Integer dealerOrderId) {
		this.dealerOrderId = dealerOrderId;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCertificateDate() {
		return certificateDate;
	}

	public void setCertificateDate(Date certificateDate) {
		this.certificateDate = certificateDate;
	}

	@Override
	public String toString() {
		return "dealerOrder{" + "dealerOrderId=" + dealerOrderId + ", dealerId=" + dealerId + ", orderNumber='"
				+ orderNumber + '\'' + ", certificateDate=" + certificateDate + '}';
	}

}
