package com.scm.dao;
/*
 * 全年采购计划 映射器接口
 */

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.scm.pojo.YearProcurementPlan;

@Repository("yearProcurementMapper")
public interface YearProcurementMapper {
	
	//创建全年采购计划
	@Insert("insert into scm_yearProcurementPlan(yearProcurementPlanId,yearProcurementPlanYear,yearProcurementPlanCount,ifDecomposition,typecode)"
			+ "values(#{yearProcurementPlanId},#{yearProcurementPlanYear,jdbcType=VARCHAR},#{yearProcurementPlanCount,jdbcType=INTEGER},#{ifDecomposition,jdbcType=INTEGER},#{typeDictionary.typeCode,jdbcType=VARCHAR})")
	int add(YearProcurementPlan yearProcurementPlan);
	
	List<YearProcurementPlan> findAll();
	
	YearProcurementPlan findById(int yearProcurementPlanId);
}
