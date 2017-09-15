package com.scm.pojo;

import java.io.Serializable;

/*
 * 6.全年销售计划按月份分解
 */
public class YearPlanMonthAnalyze implements Serializable{
  private static final long serialVersionUID = 4717145780929150319L;

  private Integer yearPlanMonthAnalyzeId; //全年销售计划按月份分解主键
  private Integer yearSellPlanId; //全年销售计划主键

  public YearPlanMonthAnalyze() {
    super();
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
