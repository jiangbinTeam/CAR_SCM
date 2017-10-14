package com.scm.dao;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import com.scm.pojo.PaymentList;

@Repository("paymentListMapper")
public interface PaymentListMapper {
	
	@Insert("insert into scm_paymentList(paymentListId,Paymentlistdate,Paymentlistmoney,Paymentlistcount) values \r\n" + 
			"(#{paymentListId},#{paymentListDate},#{paymentListMoney},#{paymentListCount})")
	@SelectKey(keyProperty="paymentListId",statement="select paymentlist.nextval from dual",resultType=int.class,before=true)
	int add(PaymentList paymentList);//查询

	
	@Select("select * from (Select rownum rn,s.* from scm_paymentList s) ss "
			+ " where ss.rn>=#{pageMin} and ss.rn<=#{pageMax}")
	List<PaymentList> listAll(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);//分页
	
	@Select("select count(PAYMENTLISTID) from scm_paymentList")
	int total();//记录总条数

	@Select("select * from scm_paymentList where PAYMENTLISTID=#{paymentListId}")
	PaymentList findById(Integer paymentListId);//使用paymentListId查询信息
}
