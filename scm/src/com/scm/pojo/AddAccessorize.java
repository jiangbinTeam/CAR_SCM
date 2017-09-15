package com.scm.pojo;
/*
8.	加装信息
 */

import java.io.Serializable;
import java.util.Date;

public class AddAccessorize implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer    addAccessorizeId ;//加装信息主键
    private  String  	 vinNumber;      //vin号
    private String  	addAccessorizeReason; //加装原因
    private Double     addAccessorizeCharge; //加装费用
    private Date      	completeDate;       //预计完成日期

    @Override
    public String toString() {
        return "AddAccessorize{" +
                "addAccessorizeId=" + addAccessorizeId +
                ", vinNumber='" + vinNumber + '\'' +
                ", addAccessorizeReason='" + addAccessorizeReason + '\'' +
                ", addAccessorizeCharge=" + addAccessorizeCharge +
                ", completeDate=" + completeDate +
                '}';
    }

    public AddAccessorize() {
    }

    public Integer getAddAccessorizeId() {
        return addAccessorizeId;
    }

    public void setAddAccessorizeId(Integer addAccessorizeId) {
        this.addAccessorizeId = addAccessorizeId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getAddAccessorizeReason() {
        return addAccessorizeReason;
    }

    public void setAddAccessorizeReason(String addAccessorizeReason) {
        this.addAccessorizeReason = addAccessorizeReason;
    }

    public Double getAddAccessorizeCharge() {
        return addAccessorizeCharge;
    }

    public void setAddAccessorizeCharge(Double addAccessorizeCharge) {
        this.addAccessorizeCharge = addAccessorizeCharge;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
}
