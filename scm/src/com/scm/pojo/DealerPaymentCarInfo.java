package com.scm.pojo;

//添加付款记录表
public class DealerPaymentCarInfo {

	private String vinNumber;// vin码
	private String brand;// 汽车车型
	private String engineCode;// 发动机编码
	private String colorName;// 颜色
	private Double sellPrice;// 售价
	private String info;// 说明信息
	private Double addAccessorizeCharge;//加装费用

	public DealerPaymentCarInfo() {
		super();
	}

	public DealerPaymentCarInfo(String vinNumber, String brand, String engineCode, String colorName, Double sellPrice,
			String info, Double addAccessorizeCharge) {
		super();
		this.vinNumber = vinNumber;
		this.brand = brand;
		this.engineCode = engineCode;
		this.colorName = colorName;
		this.sellPrice = sellPrice;
		this.info = info;
		this.addAccessorizeCharge = addAccessorizeCharge;
	}

	public Double getAddAccessorizeCharge() {
		return addAccessorizeCharge;
	}

	public void setAddAccessorizeCharge(Double addAccessorizeCharge) {
		this.addAccessorizeCharge = addAccessorizeCharge;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "DealerPaymentCarInfo [vinNumber=" + vinNumber + ", brand=" + brand + ", engineCode=" + engineCode
				+ ", colorName=" + colorName + ", sellPrice=" + sellPrice + ", info=" + info + ", addAccessorizeCharge="
				+ addAccessorizeCharge + "]";
	}

}
