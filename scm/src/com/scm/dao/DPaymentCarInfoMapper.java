package com.scm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.scm.pojo.DealerPaymentCarInfo;

@Repository("dPaymentCarInfoMapper")
public interface DPaymentCarInfoMapper {
	
	@Select("select * from dealerPaymentCarInfo where vinnumber=#{vinNumber}")
	DealerPaymentCarInfo findByViNumber(@Param("vinNumber")String vinNumber);
}
