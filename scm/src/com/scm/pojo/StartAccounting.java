package com.scm.pojo;
/*
 发车台账表
 */

import java.io.Serializable;

public class StartAccounting implements Serializable{
    private static final long serialVersionUID = 1L;
    private  Integer 	startAccountingId;//发车台帐表ID
    private  String 	vinNumber;//vin号
    private  Integer  	dealerOrderId;//经销商订单ID
    private  Integer   	invoiceId;//发货单主键
    private  Integer   	startAccountingStates;//发车状态


    @Override
    public String toString() {
        return "StartAccounting{" +
                "startAccountingId=" + startAccountingId +
                ", vinNumber='" + vinNumber + '\'' +
                ", dealerOrderId=" + dealerOrderId +
                ", invoiceId=" + invoiceId +
                ", startAccountingStates=" + startAccountingStates +
                '}';
    }

    public StartAccounting() {
    }

    public Integer getStartAccountingId() {
        return startAccountingId;
    }

    public void setStartAccountingId(Integer startAccountingId) {
        this.startAccountingId = startAccountingId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public Integer getDealerOrderId() {
        return dealerOrderId;
    }

    public void setDealerOrderId(Integer dealerOrderId) {
        this.dealerOrderId = dealerOrderId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getStartAccountingStates() {
        return startAccountingStates;
    }

    public void setStartAccountingStates(Integer startAccountingStates) {
        this.startAccountingStates = startAccountingStates;
    }
}
