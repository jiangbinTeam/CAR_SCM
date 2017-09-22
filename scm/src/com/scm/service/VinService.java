package com.scm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.VinMapper;
import com.scm.pojo.Vin;

@Service("vinService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class VinService {
	
	@Resource(name="vinMapper")
	private VinMapper vinMapper;
	
	//修改实际打款时间
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public int  addActualPaymentDate(Date actualPaymentDate,String vinNumber,Integer paymentListId) {
		return vinMapper.addActualPaymentDate(actualPaymentDate, vinNumber,paymentListId);
	}
	
	//修改打款单id
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public int addPaymentListId(Integer paymentListId,String vinNumber) {
		return vinMapper.addPaymentListId(paymentListId, vinNumber);
	}

	public List<Vin> findByPListId(Integer paymentListId) {
		
		return vinMapper.findByPListId(paymentListId);
	}
}
