package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Invoice2 implements Serializable{

	private static final long serialVersionUID = 1L;
	private String logisticsName; //物流公司名字
    private Integer invoiceId;//发货单ID
    private Integer logisticsId;//物流公司ID
    private Integer dealerId;//经销商ID
    private Double carriageCharge;//运费
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;//发车日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date accessCarDate;//接车日期
    private String invoiceNumber;//发货单号
    private String dealerName;//经销商店面名
    private String principalName;//经销商负责人
	public String getLogisticsName() {
		return logisticsName;
	}
	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Integer getLogisticsId() {
		return logisticsId;
	}
	public void setLogisticsId(Integer logisticsId) {
		this.logisticsId = logisticsId;
	}
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}
	public Double getCarriageCharge() {
		return carriageCharge;
	}
	public void setCarriageCharge(Double carriageCharge) {
		this.carriageCharge = carriageCharge;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getAccessCarDate() {
		return accessCarDate;
	}
	public void setAccessCarDate(Date accessCarDate) {
		this.accessCarDate = accessCarDate;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	@Override
	public String toString() {
		return "Invoice2 [logisticsName=" + logisticsName + ", invoiceId=" + invoiceId + ", logisticsId=" + logisticsId
				+ ", dealerId=" + dealerId + ", carriageCharge=" + carriageCharge + ", startDate=" + startDate
				+ ", accessCarDate=" + accessCarDate + ", invoiceNumber=" + invoiceNumber + ", dealerName=" + dealerName
				+ ", principalName=" + principalName + "]";
	}
	public Invoice2(String logisticsName, Integer invoiceId, Integer logisticsId, Integer dealerId,
			Double carriageCharge, Date startDate, Date accessCarDate, String invoiceNumber, String dealerName,
			String principalName) {
		super();
		this.logisticsName = logisticsName;
		this.invoiceId = invoiceId;
		this.logisticsId = logisticsId;
		this.dealerId = dealerId;
		this.carriageCharge = carriageCharge;
		this.startDate = startDate;
		this.accessCarDate = accessCarDate;
		this.invoiceNumber = invoiceNumber;
		this.dealerName = dealerName;
		this.principalName = principalName;
	}
	public Invoice2() {
		super();
	}
    
    
    
}
