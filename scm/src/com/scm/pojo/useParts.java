package com.scm.pojo;

import java.io.Serializable;

public class useParts implements Serializable {
  private static final long serialVersionUID = -5322619204705987673L;
  /*33.零件消耗表（scm_useParts）
  零件消耗表主键	 usePartsId
  零件库存表主键	partsInventoryId
  加装信息主键	  addAccessorizeId
  使用数量	      useCount
  费用	          carSpent*/

  private Integer usePartsId;
  private Integer partsInventoryId;
  private Integer addAccessorizeId;
  private Integer useCount;
  private Integer carSpent;

  public useParts() {
    super();
  }

  public Integer getUsePartsId() {
    return usePartsId;
  }

  public void setUsePartsId(Integer usePartsId) {
    this.usePartsId = usePartsId;
  }

  public Integer getPartsInventoryId() {
    return partsInventoryId;
  }

  public void setPartsInventoryId(Integer partsInventoryId) {
    this.partsInventoryId = partsInventoryId;
  }

  public Integer getAddAccessorizeId() {
    return addAccessorizeId;
  }

  public void setAddAccessorizeId(Integer addAccessorizeId) {
    this.addAccessorizeId = addAccessorizeId;
  }

  public Integer getUseCount() {
    return useCount;
  }

  public void setUseCount(Integer useCount) {
    this.useCount = useCount;
  }

  public Integer getCarSpent() {
    return carSpent;
  }

  public void setCarSpent(Integer carSpent) {
    this.carSpent = carSpent;
  }

  @Override
  public String toString() {
    return "useParts{" +
            "usePartsId=" + usePartsId +
            ", partsInventoryId=" + partsInventoryId +
            ", addAccessorizeId=" + addAccessorizeId +
            ", useCount=" + useCount +
            ", carSpent=" + carSpent +
            '}';
  }
}
