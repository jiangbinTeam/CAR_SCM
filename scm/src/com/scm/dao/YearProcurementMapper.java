package com.scm.dao;
/*
 * 全年采购计划 映射器接口
 */

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.YearProcurementPlan;

@Repository("yearProcurementMapper")
public interface YearProcurementMapper {
	
	//创建全年采购计划
	@Insert("insert into scm_yearProcurementPlan(yearProcurementPlanYear,yearProcurementPlanCount,ifDecomposition,typecode)"
			+ "values(#{yearProcurementPlanYear,jdbcType=VARCHAR},#{yearProcurementPlanCount,jdbcType=INTEGER},#{ifDecomposition,jdbcType=INTEGER},#{typeDictionary.typeCode,jdbcType=VARCHAR})")
//	// 在 insert 操作之前,产生 Oracle 序列值,赋值给属性 id
//	@SelectKey(keyProperty = "yearProcurementPlanId", statement = "select yearProcurementPlan.NEXTVAL INTO :new.yearProcurementPlanId from dual", resultType = int.class, before = true)
	int add(YearProcurementPlan yearProcurementPlan);
	
	//修改全年采购计划
	@Update("update scm_yearProcurementPlan set yearProcurementPlanYear=#{yearProcurementPlanYear,jdbcType=VARCHAR},yearProcurementPlanCount=#{yearProcurementPlanCount,jdbcType=INTEGER},ifDecomposition=#{ifDecomposition,jdbcType=INTEGER},typeCode=#{typeDictionary.typeCode,jdbcType=VARCHAR} "
			+ "where yearProcurementPlanId=#{yearProcurementPlanId,jdbcType=VARCHAR}")
	int update(YearProcurementPlan yearProcurementPlan);
	
	List<YearProcurementPlan> findAll();
	
	YearProcurementPlan findById(Integer yearProcurementPlanId);
}
