package com.scm.pojo;

import java.io.Serializable;

/*
 * 5.全年销售计划(scm_yearSellPlan)
 */
public class YearSellPlan implements Serializable{
  private static final long serialVersionUID = 964388636355008919L;

  private Integer yearSellPlanId; //全年销售计划主键
  private String typeCode; //车型编码
  private Integer year; //年份
  private Integer sellcount; //销售数量

  public YearSellPlan() {
    super();
  }

  public Integer getYearSellPlanId() {
    return yearSellPlanId;
  }

  public void setYearSellPlanId(Integer yearSellPlanId) {
    this.yearSellPlanId = yearSellPlanId;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
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

  @Override
  public String toString() {
    return "YearSellPlan{" +
            "yearSellPlanId=" + yearSellPlanId +
            ", typeCode='" + typeCode + '\'' +
            ", year=" + year +
            ", sellcount=" + sellcount +
            '}';
  }
}

