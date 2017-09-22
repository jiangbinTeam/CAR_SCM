package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.PaymentListMapper;
import com.scm.dao.VinMapper;
import com.scm.pojo.PaymentList;

@Service("paymentListService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class PaymentListService {

	@Resource(name = "paymentListMapper")
	private PaymentListMapper mapper;

	@Resource(name = "vinMapper")
	private VinMapper vinMapper;

	// 增加
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public void add(PaymentList paymentList, String[] check) {
		mapper.add(paymentList);
		int paymentListId = paymentList.getPaymentListId();
	System.out.println(paymentListId);
		for (String s : check) {
	System.out.println(s);
			vinMapper.addActualPaymentDate(paymentList.getPaymentListDate(), s, paymentListId);
		}
	}

	// 分页
	public List<PaymentList> listAll(Integer pageMin, Integer pageMax) {
		return mapper.listAll(pageMin, pageMax);
	}

	// 计算总记录数
	public int total() {
		return mapper.total();
	}

	public PaymentList findById(Integer paymentListId) {
		
		return mapper.findById(paymentListId);
	}
}
