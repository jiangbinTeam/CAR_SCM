package com.scm.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.PaymentList;
import com.scm.service.PaymentListService;

public class PaymentListTest {
	private PaymentListService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("paymentListService", PaymentListService.class);
	}

	@Test
	public void testAdd() {
		/*PaymentList paymentList = new PaymentList();

		paymentList.setPaymentListDate(new Date(2015, 11, 12));
		paymentList.setPaymentListMoney(100.0);
		paymentList.setPaymentListCount(8);
		
		String[] check= new String[] {"1J4GA59128L544706"};
		
		service.add(paymentList, check);;*/
		System.out.println(service.findById(3));
	}
}
