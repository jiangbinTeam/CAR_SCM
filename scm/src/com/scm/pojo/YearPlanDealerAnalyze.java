package com.scm.pojo;
/*
7.	全年销售计划按经销商分解
 */

import java.io.Serializable;

public class YearPlanDealerAnalyze implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer yearPlanDealerAnalyzeId;  //经销商分解表主键
    private Integer yearPlanMonthAnalyzeId;   //全年销售计划按月份分解主键
    private Integer dealerId;                   //经销商表主键
    private Integer yearPlanDealerCount;      //数量

    public YearPlanDealerAnalyze() {

    }

    @Override
    public String toString() {
        return "YearPlanDealerAnalyze{" +
                "yearPlanDealerAnalyzeId=" + yearPlanDealerAnalyzeId +
                ", yearPlanMonthAnalyzeId=" + yearPlanMonthAnalyzeId +
                ", dealerId=" + dealerId +
                ", yearPlanDealerCount=" + yearPlanDealerCount +
                '}';
    }

    public Integer getYearPlanDealerAnalyzeId() {
        return yearPlanDealerAnalyzeId;
    }

    public void setYearPlanDealerAnalyzeId(Integer yearPlanDealerAnalyzeId) {
        this.yearPlanDealerAnalyzeId = yearPlanDealerAnalyzeId;
    }

    public Integer getYearPlanMonthAnalyzeId() {
        return yearPlanMonthAnalyzeId;
    }

    public void setYearPlanMonthAnalyzeId(Integer yearPlanMonthAnalyzeId) {
        this.yearPlanMonthAnalyzeId = yearPlanMonthAnalyzeId;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getYearPlanDealerCount() {
        return yearPlanDealerCount;
    }

    public void setYearPlanDealerCount(Integer yearPlanDealerCount) {
        this.yearPlanDealerCount = yearPlanDealerCount;
    }
}
