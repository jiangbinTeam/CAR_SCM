package com.scm.test;
/*
 * 全年采购计划 测试类
 */

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.YearProcurementPlan;
import com.scm.service.TypeDicService;
import com.scm.service.YearProcurementService;

public class YearProcurementTest {
	
	private YearProcurementService service;
	private TypeDicService service2;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("yearProcurementService",YearProcurementService.class);
		service2 = ctx.getBean("typeDicService",TypeDicService.class);
	}
	
	@Test
	public void findAll(){
		for(YearProcurementPlan y : service.findAll()){
			System.out.println(y);
		}
	}
}
