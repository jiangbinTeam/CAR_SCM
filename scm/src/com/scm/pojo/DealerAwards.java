package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

/*
 * 25.	经销商奖励表
 * 奖励表主键	dealerAwardsId
经销商表主键	dealerId
奖励原因	dealerAwardsReason
奖励日期	dealerAwardsDate
奖励金额	dealerAwardsMoney
*/
public class DealerAwards implements Serializable{

	private static final long serialVersionUID = 1L;
	
		private Integer  dealerAwardsId;
		private Integer dealerId;
	    private String  dealerAwardsReason;
	    private Date dealerAwardsDate;
	 	private Double dealerAwardsMoney;
	 	
		public Integer getDealerAwardsId() {
			return dealerAwardsId;
		}
		public void setDealerAwardsId(Integer dealerAwardsId) {
			this.dealerAwardsId = dealerAwardsId;
		}
		public Integer getDealerId() {
			return dealerId;
		}
		public void setDealerId(Integer dealerId) {
			this.dealerId = dealerId;
		}
		public String getDealerAwardsReason() {
			return dealerAwardsReason;
		}
		public void setDealerAwardsReason(String dealerAwardsReason) {
			this.dealerAwardsReason = dealerAwardsReason;
		}
		public Date getDealerAwardsDate() {
			return dealerAwardsDate;
		}
		public void setDealerAwardsDate(Date dealerAwardsDate) {
			this.dealerAwardsDate = dealerAwardsDate;
		}
		public Double getDealerAwardsMoney() {
			return dealerAwardsMoney;
		}
		public void setDealerAwardsMoney(Double dealerAwardsMoney) {
			this.dealerAwardsMoney = dealerAwardsMoney;
		}
		public DealerAwards(Integer dealerAwardsId, Integer dealerId, String dealerAwardsReason, Date dealerAwardsDate,
				Double dealerAwardsMoney) {
			super();
			this.dealerAwardsId = dealerAwardsId;
			this.dealerId = dealerId;
			this.dealerAwardsReason = dealerAwardsReason;
			this.dealerAwardsDate = dealerAwardsDate;
			this.dealerAwardsMoney = dealerAwardsMoney;
		}
		@Override
		public String toString() {
			return "DealerAwards [dealerAwardsId=" + dealerAwardsId + ", dealerId=" + dealerId + ", dealerAwardsReason="
					+ dealerAwardsReason + ", dealerAwardsDate=" + dealerAwardsDate + ", dealerAwardsMoney="
					+ dealerAwardsMoney + "]";
		}
		public DealerAwards() {
			super();
		}
	 	
	 	

}
