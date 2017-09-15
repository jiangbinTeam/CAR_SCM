package com.scm.pojo;

import java.util.Date;

public class Waybill {
	
	// 17.提单表（scm_waybill）
	// 提单表ID waybillId
	// 批次号ID groupNumberId
	// 到港报关主键 arrivalCustomsId
	// 车型编码 typeCode
	// 实际到港时间 factEstimateShippingDate
	// 提单编号 waybillcode

	private Integer waybillId;
	private String groupNumberId;
	private Integer arrivalCustomsId;
	private String typeCode;
	private Date factEstimateShippingDate;
	private String waybillcode;

	public Waybill() {
		super();
	}

	public Waybill(Integer waybillId, String groupNumberId, Integer arrivalCustomsId, String typeCode,
			Date factEstimateShippingDate, String waybillcode) {
		super();
		this.waybillId = waybillId;
		this.groupNumberId = groupNumberId;
		this.arrivalCustomsId = arrivalCustomsId;
		this.typeCode = typeCode;
		this.factEstimateShippingDate = factEstimateShippingDate;
		this.waybillcode = waybillcode;
	}

	public Integer getWaybillId() {
		return waybillId;
	}

	public void setWaybillId(Integer waybillId) {
		this.waybillId = waybillId;
	}

	public String getGroupNumberId() {
		return groupNumberId;
	}

	public void setGroupNumberId(String groupNumberId) {
		this.groupNumberId = groupNumberId;
	}

	public Integer getArrivalCustomsId() {
		return arrivalCustomsId;
	}

	public void setArrivalCustomsId(Integer arrivalCustomsId) {
		this.arrivalCustomsId = arrivalCustomsId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Date getFactEstimateShippingDate() {
		return factEstimateShippingDate;
	}

	public void setFactEstimateShippingDate(Date factEstimateShippingDate) {
		this.factEstimateShippingDate = factEstimateShippingDate;
	}

	public String getWaybillcode() {
		return waybillcode;
	}

	public void setWaybillcode(String waybillcode) {
		this.waybillcode = waybillcode;
	}

	@Override
	public String toString() {
		return "Waybill [waybillId=" + waybillId + ", groupNumberId=" + groupNumberId + ", arrivalCustomsId="
				+ arrivalCustomsId + ", typeCode=" + typeCode + ", factEstimateShippingDate=" + factEstimateShippingDate
				+ ", waybillcode=" + waybillcode + "]";
	}

}
