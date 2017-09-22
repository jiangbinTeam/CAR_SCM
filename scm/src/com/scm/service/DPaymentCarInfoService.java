package com.scm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scm.dao.DPaymentCarInfoMapper;
import com.scm.pojo.DealerPaymentCarInfo;


@Service("dPaymentCarInfoService")
public class DPaymentCarInfoService {
	
	@Resource(name="dPaymentCarInfoMapper")
	private DPaymentCarInfoMapper mapper;
	
	//使用VinNumber查询
	public DealerPaymentCarInfo findByViNumber(String vinNumber) {
		return mapper.findByViNumber(vinNumber);
	}
}
