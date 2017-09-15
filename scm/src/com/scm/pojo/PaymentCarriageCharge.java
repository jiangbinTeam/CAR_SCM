package com.scm.pojo;

import java.io.Serializable;
/*24.	经销商付运费表
 * 
 * 
付运输费用主键	paymentCarriageChargeId
发货单主键	invoiceId
经销商付运费	dealerPaymentCount
是否结清	ifCarriageCharge

 * */
public class PaymentCarriageCharge implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private Integer	paymentCarriageChargeId;
     private Integer  invoiceId;
	 private Double  dealerPaymentCount;
	 private Integer  ifCarriageCharge;	
	 
	 public Integer getPaymentCarriageChargeId() {
		return paymentCarriageChargeId;
	}
	public void setPaymentCarriageChargeId(Integer paymentCarriageChargeId) {
		this.paymentCarriageChargeId = paymentCarriageChargeId;
	}
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Double getDealerPaymentCount() {
		return dealerPaymentCount;
	}
	public void setDealerPaymentCount(Double dealerPaymentCount) {
		this.dealerPaymentCount = dealerPaymentCount;
	}
	public Integer getIfCarriageCharge() {
		return ifCarriageCharge;
	}
	public void setIfCarriageCharge(Integer ifCarriageCharge) {
		this.ifCarriageCharge = ifCarriageCharge;
	}
	public PaymentCarriageCharge(Integer paymentCarriageChargeId, Integer invoiceId, Double dealerPaymentCount,
			Integer ifCarriageCharge) {
		super();
		this.paymentCarriageChargeId = paymentCarriageChargeId;
		this.invoiceId = invoiceId;
		this.dealerPaymentCount = dealerPaymentCount;
		this.ifCarriageCharge = ifCarriageCharge;
	}
	public PaymentCarriageCharge() {
		super();
	}
	@Override
	public String toString() {
		return "PaymentCarriageCharge [paymentCarriageChargeId=" + paymentCarriageChargeId + ", invoiceId=" + invoiceId
				+ ", dealerPaymentCount=" + dealerPaymentCount + ", ifCarriageCharge=" + ifCarriageCharge + "]";
	}
	 
	 

}
