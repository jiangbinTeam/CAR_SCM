package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class dealerOrder implements Serializable {
  private static final long serialVersionUID = 5102556800790895605L;

  /*28.经销商订单表（scm_dealerOrder）
    经销商订单ID	dealerOrderId
   经销商表主键	dealerId
   订单编号	orderNumber
  下单日期	certificateDate*/

  private Integer dealerOrderId;
  private Integer dealerId;
  private String orderNumber;
  private Date certificateDate;

  public dealerOrder() {
    super();
  }

  public Integer getDealerOrderId() {
    return dealerOrderId;
  }

  public void setDealerOrderId(Integer dealerOrderId) {
    this.dealerOrderId = dealerOrderId;
  }

  public Integer getDealerId() {
    return dealerId;
  }

  public void setDealerId(Integer dealerId) {
    this.dealerId = dealerId;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getCertificateDate() {
    return certificateDate;
  }

  public void setCertificateDate(Date certificateDate) {
    this.certificateDate = certificateDate;
  }

  @Override
  public String toString() {
    return "dealerOrder{" +
            "dealerOrderId=" + dealerOrderId +
            ", dealerId=" + dealerId +
            ", orderNumber='" + orderNumber + '\'' +
            ", certificateDate=" + certificateDate +
            '}';
  }
}
