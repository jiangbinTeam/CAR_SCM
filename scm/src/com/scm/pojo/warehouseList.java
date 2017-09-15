package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class warehouseList implements Serializable {
  private static final long serialVersionUID = -4161125099987133152L;

  /*31.车辆出入库明细（scm_warehouseList）
  出入库明细ID	warehouseListId	INT
库位表ID	storageareasId	INT
车辆VIN号	vinNumber	NVARCHAR2(100)
入库时间	inWarehouseDate	DATE
出库时间	outWarehouseDate	DATE*/
  private Integer warehouseListId;
  private Integer storageareasId;
  private String vinNumber;
  private Date inWarehouseDate;
  private Date outWarehouseDate;

  public warehouseList() {
    super();
  }

  public Integer getWarehouseListId() {
    return warehouseListId;
  }

  public void setWarehouseListId(Integer warehouseListId) {
    this.warehouseListId = warehouseListId;
  }

  public Integer getStorageareasId() {
    return storageareasId;
  }

  public void setStorageareasId(Integer storageareasId) {
    this.storageareasId = storageareasId;
  }

  public String getVinNumber() {
    return vinNumber;
  }

  public void setVinNumber(String vinNumber) {
    this.vinNumber = vinNumber;
  }

  public Date getInWarehouseDate() {
    return inWarehouseDate;
  }

  public void setInWarehouseDate(Date inWarehouseDate) {
    this.inWarehouseDate = inWarehouseDate;
  }

  public Date getOutWarehouseDate() {
    return outWarehouseDate;
  }

  public void setOutWarehouseDate(Date outWarehouseDate) {
    this.outWarehouseDate = outWarehouseDate;
  }

  @Override
  public String toString() {
    return "warehouseList{" +
            "warehouseListId=" + warehouseListId +
            ", storageareasId=" + storageareasId +
            ", vinNumber='" + vinNumber + '\'' +
            ", inWarehouseDate=" + inWarehouseDate +
            ", outWarehouseDate=" + outWarehouseDate +
            '}';
  }
}
