package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.service.DPaymentCarInfoService;

public class DealerPaymentCarInfoTest {
	private DPaymentCarInfoService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("dPaymentCarInfoService", DPaymentCarInfoService.class);
	}
	
	@Test
	public void test() {
		System.out.println(service.findByViNumber("1J4GA59128L544731"));
	}
	
}
