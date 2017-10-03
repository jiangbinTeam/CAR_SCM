package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.DealerSettlement;
import com.scm.service.DSellPlanCensorListService;
import com.scm.service.DealerSettlementService;

public class DealerSettlementTest {
	private DealerSettlementService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("dealerSettlementService", DealerSettlementService.class);
	}
	@Test
	public void test() {
		for(DealerSettlement s:service.listByDealerId(3)) {
			System.out.println(s);
		}
		
	}

}
