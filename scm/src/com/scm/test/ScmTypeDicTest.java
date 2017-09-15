package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.TypeDictionary;
import com.scm.service.TypeDicService;

public class ScmTypeDicTest {
	private TypeDicService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("scmTypeDicService", TypeDicService.class);
	}
	
	@Test
	public void testAdd() {
		TypeDictionary scmTypeDic=new TypeDictionary();
		scmTypeDic.setTypeCode("fl2017a6");
		scmTypeDic.setBrand("法拉利");
		scmTypeDic.setCarCharacter("5.0  自动  中置");
		
		System.out.println(service.add(scmTypeDic));
	}
	@Test
	public void  testUpdate() {
		TypeDictionary scmTypeDic=service.findByTypecode("bm216v3");
		//System.out.println(scmTypeDic);
		
		scmTypeDic.setCarCharacter("4.0  手动 后驱");

		System.out.println(service.update(scmTypeDic));
	}
	
	@Test
	public void testList() {
		for(TypeDictionary s:service.list()) {
			System.out.println(s);
		}
	}

}
