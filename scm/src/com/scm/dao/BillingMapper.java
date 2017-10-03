package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Billing;

@Repository("billingMapper")
public interface BillingMapper {
	
	List <Billing> pagelist(
			@Param("pageMin")Integer pageMin,
			@Param("pageMax")Integer pageMax,
			@Param("vinNumber")String vinNumber
			);
	
	int totalcount(
			@Param("vinNumber")String vinNumber
			);
   
	//开票处理
	@Update("update VIN set invoiceDate=#{invoiceDate,jdbcType=DATE}, invoiceNumber=#{invoiceNumber,jdbcType=VARCHAR} "
			+ " where vinNumber=#{vinNumber}")
	 int modifa(Billing bil);
}
