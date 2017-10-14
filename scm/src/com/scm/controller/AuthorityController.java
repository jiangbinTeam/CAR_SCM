package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.AuthorityInfo;
import com.scm.pojo.Users;
import com.scm.service.AuthorityInfoService;
import com.scm.service.UsersService;
import com.scm.util.MD5;


@Controller
public class AuthorityController {

	@Resource(name = "authorityInfoService")
	private AuthorityInfoService authorityInfoService;
	
	@Resource(name="usersService")
	private UsersService usersService;

	// 首页加载
	@RequestMapping("authority")
	public ModelAndView authority() {

		int currPage = 1;
		int pageSize = 10;// 页大小
		int ct = authorityInfoService.total();// 总记录数
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);// 总页数

		List<AuthorityInfo> authorityInfos = authorityInfoService.listByPage(1, pageSize);// 首页记录

		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/authority");
		mv.addObject("authorityInfos", authorityInfos);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// 分页
	@RequestMapping("authorityInfoByPage")
	public ModelAndView listByPage(@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageSize = 10;// 页大小
		int ct = authorityInfoService.total();// 总记录数
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);// 总页数

		List<AuthorityInfo> authorityInfos = null;
		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			authorityInfos = authorityInfoService.listByPage(pageMin, pageMax);
		} else if (currPage > pageAll) {// 当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			authorityInfos = authorityInfoService.listByPage(pageMin, pageMax);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			authorityInfos = authorityInfoService.listByPage(pageMin, pageMax);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/authority");
		mv.addObject("authorityInfos", authorityInfos);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}
	
	@RequestMapping("authorityCreate")
	public ModelAndView  authorityCreate(Integer  employeeId) {
		AuthorityInfo authorityInfo=authorityInfoService.findByemployeeId(employeeId);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("baseManager/authorityCreate");
		mv.addObject("authorityInfo", authorityInfo);
		return mv;
	}
	
	//增加系统用户或修改权限
	@RequestMapping("saveUser")
	public String  saveUser(String employeeId,Integer enabled) {
		Users user=usersService.findByName(employeeId);
		String[] authoritys= {"禁用","超级管理员","销售人员","采购人员","物流人员","财务人员","管理员"};
		
		if(user==null) {
			user=new Users(employeeId,MD5.getInstance().getMD5ofStr("123456") , enabled);
			usersService.add(user, authoritys[enabled]);
		}else {
			user.setEnabled(enabled);
			usersService.updateEnabled(user, authoritys[enabled]);	
		}
		
		return "redirect:authority";
	}
	
}

















