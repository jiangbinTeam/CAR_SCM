package com.scm.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.AuthorityInfo;
import com.scm.pojo.Users;
import com.scm.service.AuthorityInfoService;
import com.scm.service.UsersService;
import com.scm.util.MD5;

@Controller
// 添加数据到session
public class UsersController {
	@Resource(name = "usersService")
	private UsersService service;

	@Resource(name = "authorityInfoService")
	private AuthorityInfoService authorityInfoService;

	// 登录验证
	@RequestMapping("denglu")
	public String login(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "verifyCode", required = true) String verifyCode, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		String securityCode = (String) session.getAttribute("securityCode");
		// 判断验证码输入是否正确
		if (!securityCode.equals(verifyCode)) {
			modelMap.put("message", "验证码错误！");
			return "login";
		}

		// 判断用户信息是否正确
		if (username != null && password != null) {
			Users us = null;

			password = MD5.getInstance().getMD5ofStr(password);// MD5加密
			us = service.findUser(username, password);// 查询该用户是否存在及密码是否正确
			if (us != null) {
				String userName = us.getUserName();
				AuthorityInfo authorityInfo = authorityInfoService.findByUserName(userName);

				session.setAttribute("authorityInfo", authorityInfo);
				session.setAttribute("user", us);
				try {
					response.sendRedirect("index.jsp");
				} catch (IOException e) {

					e.printStackTrace();
				}
				return null;
			}
		}
		modelMap.put("message", "用户名或密码错误！");
		return "login";
	}

	@RequestMapping("toLogin")
	public ModelAndView toLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	// 退出操作
	@RequestMapping(value = "quit", produces = "text/html;charset=utf-8")
	public void quit(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 修改用户密码
	@RequestMapping("modifyPwd")
	public ModelAndView modifyPwd(HttpServletRequest request, String newpassword, String password) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
	
		String userName = user.getUserName();
		password = MD5.getInstance().getMD5ofStr(password);

		ModelAndView mv = null;

		if (!password.equals(user.getPassword())) {
			mv = new ModelAndView("modifyPwd");
			String error = "用户密码错误！";
			mv.addObject("error", error);
			mv.addObject("newpassword", newpassword);
		} else {
			mv = new ModelAndView("modifyPwd");

			newpassword = MD5.getInstance().getMD5ofStr(newpassword);

			service.UpdatePwd(newpassword, userName);
			mv.addObject("success", "修改成功！");
		}
		return mv;
	}
}
