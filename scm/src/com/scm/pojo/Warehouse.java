package com.scm.pojo;

import java.io.Serializable;

/*
 * 仓库Id
 */
public class Warehouse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer warehouseId;//id
	private String warehouseName;//名称
	private String warehouseAddress;//地址

	public Warehouse(Integer warehouseId, String warehouseName, String warehouseAddress) {
		super();
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
		this.warehouseAddress = warehouseAddress;
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

	@Override
	public String toString() {
		return "Scm_Warehouse [warehouseId=" + warehouseId + ", warehouseName=" + warehouseName + ", warehouseAddress="
				+ warehouseAddress + "]";
	}

}
