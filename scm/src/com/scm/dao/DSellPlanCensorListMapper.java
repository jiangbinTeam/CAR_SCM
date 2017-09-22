package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.scm.pojo.DealerSellPlanCensorList;

@Repository("dSellPlanCensorListMapper")
public interface DSellPlanCensorListMapper {
	
	@Select("select * from \r\n" + 
			"(select  rownum rn, d.*  from dealerSellPlanCensorList d where TYPECODE=#{typeCode} and DEALERID=#{dealerId} and ISSELL=1\r\n" + 
			" and extract(YEAR from SELLDATE)=#{year} and extract(MONTH from SELLDATE)=#{month}  and rownum<=#{pageMax} ) "
			+ "dd  where  rn>=#{pageMin}")
	List<DealerSellPlanCensorList> findByDealerAndDate(//分页查询
			@Param("pageMax") Integer pageMax,
			@Param("pageMin") Integer pageMin,
			@Param("dealerId")Integer dealerId,
			@Param("typeCode") String typeCode,
			@Param("year")Integer year,
			@Param("month")Integer month);
	
	@Select("select count(*) from dealerSellPlanCensorList d where TYPECODE=#{typeCode} and DEALERID=#{dealerId} and ISSELL=1 "+  
			" and extract(YEAR from SELLDATE)=#{year} and extract(MONTH from SELLDATE)=#{month}")
	int count(//计算总记录数
			@Param("dealerId")Integer dealerId,
			@Param("typeCode") String typeCode,
			@Param("year")Integer year,
			@Param("month")Integer month);
}
