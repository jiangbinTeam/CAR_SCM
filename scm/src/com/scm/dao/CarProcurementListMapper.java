package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.CarProcurementList;
import com.scm.pojo.ListView;
import com.scm.pojo.TypeDictionary;
import com.scm.pojo.Vin;

@Repository("carProcurementListMapper")
public interface CarProcurementListMapper {

	// 分页
	@Select("select a.* from \r\n" + 
			"(select rownum rn ,c.* from scm_CarProcurementList c where rownum<=#{pageMax}) a where rn>=#{pageMin}")
	List<CarProcurementList> listAllByPage(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);

	// 查询总记录数
	@Select("select count(*) from scm_CarProcurementList")
	int total();
	
	@Insert("insert into scm_CarProcurementList \r\n" + 
			" values(carprocurementlist.nextval,#{typeCode},#{carProcurementListDate},#{carProcurementListCount},#{expectedPaymentDate},\r\n" + 
			" #{carProcurementNumber},#{carProcurementAmount},0,#{procurementPrice},0,#{colorCode}) ")
	int add(CarProcurementList carProcurementList);
	
	
	@Select("select * from scm_CarProcurementList where carProcurementListId=#{carProcurementListId}")
	CarProcurementList findById(@Param("carProcurementListId")Integer carProcurementListId);
	
	@Update("update  scm_CarProcurementList set TYPECODE=#{typeCode},CARPROCUREMENTLISTDATE=#{carProcurementListDate},CARPROCUREMENTLISTCOUNT=#{carProcurementListCount},\r\n" + 
			"EXPECTEDPAYMENTDATE=#{expectedPaymentDate},CARPROCUREMENTNUMBER=#{carProcurementNumber},CARPROCUREMENTAMOUNT=#{carProcurementAmount},PROCUREMENTPRICE=#{procurementPrice},COLORCODE=#{colorCode}\r\n" + 
			"where CARPROCUREMENTLISTID=#{carProcurementListId}")
	int modify(CarProcurementList carProcurementList);
	
	
}
