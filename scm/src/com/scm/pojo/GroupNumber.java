package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class GroupNumber implements Serializable {

	private static final long serialVersionUID = 1L;
	//15.批次表（scm_groupNumber）
	// 批次号ID groupNumberId
	// 船期安排ID sailingPlanID
	// 预计装运日期 estimateShippingDate
	// 预计到达日期 estimateArriveDate
	// 汽车数量 carCount

	private String groupNumberId;
	private Integer sailingPlanID;
	private Date estimateShippingDate;
	private Date estimateArriveDate;
	private Integer carCount;

	public GroupNumber() {
		super();
	}

	public GroupNumber(String groupNumberId, Integer sailingPlanID, Date estimateShippingDate, Date estimateArriveDate,
			Integer carCount) {
		super();
		this.groupNumberId = groupNumberId;
		this.sailingPlanID = sailingPlanID;
		this.estimateShippingDate = estimateShippingDate;
		this.estimateArriveDate = estimateArriveDate;
		this.carCount = carCount;
	}

	public String getGroupNumberId() {
		return groupNumberId;
	}

	public void setGroupNumberId(String groupNumberId) {
		this.groupNumberId = groupNumberId;
	}

	public Integer getSailingPlanID() {
		return sailingPlanID;
	}

	public void setSailingPlanID(Integer sailingPlanID) {
		this.sailingPlanID = sailingPlanID;
	}

	public Date getEstimateShippingDate() {
		return estimateShippingDate;
	}

	public void setEstimateShippingDate(Date estimateShippingDate) {
		this.estimateShippingDate = estimateShippingDate;
	}

	public Date getEstimateArriveDate() {
		return estimateArriveDate;
	}

	public void setEstimateArriveDate(Date estimateArriveDate) {
		this.estimateArriveDate = estimateArriveDate;
	}

	public Integer getCarCount() {
		return carCount;
	}

	public void setCarCount(Integer carCount) {
		this.carCount = carCount;
	}

	@Override
	public String toString() {
		return "GroupNumber [groupNumberId=" + groupNumberId + ", sailingPlanID=" + sailingPlanID
				+ ", estimateShippingDate=" + estimateShippingDate + ", estimateArriveDate=" + estimateArriveDate
				+ ", carCount=" + carCount + "]";
	}

}
