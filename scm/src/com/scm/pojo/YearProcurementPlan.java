package com.scm.pojo;

import java.io.Serializable;

/*
 * 4.全年采购计划表(scm_yearProcurementPlan)
 */
public class YearProcurementPlan implements Serializable{
  private static final long serialVersionUID = 7524181205679790667L;

  private Integer yearProcurementPlanId; //全年采购计划主键
  //private String typeCode; //车型编码
  private Integer yearProcurementPlanYear; //年份
  private Integer yearProcurementPlanCount; //采购数量
  private Integer ifDecomposition; //是否已经分解
  
  private TypeDictionary typeDictionary; //车型编码 汽车车型字典表

  public YearProcurementPlan() {
    super();
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

public Integer getYearProcurementPlanCount() {
	return yearProcurementPlanCount;
}

public void setYearProcurementPlanCount(Integer yearProcurementPlanCount) {
	this.yearProcurementPlanCount = yearProcurementPlanCount;
}

public Integer getIfDecomposition() {
	return ifDecomposition;
}

public void setIfDecomposition(Integer ifDecomposition) {
	this.ifDecomposition = ifDecomposition;
}

public TypeDictionary getTypeDictionary() {
	return typeDictionary;
}

public void setTypeDictionary(TypeDictionary typeDictionary) {
	this.typeDictionary = typeDictionary;
}

@Override
public String toString() {
	return "YearProcurementPlan [yearProcurementPlanId=" + yearProcurementPlanId + ", yearProcurementPlanYear="
			+ yearProcurementPlanYear + ", yearProcurementPlanCount=" + yearProcurementPlanCount + ", ifDecomposition="
			+ ifDecomposition + ", typeDictionary=" + typeDictionary + "]";
}

  
  
}
