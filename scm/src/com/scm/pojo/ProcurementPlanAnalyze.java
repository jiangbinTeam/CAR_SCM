package com.scm.pojo;

import java.io.Serializable;
/*
 * 3.全年采购计划分解表(scm_procurementPlanAnalyze)
 */
public class ProcurementPlanAnalyze implements Serializable{
  private static final long serialVersionUID = 6493773290578778989L;

  private Integer procurementPlanAnalyzeId; //采购计划分解表主键
  private Integer yearProcurementPlanId; //全年采购计划主键
  private Integer	procurementPlanAnalyzeMonth; //月份
  private Integer	procurementPlanAnalyzeCount; //数量

  public ProcurementPlanAnalyze() {
    super();
  }

  public Integer getProcurementPlanAnalyzeId() {
    return procurementPlanAnalyzeId;
  }

  public void setProcurementPlanAnalyzeId(Integer procurementPlanAnalyzeId) {
    this.procurementPlanAnalyzeId = procurementPlanAnalyzeId;
  }

  public Integer getYearProcurementPlanId() {
    return yearProcurementPlanId;
  }

  public void setYearProcurementPlanId(Integer yearProcurementPlanId) {
    this.yearProcurementPlanId = yearProcurementPlanId;
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

  @Override
  public String toString() {
    return "ProcurementPlanAnalyze{" +
            "procurementPlanAnalyzeId=" + procurementPlanAnalyzeId +
            ", yearProcurementPlanId=" + yearProcurementPlanId +
            ", procurementPlanAnalyzeMonth=" + procurementPlanAnalyzeMonth +
            ", procurementPlanAnalyzeCount=" + procurementPlanAnalyzeCount +
            '}';
  }
}
