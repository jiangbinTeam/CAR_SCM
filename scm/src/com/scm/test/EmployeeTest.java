package com.scm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.Employee;
import com.scm.service.EmployeeService;

public class EmployeeTest {
	private EmployeeService service;

	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = ctx.getBean("employeeService", EmployeeService.class);
	}
	
	@Test
	public void testPage() {
		for(Employee e:service.listByPage(1, 5)) {
			System.out.println(e);
		}
	}

}
