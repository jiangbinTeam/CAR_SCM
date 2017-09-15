package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class ArrivalCustoms implements Serializable {

	private static final long serialVersionUID = 1L;
	// 16.报关单（scm_arrivalCustoms）
	// 到港报关主键 arrivalCustomsId
	// 经办人 employeeId
	// 许可证ID licenseNumberId
	// 报关日期 customDate
	// 报关费用 customCharge
	// 报关单号 inspectionNumber
	// 税单日期 taxDate

	private Integer arrivalCustomsId;
	private Integer employeeId;
	private Integer licenseNumberId;
	private Date customDate;
	private Double customCharge;
	private String inspectionNumber;
	private Date taxDate;

	public ArrivalCustoms() {
		super();
	}

	public ArrivalCustoms(Integer arrivalCustomsId, Integer employeeId, Integer licenseNumberId, Date customDate,
			Double customCharge, String inspectionNumber, Date taxDate) {
		super();
		this.arrivalCustomsId = arrivalCustomsId;
		this.employeeId = employeeId;
		this.licenseNumberId = licenseNumberId;
		this.customDate = customDate;
		this.customCharge = customCharge;
		this.inspectionNumber = inspectionNumber;
		this.taxDate = taxDate;
	}

	public Integer getArrivalCustomsId() {
		return arrivalCustomsId;
	}

	public void setArrivalCustomsId(Integer arrivalCustomsId) {
		this.arrivalCustomsId = arrivalCustomsId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getLicenseNumberId() {
		return licenseNumberId;
	}

	public void setLicenseNumberId(Integer licenseNumberId) {
		this.licenseNumberId = licenseNumberId;
	}

	public Date getCustomDate() {
		return customDate;
	}

	public void setCustomDate(Date customDate) {
		this.customDate = customDate;
	}

	public double getCustomCharge() {
		return customCharge;
	}

	public void setCustomCharge(Double customCharge) {
		this.customCharge = customCharge;
	}

	public String getInspectionNumber() {
		return inspectionNumber;
	}

	public void setInspectionNumber(String inspectionNumber) {
		this.inspectionNumber = inspectionNumber;
	}

	public Date getTaxDate() {
		return taxDate;
	}

	public void setTaxDate(Date taxDate) {
		this.taxDate = taxDate;
	}

	@Override
	public String toString() {
		return "ArrivalCustoms [arrivalCustomsId=" + arrivalCustomsId + ", employeeId=" + employeeId
				+ ", licenseNumberId=" + licenseNumberId + ", customDate=" + customDate + ", customCharge="
				+ customCharge + ", inspectionNumber=" + inspectionNumber + ", taxDate=" + taxDate + "]";
	}

}
