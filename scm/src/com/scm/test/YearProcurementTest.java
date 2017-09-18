package com.scm.test;
/*
 * 全年采购计划 测试类
 */

import org.apache.ibatis.annotations.Update;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.ColorChange;
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
	public void  Add() {
		YearProcurementPlan ypp = new YearProcurementPlan();
		ypp.setYearProcurementPlanYear(2017);
		ypp.setYearProcurementPlanCount(85);
		ypp.setIfDecomposition(1);
		ypp.setTypeDictionary(service2.findByTypecode("BM2017V8"));  // 使用车型编码查询车型信息
		
		System.out.println(service.add(ypp));
	}
	
	@Test
	public void Update(){
		YearProcurementPlan ypp = new YearProcurementPlan();
		ypp.setYearProcurementPlanId(23);
		ypp.setTypeDictionary(service2.findByTypecode("BM2017V8"));
		System.out.println(service.update(ypp));
	}
	
	@Test
	public void findAll(){
		for(YearProcurementPlan y : service.findAll()){
			System.out.println(y);
		}
	}
}
