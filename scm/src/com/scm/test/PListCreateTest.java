package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.PaymentListCreate;
import com.scm.service.EmployeeService;
import com.scm.service.PListCreateService;

public class PListCreateTest {
	private PListCreateService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("pListCreateService", PListCreateService.class);
	}
	
	@Test
	public void test() {
		for(PaymentListCreate p:service.findAll()) {
			System.out.println(p);
		}
	}
}
