package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.Logistics;
import com.scm.service.LogisticsService;

public class ScmLogisticsTest {
	private LogisticsService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("scmLogisticsService", LogisticsService.class);
	}

	@Test
	public void testAdd() {
		Logistics scmLogistics = new Logistics();
		scmLogistics.setLogisticsName("韵达");
		scmLogistics.setLogisticsTel("0731-86676102");
		scmLogistics.setLogisticsContact("孙武华");
		scmLogistics.setLogisticsContactTel("15233645886");

		System.out.println(service.add(scmLogistics));
	}

	@Test
	public void testUpdate() {
		Logistics scmLogistics = new Logistics();
		scmLogistics.setLogisticsName("顺丰");
		scmLogistics.setLogisticsTel("0731-86678401");
		scmLogistics.setLogisticsContact("孙武华");
		scmLogistics.setLogisticsContactTel("15919919992");
		scmLogistics.setLogisticsId(3);

		System.out.println(service.update(scmLogistics));
	}

	@Test
	public void testFindAll() {
		for(Logistics s:service.findAll()) {
			System.out.println(s);
		}
	}
	@Test
	public void testFindById() {
		System.out.println(service.findById(3));
	}
}
