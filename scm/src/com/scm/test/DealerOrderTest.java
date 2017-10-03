package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.DealerOrder;
import com.scm.service.DealerOrderService;

public class DealerOrderTest {
	private DealerOrderService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("DealerOrderService", DealerOrderService.class);
	}

	@Test
	public void test() {
		for(DealerOrder o:service.listAllDealerOrder(0, null, null, null)) {
			System.out.println(o);
		}
		/*System.out.println(service.total(null, null, null, null));*/
	}
}
