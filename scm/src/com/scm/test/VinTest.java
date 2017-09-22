package com.scm.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.Vin;
import com.scm.service.VinService;

public class VinTest {
	private VinService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("vinService", VinService.class);
	}

	@Test
	public void test() {
		/*System.out.println(service.addPaymentListId(3, "1J4GA59128L544705"));*/
		
		for(Vin v:service.findByPListId(3)) {
			System.out.println(v.getVinNumber());
		}
	}

}
