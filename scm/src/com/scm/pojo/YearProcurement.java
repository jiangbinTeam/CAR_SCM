package com.scm.pojo;

import java.io.Serializable;
/*
 * 
 */
public class YearProcurement implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer yearProcurementPlanYear; //年份
	private String brand; //品牌
	private String typeCode; //车型编码
	private String carCharacter; //车型特征
	private Integer yearProcurementPlanCount; //采购数量
	private Integer carProcurementListCount; //已采购
	private Integer yearProcurementPlanId; //全年采购计划主键
	private Integer ifDecomposition; //是否分解
	private Integer procurementPlanAnalyzeMonth; //月份
	private Integer procurementPlanAnalyzeCount; //数量
	private Integer procurementPlanAnalyzeId; //分解id
	
	public Integer getProcurementPlanAnalyzeId() {
		return procurementPlanAnalyzeId;
	}
	public void setProcurementPlanAnalyzeId(Integer procurementPlanAnalyzeId) {
		this.procurementPlanAnalyzeId = procurementPlanAnalyzeId;
	}
	
	public Integer getProcurementPlanAnalyzeMonth() {
		return procurementPlanAnalyzeMonth;
	}
	public void setProcurementPlanAnalyzeMonth(Integer procurementPlanAnalyzeMonth) {
		this.procurementPlanAnalyzeMonth = procurementPlanAnalyzeMonth;
	}
	
	public Integer getProcurementPlanAnalyzeCount() {
		return procurementPlanAnalyzeCount;
	}
	public void setProcurementPlanAnalyzeCount(Integer procurementPlanAnalyzeCount) {
		this.procurementPlanAnalyzeCount = procurementPlanAnalyzeCount;
	}
	public Integer getIfDecomposition() {
		return ifDecomposition;
	}
	public void setIfDecomposition(Integer ifDecomposition) {
		this.ifDecomposition = ifDecomposition;
	}
	
	public Integer getYearProcurementPlanId() {
		return yearProcurementPlanId;
	}
	public void setYearProcurementPlanId(Integer yearProcurementPlanId) {
		this.yearProcurementPlanId = yearProcurementPlanId;
	}
	
	public Integer getYearProcurementPlanYear() {
		return yearProcurementPlanYear;
	}
	public void setYearProcurementPlanYear(Integer yearProcurementPlanYear) {
		this.yearProcurementPlanYear = yearProcurementPlanYear;
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
	public String getCarCharacter() {
		return carCharacter;
	}
	public void setCarCharacter(String carCharacter) {
		this.carCharacter = carCharacter;
	}
	public Integer getYearProcurementPlanCount() {
		return yearProcurementPlanCount;
	}
	public void setYearProcurementPlanCount(Integer yearProcurementPlanCount) {
		this.yearProcurementPlanCount = yearProcurementPlanCount;
	}
	public Integer getCarProcurementListCount() {
		return carProcurementListCount;
	}
	public void setCarProcurementListCount(Integer carProcurementListCount) {
		this.carProcurementListCount = carProcurementListCount;
	}
	
	public YearProcurement() {
		super();
	}
	@Override
	public String toString() {
		return "YearProcurement [yearProcurementPlanYear=" + yearProcurementPlanYear + ", brand=" + brand
				+ ", typeCode=" + typeCode + ", carCharacter=" + carCharacter + ", yearProcurementPlanCount="
				+ yearProcurementPlanCount + ", carProcurementListCount=" + carProcurementListCount
				+ ", yearProcurementPlanId=" + yearProcurementPlanId + ", ifDecomposition=" + ifDecomposition
				+ ", procurementPlanAnalyzeMonth=" + procurementPlanAnalyzeMonth + ", procurementPlanAnalyzeCount="
				+ procurementPlanAnalyzeCount + "]";
	}
	

	
	
	
}
