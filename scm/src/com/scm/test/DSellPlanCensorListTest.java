package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.DealerSellPlanCensorList;
import com.scm.service.DSellPlanCensorListService;

public class DSellPlanCensorListTest {
	private DSellPlanCensorListService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("dSellPlanCensorListService", DSellPlanCensorListService.class);
	}

	@Test
	public void test() {
		/*for(DealerSellPlanCensorList d:service.findByDealerAndDate(5,3,3, "bc2018v3", 2017, 9)) {
			System.out.println(d);
		}*/
		System.out.println(service.count(3, "bc2018v3", 2017, 9));
	}
		
}
