package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

/*
发货单
 */
public class Invoice implements Serializable{
    private static final long serialVersionUID = 1L;
    private  Integer 	invoiceId;//发货主键
    private  Integer   logisticsId;//物流公司主键
    private  Integer   dealerId; //经销商表主键
    private  Double    carriageCharge;//运输费用
    private  Date   	startDate;//发车日期
    private  Date     	accessCarDate;// 接车日期
    private  String    invoiceNumber;//发货单号


    public Invoice() {
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", logisticsId=" + logisticsId +
                ", dealerId=" + dealerId +
                ", carriageCharge=" + carriageCharge +
                ", startDate=" + startDate +
                ", accessCarDate=" + accessCarDate +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                '}';
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
}
