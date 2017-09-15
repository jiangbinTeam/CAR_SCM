package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.ColorChange;
import com.scm.service.ColorChangeService;
import com.scm.service.TypeDicService;

public class ColorChangeTest {
	private ColorChangeService service;
	private TypeDicService service2;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("colorChangeService", ColorChangeService.class);
		service2=ctx.getBean("scmTypeDicService",TypeDicService.class);
	}
	
	@Test
	public void  testAdd() {
		ColorChange color=new ColorChange();
		color.setColorCode("fl2011-c");
		color.setColorName("黄色");
		color.setTypeDictionary(service2.findByTypecode("fl2017a6"));
		//color.setTypeCode("bc2018v3");

		System.out.println(service.add(color));
	}
	
	@Test
	public void testUpdate() {
		ColorChange color=service.findBycolorCode("bmys-5");
		System.out.println(color);
		
		color.setColorName("粉红");
		System.out.println(service.update(color));
	}
	
	@Test
	public void testList() {
		for(ColorChange c:service.list()) {
			System.out.println(c);
		}
	}
}
