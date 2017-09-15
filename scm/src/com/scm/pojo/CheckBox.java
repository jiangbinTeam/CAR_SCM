package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

/*
 * 开箱检查单
 * */
public class CheckBox implements Serializable {

	private static final long serialVersionUID = 1L;

	// 开箱检查ID checkBoxId
	// vin号 vinNumber
	// 入库日期 storageDate
	// 开箱检查日期 checkBoxDate
	// 开箱检查结果 checkBoxResult
	// 损坏情况 damageOf
	// PDI检查日期 pdiDate
	// PDI检查结果 pdiResult
	// PDI检查费用 pdiCheckCharge

	private Integer checkBoxId;
	private String vinNumber;
	private Date storageDate;
	private Date checkBoxDate;
	private Integer checkBoxResult;
	private String damageOf;
	private Date pdiDate;
	private Integer pdiResult;
	private Double pdiCheckCharge;

	public CheckBox() {
		super();
	}

	public CheckBox(Integer checkBoxId, String vinNumber, Date storageDate, Date checkBoxDate, Integer checkBoxResult,
			String damageOf, Date pdiDate, Integer pdiResult, Double pdiCheckCharge) {
		super();
		this.checkBoxId = checkBoxId;
		this.vinNumber = vinNumber;
		this.storageDate = storageDate;
		this.checkBoxDate = checkBoxDate;
		this.checkBoxResult = checkBoxResult;
		this.damageOf = damageOf;
		this.pdiDate = pdiDate;
		this.pdiResult = pdiResult;
		this.pdiCheckCharge = pdiCheckCharge;
	}

	public Integer getCheckBoxId() {
		return checkBoxId;
	}

	public void setCheckBoxId(Integer checkBoxId) {
		this.checkBoxId = checkBoxId;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public Date getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}

	public Date getCheckBoxDate() {
		return checkBoxDate;
	}

	public void setCheckBoxDate(Date checkBoxDate) {
		this.checkBoxDate = checkBoxDate;
	}

	public Integer getCheckBoxResult() {
		return checkBoxResult;
	}

	public void setCheckBoxResult(Integer checkBoxResult) {
		this.checkBoxResult = checkBoxResult;
	}

	public String getDamageOf() {
		return damageOf;
	}

	public void setDamageOf(String damageOf) {
		this.damageOf = damageOf;
	}

	public Date getPdiDate() {
		return pdiDate;
	}

	public void setPdiDate(Date pdiDate) {
		this.pdiDate = pdiDate;
	}

	public Integer getPdiResult() {
		return pdiResult;
	}

	public void setPdiResult(Integer pdiResult) {
		this.pdiResult = pdiResult;
	}

	public double getPdiCheckCharge() {
		return pdiCheckCharge;
	}

	public void setPdiCheckCharge(Double pdiCheckCharge) {
		this.pdiCheckCharge = pdiCheckCharge;
	}

	@Override
	public String toString() {
		return "CheckBox [checkBoxId=" + checkBoxId + ", vinNumber=" + vinNumber + ", storageDate=" + storageDate
				+ ", checkBoxDate=" + checkBoxDate + ", checkBoxResult=" + checkBoxResult + ", damageOf=" + damageOf
				+ ", pdiDate=" + pdiDate + ", pdiResult=" + pdiResult + ", pdiCheckCharge=" + pdiCheckCharge + "]";
	}

}
