package com.scm.pojo;

import java.io.Serializable;


/*23.	经销商付车款表
 * 经销商付车款主键	dealerPaymentCarId
vin号	vinNumber
经销商付车款	dealerPaymentCarCount
是否结清	ifCarriageCharge
*/
public class DealerPaymentCar implements Serializable {

	private static final long serialVersionUID = 1L;
	
      private Integer   dealerPaymentCarId;
	  private String vinNumber;
	  private Double dealerPaymentCarCount;
	  private Integer ifCarriageCharge;
	
	  public Integer getDealerPaymentCarId() {
		return dealerPaymentCarId;
	}
	public void setDealerPaymentCarId(Integer dealerPaymentCarId) {
		this.dealerPaymentCarId = dealerPaymentCarId;
	}
	public String getVinNumber() {
		return vinNumber;
	}
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	public Double getDealerPaymentCarCount() {
		return dealerPaymentCarCount;
	}
	public void setDealerPaymentCarCount(Double dealerPaymentCarCount) {
		this.dealerPaymentCarCount = dealerPaymentCarCount;
	}
	public Integer getIfCarriageCharge() {
		return ifCarriageCharge;
	}
	public void setIfCarriageCharge(Integer ifCarriageCharge) {
		this.ifCarriageCharge = ifCarriageCharge;
	}
	@Override
	public String toString() {
		return "DealerPaymentCar [dealerPaymentCarId=" + dealerPaymentCarId + ", vinNumber=" + vinNumber
				+ ", dealerPaymentCarCount=" + dealerPaymentCarCount + ", ifCarriageCharge=" + ifCarriageCharge + "]";
	}
	public DealerPaymentCar(Integer dealerPaymentCarId, String vinNumber, Double dealerPaymentCarCount,
			Integer ifCarriageCharge) {
		super();
		this.dealerPaymentCarId = dealerPaymentCarId;
		this.vinNumber = vinNumber;
		this.dealerPaymentCarCount = dealerPaymentCarCount;
		this.ifCarriageCharge = ifCarriageCharge;
	}
	public DealerPaymentCar() {
		super();
	}
	

}
