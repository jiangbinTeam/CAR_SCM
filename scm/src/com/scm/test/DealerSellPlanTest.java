package com.scm.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.DealerSellPlanCensor;
import com.scm.service.DealerSellPlanCService;

public class DealerSellPlanTest {
	private DealerSellPlanCService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("dealerSellPlanCService", DealerSellPlanCService.class);
	}

	@Test
	public void testPage() {
		List<DealerSellPlanCensor> list = service.pageList(1, 1, "2017", "2", null, null);
		for (DealerSellPlanCensor d : list) {
			System.out.println(d);
		}
	}

	@Test
	public void testTotal() {
		System.out.println(service.total("2017","1","bc2018v3",null));
	}
}
