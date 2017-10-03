package com.scm.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Vin;

@Repository("vinMapper")
public interface VinMapper {

	@Update("update vin set actualPaymentDate=#{actualPaymentDate},PAYMENTLISTID=#{paymentListId} where vinNumber=#{vinNumber}")
	int addActualPaymentDate(@Param("actualPaymentDate") Date actualPaymentDate, @Param("vinNumber") String vinNumber,
			@Param("paymentListId") Integer paymentListId);

	@Update("update vin set paymentListId=#{paymentListId} where vinNumber=#{vinNumber}")
	int addPaymentListId(@Param("paymentListId") Integer paymentListId, @Param("vinNumber") String vinNumber);

	@Select("select VINNUMBER,actualPaymentDate,stockPrice from vin where paymentListId=#{paymentListId}")
	List<Vin> findByPListId(Integer paymentListId);

	@Select("select * from vin")
	List<Vin> findAll();
	
	//使用采购单主键查询
	@Select("select * from\r\n" + 
			"(select rownum rn,v.* from vin v where carProcurementListId=#{carProcurementListId} and  rownum<=#{pageMax})\r\n" + 
			"where rn>=#{pageMin}")
	List<Vin> findByCarProcurementListId(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax,
			@Param("carProcurementListId")Integer carProcurementListId);
	
	//查询符合条件的记录数
	@Select("select count(VINNUMBER) from vin where carProcurementListId=#{carProcurementListId}")
	int total(@Param("carProcurementListId")Integer carProcurementListId);
	
	//增添vin信息
	@Insert("insert into vin(carProcurementListId,stockPrice,typeCode,colorCode,vinNumber,engineCode,vinLast) values(\r\n" + 
			"#{carProcurementListId},#{stockPrice},#{typeCode},#{colorCode},#{vinNumber},#{engineCode},#{vinLast})")
	int add(Vin vin);
	
	@Select("select * from vin where vinNumber=#{vinNumber}")
	Vin findByVinNumber(@Param("vinNumber")String vinNumber);
}
