package com.scm.pojo;

import java.io.Serializable;

public class Warehouse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer warehouseId;
	private String warehouseName;
	private String warehouseAddress;
	private String storageAreasName;
	private String vinNumber;
	private Integer storageAreasId;
	private String carCharacter;
	private String typeCode;
	private Integer vinnumbercount;
	public Warehouse(Integer warehouseId, String warehouseName, String warehouseAddress, String storageAreasName,
			String vinNumber, Integer storageAreasId, String carCharacter, String typeCode, Integer vinnumbercount) {
		super();
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
		this.warehouseAddress = warehouseAddress;
		this.storageAreasName = storageAreasName;
		this.vinNumber = vinNumber;
		this.storageAreasId = storageAreasId;
		this.carCharacter = carCharacter;
		this.typeCode = typeCode;
		this.vinnumbercount = vinnumbercount;
	}
	public Warehouse() {
		super();
	}
	public Integer getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWarehouseAddress() {
		return warehouseAddress;
	}
	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}
	public String getStorageAreasName() {
		return storageAreasName;
	}
	public void setStorageAreasName(String storageAreasName) {
		this.storageAreasName = storageAreasName;
	}
	public String getVinNumber() {
		return vinNumber;
	}
	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}
	public Integer getStorageAreasId() {
		return storageAreasId;
	}
	public void setStorageAreasId(Integer storageAreasId) {
		this.storageAreasId = storageAreasId;
	}
	public String getCarCharacter() {
		return carCharacter;
	}
	public void setCarCharacter(String carCharacter) {
		this.carCharacter = carCharacter;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public Integer getVinnumbercount() {
		return vinnumbercount;
	}
	public void setVinnumbercount(Integer vinnumbercount) {
		this.vinnumbercount = vinnumbercount;
	}
	
}
