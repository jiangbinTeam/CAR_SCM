package com.scm.pojo;
/*
12.	库位表
 */

import java.io.Serializable;

public class StorageAreas implements Serializable{
    private static final long serialVersionUID = 1L;
    private  Integer 	storageAreasId;//库位表ID
    private  Integer 	warehouseId;//仓库表ID
    private  String   vinNumber;//vin号
    private  String 	storageAreasName;//库位名称


    @Override
    public String toString() {
        return "StorageAreas{" +
                "storageAreasId=" + storageAreasId +
                ", warehouseId=" + warehouseId +
                ", vinNumber='" + vinNumber + '\'' +
                ", storageAreasName='" + storageAreasName + '\'' +
                '}';
    }

    public StorageAreas() {
    }

    public Integer getStorageAreasId() {
        return storageAreasId;
    }

    public void setStorageAreasId(Integer storageAreasId) {
        this.storageAreasId = storageAreasId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getStorageAreasName() {
        return storageAreasName;
    }

    public void setStorageAreasName(String storageAreasName) {
        this.storageAreasName = storageAreasName;
    }
}
