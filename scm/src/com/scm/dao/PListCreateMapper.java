package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.scm.pojo.PaymentListCreate;

@Repository("pListCreateMapper")
public interface PListCreateMapper {

	@Select("select v.carProcurementListId,vinNumber,expectedPaymentDate,stockPrice \r\n" + 
			"from scm_carProcurementList s left join (select * from vin where actualPaymentDate is null) v \r\n" + 
			"on s.carprocurementlistid=v.carprocurementlistid where expectedPaymentDate < sysdate")
	List<PaymentListCreate> findAll();
}
