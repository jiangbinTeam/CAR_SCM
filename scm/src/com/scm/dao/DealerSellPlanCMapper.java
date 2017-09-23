package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.scm.pojo.DealerSellPlanCensor;

@Repository("dealerSellPlanCMapper")
public interface DealerSellPlanCMapper {
	
	//分页查询
	List<DealerSellPlanCensor> pageList(
			@Param("pageMin")Integer pageMin,
			@Param("pageMax")Integer pageMax,
			@Param("year")String year,
			@Param("yearPlanMouth")String yearPlanMouth,
			@Param("typeCode")String typeCode,
			@Param("dealerId")Integer dealerId);
	
	//计算符合条件的总记录数
	int total(
			@Param("year")String year,
			@Param("mouth")String mouth,
			@Param("typeCode")String typeCode,
			@Param("dealerId")Integer dealerId);
	
	@Select("select distinct year from yearplandealercount")
	List<String> listYear();//获取年份
	
}
