package com.scm.test;

import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.ColorChange;
import com.scm.pojo.YearProcurement;
import com.scm.service.ColorChangeService;
import com.scm.service.ProcurementPlanService;
import com.scm.service.TypeDicService;

public class ProcurementPlanTest {
	private ProcurementPlanService service;


	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("procurementPlanService", ProcurementPlanService.class);
		
	}
	
	@Test
	public  void test() {
		for(YearProcurement p:service.findAll(1, 10, 2017, "byd2017V")) {
			System.out.println(p);
		}
		/*System.out.println(service.total(null, "byd2017V"));*/
	}
	
	
}
