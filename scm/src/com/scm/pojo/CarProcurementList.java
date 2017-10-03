package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//20.	汽车采购单

/*汽车采购单主键	carProcurementListId
车型编码	typeCode
创建日期	carProcurementListDate
数量	carProcurementListCount
预计打款日期	expectedPaymentDate
采购单号	carProcurementNumber
总金额	carProcurementAmount
是否创建提单	ifcreateBill
采购单价	procurementPrice
是否可以删除  ifDelete
创建日期 carProcurementListDate
*/
public class CarProcurementList implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer carProcurementListId;
	private String typeCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date carProcurementListDate;
	private Integer carProcurementListCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expectedPaymentDate;
	private String carProcurementNumber;
	private Double carProcurementAmount;
	private Integer ifcreateBill;
	private Double procurementPrice;
	private Integer ifDelete;
	private String colorCode;

	public CarProcurementList() {
		super();
	}

	public CarProcurementList(Integer carProcurementListId, String typeCode, Date carProcurementListDate,
			Integer carProcurementListCount, Date expectedPaymentDate, String carProcurementNumber,
			Double carProcurementAmount, Integer ifcreateBill, Double procurementPrice, Integer ifDelete,
			String colorCode) {
		super();
		this.carProcurementListId = carProcurementListId;
		this.typeCode = typeCode;
		this.carProcurementListDate = carProcurementListDate;
		this.carProcurementListCount = carProcurementListCount;
		this.expectedPaymentDate = expectedPaymentDate;
		this.carProcurementNumber = carProcurementNumber;
		this.carProcurementAmount = carProcurementAmount;
		this.ifcreateBill = ifcreateBill;
		this.procurementPrice = procurementPrice;
		this.ifDelete = ifDelete;
		this.colorCode = colorCode;
	}

	public Integer getCarProcurementListId() {
		return carProcurementListId;
	}

	public void setCarProcurementListId(Integer carProcurementListId) {
		this.carProcurementListId = carProcurementListId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Date getCarProcurementListDate() {
		return carProcurementListDate;
	}

	public void setCarProcurementListDate(Date carProcurementListDate) {
		this.carProcurementListDate = carProcurementListDate;
	}

	public Integer getCarProcurementListCount() {
		return carProcurementListCount;
	}

	public void setCarProcurementListCount(Integer carProcurementListCount) {
		this.carProcurementListCount = carProcurementListCount;
	}

	public Date getExpectedPaymentDate() {
		return expectedPaymentDate;
	}

	public void setExpectedPaymentDate(Date expectedPaymentDate) {
		this.expectedPaymentDate = expectedPaymentDate;
	}

	public String getCarProcurementNumber() {
		return carProcurementNumber;
	}

	public void setCarProcurementNumber(String carProcurementNumber) {
		this.carProcurementNumber = carProcurementNumber;
	}

	public Double getCarProcurementAmount() {
		return carProcurementAmount;
	}

	public void setCarProcurementAmount(Double carProcurementAmount) {
		this.carProcurementAmount = carProcurementAmount;
	}

	public Integer getIfcreateBill() {
		return ifcreateBill;
	}

	public void setIfcreateBill(Integer ifcreateBill) {
		this.ifcreateBill = ifcreateBill;
	}

	public Double getProcurementPrice() {
		return procurementPrice;
	}

	public void setProcurementPrice(Double procurementPrice) {
		this.procurementPrice = procurementPrice;
	}

	public Integer getIfDelete() {
		return ifDelete;
	}

	public void setIfDelete(Integer ifDelete) {
		this.ifDelete = ifDelete;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return "CarProcurementList [carProcurementListId=" + carProcurementListId + ", typeCode=" + typeCode
				+ ", carProcurementListDate=" + carProcurementListDate + ", carProcurementListCount="
				+ carProcurementListCount + ", expectedPaymentDate=" + expectedPaymentDate + ", carProcurementNumber="
				+ carProcurementNumber + ", carProcurementAmount=" + carProcurementAmount + ", ifcreateBill="
				+ ifcreateBill + ", procurementPrice=" + procurementPrice + ", ifDelete=" + ifDelete + ", colorCode="
				+ colorCode + "]";
	}

}
