package com.scm.pojo;

import java.io.Serializable;

/*
 * 6.全年销售计划按月份分解
 */
public class YearPlanMonthAnalyze implements Serializable{

	private static final long serialVersionUID = 1L;
private Integer yearPlanMonthAnalyzeId; //全年销售计划按月份分解主键
  private Integer yearSellPlanId; //全年销售计划主键
  private Integer yearPlanMouth; //月份
  private Integer yearPlanCount;//数量

  
  public YearPlanMonthAnalyze() {
    super();
  }

  public YearPlanMonthAnalyze(Integer yearSellPlanId, Integer yearPlanMouth,
		Integer yearPlanCount) {
	super();
	
	this.yearSellPlanId = yearSellPlanId;
	this.yearPlanMouth = yearPlanMouth;
	this.yearPlanCount = yearPlanCount;
}
  
  

  public YearPlanMonthAnalyze(Integer yearPlanMonthAnalyzeId, Integer yearSellPlanId, Integer yearPlanMouth,
		Integer yearPlanCount) {
	super();
	this.yearPlanMonthAnalyzeId = yearPlanMonthAnalyzeId;
	this.yearSellPlanId = yearSellPlanId;
	this.yearPlanMouth = yearPlanMouth;
	this.yearPlanCount = yearPlanCount;
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

  public Integer getYearSellPlanId() {
    return yearSellPlanId;
  }

  public void setYearSellPlanId(Integer yearSellPlanId) {
    this.yearSellPlanId = yearSellPlanId;
  }

  @Override
  public String toString() {
    return "YearPlanMonthAnalyze{" +
            "yearPlanMonthAnalyzeId=" + yearPlanMonthAnalyzeId +
            ", yearSellPlanId=" + yearSellPlanId +
            '}';
  }
}
