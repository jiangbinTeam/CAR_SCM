package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.DealerPaymentCar;
import com.scm.service.DPaymentCarService;


public class DealerPaymentCarTest {
	private DPaymentCarService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("dPaymentCarService", DPaymentCarService.class);
	}
	
	@Test
	public void test() {
		DealerPaymentCar c=new DealerPaymentCar();
		/*c.setVinNumber("1J4GA59128L544723");
		c.setDealerPaymentCarCount(19.1);
		c.setIfCarriageCharge(0);
				
		System.out.println(service.add(c));*/
		
		System.out.println(service.payMoney("1J4GA59128L544722"));
	}
}
