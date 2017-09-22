package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.DPaymentCarMapper;
import com.scm.pojo.DealerPaymentCar;

@Service("dPaymentCarService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class DPaymentCarService {

	@Resource(name = "dPaymentCarMapper")
	private DPaymentCarMapper Mapper;

	// 增加经销商付车款，默认未结清

	public int add(DealerPaymentCar dealerPaymentCar) {
		return Mapper.add(dealerPaymentCar);
	}
	
	//使用主键查询
	public DealerPaymentCar findByVinNumber(String vinNumber) {
		return Mapper.findByVinNumber(vinNumber);
	}
	
	//通过分页获取待付款的车辆Vin码
	public List<String> findAllVinNumber(Integer pageMin,Integer pageMax){
		return Mapper.findAllVinNumber(pageMin, pageMax);
	}
	
	//获取符合条件的总记录数
	public int total() {
		return Mapper.total();
	}

	public int payMoney(String vinNumber) {
		return Mapper.payMoney(vinNumber);
	}
}
