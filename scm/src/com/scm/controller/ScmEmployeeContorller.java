package com.scm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.ColorChange;
import com.scm.pojo.Employee;
import com.scm.service.EmployeeService;


@Controller
public class ScmEmployeeContorller {
	
	@Resource(name = "employeeService")
	private EmployeeService employeeService;

	@RequestMapping("ScmEmployeelist")
	public ModelAndView list() {
		Integer currPage = 1;
		int pageSize = 15;// 页大小
		int total = employeeService.total();// 总记录数
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 总页数
		
		List<Employee> emp = employeeService.listByPage(1, pageSize);
		
		ModelAndView mv = new ModelAndView("baseManager/employee");
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("emp", emp);
		return mv;
	}
	

	// 点击分页工具
	@RequestMapping("listByPage")
	public ModelAndView fyCol(@RequestParam(value = "currPage", required = false) Integer currPage) {
		
		int pageSize = 15;// 页大小
		int total = employeeService.total();// 总记录数
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 总页数
		List<Employee> emp = null;// 当前页面数据

		
		if (currPage < 1) {//当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			emp = employeeService.listByPage(pageMin, pageMax);
		} else if (currPage > pageAll) {//当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			emp = employeeService.listByPage(pageMin, pageMax);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			emp = employeeService.listByPage(pageMin, pageMax);
		}
	
		ModelAndView mv = new ModelAndView("baseManager/employee");
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("emp", emp);
		return mv;
	}
	
	//修改OR增加
	@RequestMapping("ScmEmployeesave")
	public String save(Employee emp,String birthday) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date employeeBirthday=sdf.parse(birthday);
			emp.setEmployeeBirthday(employeeBirthday);
		
			if (emp.getEmployeeId() != null) {
				employeeService.modifa(emp);
			} else {
				employeeService.add(emp);
			}
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return "redirect:ScmEmployeelist";

	}
	
	//查询
	@RequestMapping("ScmEmployeeByid")
	public ModelAndView findByid(@RequestParam(value = "employeeId", required = false) Integer employeeId) {
		ModelAndView mv = new ModelAndView();
		if (employeeId != null) {
			Employee emp = employeeService.find1(employeeId);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String birthday=sdf.format(emp.getEmployeeBirthday());
			
			mv.addObject("birthday",birthday);
			mv.addObject("emp", emp);
		}
		mv.setViewName("baseManager/employeeCreate");
		return mv;

	}	
	
}
