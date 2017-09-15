package com.scm.pojo;

import java.io.Serializable;

public class partsInventory implements Serializable {
  private static final long serialVersionUID = 989971308174622372L;

  /*32.零件库存表（scm_partsInventory）
  * 零件库存表主键	partsInventoryId	INT
    车型编码	typeCode	VARCHAR2(200)
    零件名称	partsNames	NVARCHAR2(200)
    库存数量	partsCount	INT
    零件用途说明	partsPurpose	NVARCHAR2(1000)*/
  private Integer partsInventoryId;
  private String typeCode;
  private String partsNames;
  private Integer partsCount;
  private String partsPurpose;

  public partsInventory() {
    super();
  }

  public Integer getPartsInventoryId() {
    return partsInventoryId;
  }

  public void setPartsInventoryId(Integer partsInventoryId) {
    this.partsInventoryId = partsInventoryId;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getPartsNames() {
    return partsNames;
  }

  public void setPartsNames(String partsNames) {
    this.partsNames = partsNames;
  }

  public Integer getPartsCount() {
    return partsCount;
  }

  public void setPartsCount(Integer partsCount) {
    this.partsCount = partsCount;
  }

  public String getPartsPurpose() {
    return partsPurpose;
  }

  public void setPartsPurpose(String partsPurpose) {
    this.partsPurpose = partsPurpose;
  }

  @Override
  public String toString() {
    return "partsInventory{" +
            "partsInventoryId=" + partsInventoryId +
            ", typeCode='" + typeCode + '\'' +
            ", partsNames='" + partsNames + '\'' +
            ", partsCount=" + partsCount +
            ", partsPurpose='" + partsPurpose + '\'' +
            '}';
  }
}
