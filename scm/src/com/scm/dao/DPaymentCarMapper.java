package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.DealerPaymentCar;



@Repository("dPaymentCarMapper")
public interface DPaymentCarMapper {
	
	@Insert("insert into scm_dealerpaymentcar values "
			+ "	(dealerpaymentcar.nextval,#{vinNumber},#{dealerPaymentCarCount},0)")
	int add(DealerPaymentCar dealerPaymentCar);
	
	@Select("select * from scm_dealerpaymentcar where vinNumber=#{vinNumber}")
	DealerPaymentCar findByVinNumber(@Param("vinNumber")String vinNumber);
	
	@Select("select * from scm_dealerpaymentcar where IFCARRIAGECHARGE=0")
	List<DealerPaymentCar> findAll();
	
	@Select("select VINNUMBER from  (select rownum nb,e.* from  scm_dealerpaymentcar e where IFCARRIAGECHARGE=0) t "
			+ "	where t.nb>=#{pageMin} and t.nb<=#{pageMax}")
	List<String> findAllVinNumber(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);
	
	@Select("select count(DEALERPAYMENTCARID) from scm_dealerpaymentcar")
	int total();
	
	@Update("update scm_dealerpaymentcar set IFCARRIAGECHARGE=1 where VINNUMBER=#{vinNumber}")
	int payMoney(@Param("vinNumber")String vinNumber);
}
