package com.scm.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Vin;

@Repository("vinMapper")
public interface VinMapper {
	
	@Update("update vin set actualPaymentDate=#{actualPaymentDate},PAYMENTLISTID=#{paymentListId} where vinNumber=#{vinNumber}")
	int addActualPaymentDate(@Param("actualPaymentDate")Date actualPaymentDate,
							@Param("vinNumber") String vinNumber,
							@Param("paymentListId") Integer paymentListId);
	
	
	@Update("update vin set paymentListId=#{paymentListId} where vinNumber=#{vinNumber}")
	int addPaymentListId(@Param("paymentListId")Integer paymentListId,@Param("vinNumber") String vinNumber);

	
	@Select("select VINNUMBER,actualPaymentDate,stockPrice from vin where paymentListId=#{paymentListId}")
	List<Vin> findByPListId(Integer paymentListId);
}
