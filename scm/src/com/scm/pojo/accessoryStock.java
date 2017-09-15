package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class accessoryStock implements Serializable {
  private static final long serialVersionUID = 3844061714321353876L;

  /*34.零件采购表（scm_accessoryStock）
 零件采购表主键	accessoryStockId	INT
零件库存表主键	partsInventoryId	INT
采购日期	procurementDate	DATE
采购金额	procurementAmount	NUMBER
采购数量	procurementCount	INT*/
  private Integer accessoryStockId;
  private Integer partsInventoryId;
  private Date procurementDate;
  private Integer procurementAmount;
  private Integer  procurementCount;

  public accessoryStock() {
    super();
  }

  public Integer getAccessoryStockId() {
    return accessoryStockId;
  }

  public void setAccessoryStockId(Integer accessoryStockId) {
    this.accessoryStockId = accessoryStockId;
  }

  public Integer getPartsInventoryId() {
    return partsInventoryId;
  }

  public void setPartsInventoryId(Integer partsInventoryId) {
    this.partsInventoryId = partsInventoryId;
  }

  public Date getProcurementDate() {
    return procurementDate;
  }

  public void setProcurementDate(Date procurementDate) {
    this.procurementDate = procurementDate;
  }

  public Integer getProcurementAmount() {
    return procurementAmount;
  }

  public void setProcurementAmount(Integer procurementAmount) {
    this.procurementAmount = procurementAmount;
  }

  public Integer getProcurementCount() {
    return procurementCount;
  }

  public void setProcurementCount(Integer procurementCount) {
    this.procurementCount = procurementCount;
  }

  @Override
  public String toString() {
    return "accessoryStock{" +
            "accessoryStockId=" + accessoryStockId +
            ", partsInventoryId=" + partsInventoryId +
            ", procurementDate=" + procurementDate +
            ", procurementAmount=" + procurementAmount +
            ", procurementCount=" + procurementCount +
            '}';
  }
}
