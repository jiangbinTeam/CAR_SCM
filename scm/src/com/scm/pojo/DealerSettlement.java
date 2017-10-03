package com.scm.pojo;

import java.io.Serializable;

/*
 * 经销商费用结算
 */
public class DealerSettlement implements Serializable {

	private static final long serialVersionUID = 1L;
	private String orderNumber;// 订单号
	private Integer dealerOrderId;// 经销商订单ID
	private String vinNumber;// Vin编号
	private Double sellPrice;// 销售价格
	private Double addAccessorizeCharge;// 加装费用
	private Integer dealerId;// 经销商Id

	public DealerSettlement() {
		super();
	}

	public DealerSettlement(String orderNumber, Integer dealerOrderId, String vinNumber, Double sellPrice,
			Double addAccessorizeCharge, Integer dealerId) {
		super();
		this.orderNumber = orderNumber;
		this.dealerOrderId = dealerOrderId;
		this.vinNumber = vinNumber;
		this.sellPrice = sellPrice;
		this.addAccessorizeCharge = addAccessorizeCharge;
		this.dealerId = dealerId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getDealerOrderId() {
		return dealerOrderId;
	}

	public void setDealerOrderId(Integer dealerOrderId) {
		this.dealerOrderId = dealerOrderId;
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

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	@Override
	public String toString() {
		return "DealerSettlement [orderNumber=" + orderNumber + ", dealerOrderId=" + dealerOrderId + ", vinNumber="
				+ vinNumber + ", sellPrice=" + sellPrice + ", addAccessorizeCharge=" + addAccessorizeCharge
				+ ", dealerId=" + dealerId + "]";
	}

}
