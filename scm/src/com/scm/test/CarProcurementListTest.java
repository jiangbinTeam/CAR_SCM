package com.scm.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.CarProcurementList;
import com.scm.pojo.ColorChange;
import com.scm.service.CarProcuremenListService;
import com.scm.service.ColorChangeService;
import com.scm.service.TypeDicService;

public class CarProcurementListTest {
	private CarProcuremenListService service;


	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("carProcuremenListService", CarProcuremenListService.class);
		
	}
	
	@Test
	public void test() {
	/*	CarProcurementList c=new CarProcurementList();
		c.setTypeCode("bc2018v3");
		c.setCarProcurementListDate(new Date(2017, 9, 9));
		c.setCarProcurementListCount(20);
		c.setExpectedPaymentDate(new Date(2017, 9, 19));
		c.setCarProcurementNumber("jh2017");
		c.setCarProcurementAmount(23.0);
		c.setProcurementPrice(33.0);
		c.setColorCode("bmys-1");*/
		
		System.out.println(service.findById(3));
	}
	
	
}
