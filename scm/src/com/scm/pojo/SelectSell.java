package com.scm.pojo;

import java.io.Serializable;

public class SelectSell implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer year; //年份
	private Integer yearSellPlanId; //id
	private Integer sellcount;				//计划销售数量
	private Integer yearProcurementPlanCount; //计划采购数量
	private String typeCode;			//车型编码
	private String brand;			//品牌
	private String carCharacter;	//车型特征
	private Integer ifDecomposition;//判断条件
	private Integer yearPlanMouth; //月份
	private Integer yearPlanCount; //月数量
	private Integer yearPlanMonthAnalyzeId;//月分解id
	private Integer ifDec;//经销商判断分解
	private String principalName;//负责人姓名
	private String storefrontName ;//店面名称
	private String  yearPlanDealerCount; //经销商计划销售数量
	
	
	
	
	
	
	
	
	
	public String getYearPlanDealerCount() {
		return yearPlanDealerCount;
	}
	public void setYearPlanDealerCount(String yearPlanDealerCount) {
		this.yearPlanDealerCount = yearPlanDealerCount;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getStorefrontName() {
		return storefrontName;
	}
	public void setStorefrontName(String storefrontName) {
		this.storefrontName = storefrontName;
	}
	public Integer getIfDec() {
		return ifDec;
	}
	public void setIfDec(Integer ifDec) {
		this.ifDec = ifDec;
	}
	public Integer getYearPlanMouth() {
		return yearPlanMouth;
	}
	public void setYearPlanMouth(Integer yearPlanMouth) {
		this.yearPlanMouth = yearPlanMouth;
	}
	public Integer getYearPlanCount() {
		return yearPlanCount;
	}
	public void setYearPlanCount(Integer yearPlanCount) {
		this.yearPlanCount = yearPlanCount;
	}
	public Integer getYearPlanMonthAnalyzeId() {
		return yearPlanMonthAnalyzeId;
	}
	public void setYearPlanMonthAnalyzeId(Integer yearPlanMonthAnalyzeId) {
		this.yearPlanMonthAnalyzeId = yearPlanMonthAnalyzeId;
	}
	public Integer getIfDecomposition() {
		return ifDecomposition;
	}
	public void setIfDecomposition(Integer ifDecomposition) {
		this.ifDecomposition = ifDecomposition;
	}
	public Integer getYearSellPlanId() {
		return yearSellPlanId;
	}
	public void setYearSellPlanId(Integer yearSellPlanId) {
		this.yearSellPlanId = yearSellPlanId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getSellcount() {
		return sellcount;
	}
	public void setSellcount(Integer sellcount) {
		this.sellcount = sellcount;
	}
	public Integer getYearProcurementPlanCount() {
		return yearProcurementPlanCount;
	}
	public void setYearProcurementPlanCount(Integer yearProcurementPlanCount) {
		this.yearProcurementPlanCount = yearProcurementPlanCount;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarCharacter() {
		return carCharacter;
	}
	public void setCarCharacter(String carCharacter) {
		this.carCharacter = carCharacter;
	}
	public SelectSell() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SelectSell [year=" + year + ", sellcount=" + sellcount
				+ ", yearProcurementPlanCount=" + yearProcurementPlanCount + ", typeCode=" + typeCode + ", brand="
				+ brand + ", carCharactere=" + carCharacter + "]";
	}
	
	
	
}
