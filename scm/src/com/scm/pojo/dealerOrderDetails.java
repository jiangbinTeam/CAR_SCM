package com.scm.pojo;

import java.io.Serializable;

public class DealerOrderDetails implements Serializable {
  private static final long serialVersionUID = 4488940162126475701L;

  /*27.经销商订单明细（scm_dealerOrderDetails）
 经销商订单明细ID	dealerOrderDetailsId
经销商订单ID	dealerOrderId
颜色代码	colorCode
车型编码	typeCode
加装说明	addAccessorizeNote
是否生成发车台帐	ifCreateStartAccounting	*/
  private Integer dealerOrderDetailsId;
  private Integer dealerOrderId;
  private String colorCode;
  private String typeCode;
  private String addAccessorizeNote;
  private Integer ifCreateStartAccounting;

  public DealerOrderDetails() {
    super();
  }

  public Integer getDealerOrderDetailsId() {
    return dealerOrderDetailsId;
  }

  public void setDealerOrderDetailsId(Integer dealerOrderDetailsId) {
    this.dealerOrderDetailsId = dealerOrderDetailsId;
  }

  public Integer getDealerOrderId() {
    return dealerOrderId;
  }

  public void setDealerOrderId(Integer dealerOrderId) {
    this.dealerOrderId = dealerOrderId;
  }

  public String getColorCode() {
    return colorCode;
  }

  public void setColorCode(String colorCode) {
    this.colorCode = colorCode;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getAddAccessorizeNote() {
    return addAccessorizeNote;
  }

  public void setAddAccessorizeNote(String addAccessorizeNote) {
    this.addAccessorizeNote = addAccessorizeNote;
  }

  public Integer getIfCreateStartAccounting() {
    return ifCreateStartAccounting;
  }

  public void setIfCreateStartAccounting(Integer ifCreateStartAccounting) {
    this.ifCreateStartAccounting = ifCreateStartAccounting;
  }

  @Override
  public String toString() {
    return "dealerOrderDetails{" +
            "dealerOrderDetailsId=" + dealerOrderDetailsId +
            ", dealerOrderId=" + dealerOrderId +
            ", colorCode='" + colorCode + '\'' +
            ", typeCode='" + typeCode + '\'' +
            ", addAccessorizeNote='" + addAccessorizeNote + '\'' +
            ", ifCreateStartAccounting=" + ifCreateStartAccounting +
            '}';
  }
}
