package com.scm.pojo;

import java.io.Serializable;

/*
 * 经销商销售计划审查
 */
public class DealerSellPlanCensor implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer dealerId;// 经销商Id
	private String storefrontName;// 经销商
	private String brand;// 品牌
	private String typeCode;// 车辆编码
	private String year;// 年份
	private String yearPlanMouth;// 月份
	private Integer yearPlanDealerCount;// 计划销售数量
	private Integer saleCount;// 已销售数量

	public DealerSellPlanCensor() {
		super();
	}

	public DealerSellPlanCensor(Integer dealerId, String storefrontName, String brand, String typeCode, String year,
			String yearPlanMouth, Integer yearPlanDealerCount, Integer saleCount) {
		super();
		this.dealerId = dealerId;
		this.storefrontName = storefrontName;
		this.brand = brand;
		this.typeCode = typeCode;
		this.year = year;
		this.yearPlanMouth = yearPlanMouth;
		this.yearPlanDealerCount = yearPlanDealerCount;
		this.saleCount = saleCount;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public String getStorefrontName() {
		return storefrontName;
	}

	public void setStorefrontName(String storefrontName) {
		this.storefrontName = storefrontName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYearPlanMouth() {
		return yearPlanMouth;
	}

	public void setYearPlanMouth(String yearPlanMouth) {
		this.yearPlanMouth = yearPlanMouth;
	}

	public Integer getYearPlanDealerCount() {
		return yearPlanDealerCount;
	}

	public void setYearPlanDealerCount(Integer yearPlanDealerCount) {
		this.yearPlanDealerCount = yearPlanDealerCount;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	@Override
	public String toString() {
		return "DealerSellPlanCensor [dealerId=" + dealerId + ", storefrontName=" + storefrontName + ", brand=" + brand
				+ ", typeCode=" + typeCode + ", year=" + year + ", yearPlanMouth=" + yearPlanMouth
				+ ", yearPlanDealerCount=" + yearPlanDealerCount + ", saleCount=" + saleCount + "]";
	}

}
