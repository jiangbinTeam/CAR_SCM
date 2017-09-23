package com.scm.test;
/*
 * 全年采购计划 测试类
 */

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.ColorChange;
import com.scm.pojo.ProcurementPlanAnalyze;
import com.scm.pojo.TypeDictionary;
import com.scm.pojo.YearProcurement;
import com.scm.pojo.YearProcurementPlan;
import com.scm.service.ProcurementPlanService;
import com.scm.service.TypeDicService;
import com.scm.service.YearProcurementService;

public class YearProcurementTest {
	
	private YearProcurementService service;
	private TypeDicService service2;
	private ProcurementPlanService service3;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("yearProcurementService",YearProcurementService.class);
		service2 = ctx.getBean("typeDicService",TypeDicService.class);
		service3 = ctx.getBean("procurementPlanService", ProcurementPlanService.class);
	}
	
	@Test
	public void  Add() {
		YearProcurementPlan ypp = new YearProcurementPlan();
		ypp.setYearProcurementPlanYear(2017);
		ypp.setYearProcurementPlanCount(95);
		//ypp.setIfDecomposition(1);
		//ypp.setTypeDictionary(service2.findByTypecode("BM2017V8"));  // 使用车型编码查询车型信息
		ypp.setTypeCode("BM2017V8");
		
		System.out.println(service.add(ypp));
	}
	
	@Test
	public void Update(){
		YearProcurementPlan ypp = new YearProcurementPlan();
		ypp.setYearProcurementPlanId(36);
		ypp.setYearProcurementPlanYear(2017);
		ypp.setYearProcurementPlanCount(85);
		ypp.setIfDecomposition(1);
		ypp.setTypeCode("BM2017V8");
		
		System.out.println(service.update(ypp));
	}
	
	@Test
	public void Update1(){
		ProcurementPlanAnalyze ppa = new ProcurementPlanAnalyze();
		ppa.setProcurementPlanAnalyzeId(21);
		ppa.setProcurementPlanAnalyzeCount(10);
		
		System.out.println(service3.updates(ppa));
	}
	
	@Test
	public void findAll(){
		for(YearProcurement y : service.findAll()){
			System.out.println(y);
		}
	}
	
	//判断本年是否还有未做采购计划的车型
	@Test
	public void find(){
		for(YearProcurement y : service.find()){
			System.out.println(y);
		}
	}
	
	//通过年份查全年采购计划
	@Test
	public void findYear(){
		for(YearProcurement y : service.findYear(2017)){
			System.out.println(y);
		}
	}
	
	//按id查全年采购计划
	@Test
	public void findById(){
	    System.out.println(service.findById(1));
	}
	
	//分页查询
	@Test
	public void findByPage(){
		for (YearProcurement y : service3.findByPage(1, 10,2017)) {
			System.out.println(y.getBrand());
		}
	}
	
	//查询记录条数
	@Test
	public void countPage(){
		System.out.println(service.countPage());
	}
	
	//按年份id查看全年分解计划
	@Test
	public void find1(){
		for (YearProcurement y: service3.findByYear(2017, 63)) {
			System.out.println(y.getProcurementPlanAnalyzeId());
		}
	}
}
