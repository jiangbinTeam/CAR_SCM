package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Logistics;
import com.scm.service.LogisticsService;

@Controller
public class ScmLogisticsController {

	@Resource(name = "logisticsService")
	private LogisticsService logisticsService;

	/*
	 * @RequestMapping("logistics") public ModelAndView list() { List<Logistics>
	 * logisticsList = logisticsService.findAll(); ModelAndView mv = new
	 * ModelAndView("baseManager/logistics"); mv.addObject("logisticsList",
	 * logisticsList); return mv; }
	 */

	@RequestMapping("logisticsCreate")
	public ModelAndView edit(@RequestParam(value = "logisticsId", required = false) Integer logisticsId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/logisticsCreate");
		if (logisticsId == null) {
			return mv;
		} else {
			Logistics logistics = logisticsService.findById(logisticsId);
			mv.addObject("logistics", logistics);
			return mv;
		}
	}

	@RequestMapping("logisticsEdit")
	public String addOrUpdate(Logistics scmLogistics) {
		if (scmLogistics.getLogisticsId() != null && scmLogistics != null) {
			logisticsService.update(scmLogistics);
		} else {
			logisticsService.add(scmLogistics);
		}
		return "redirect:logistics";
	}

	// 分页
	@RequestMapping("logistics")
	public ModelAndView logistics() {
		
		Integer currPage = 1;
		int pageSize = 5;

		int total = logisticsService.count();// 计算总记录数
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 计算总页数
		List<Logistics> logisticsList = logisticsService.findByPage(1, pageSize);// 首页记录

		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/logistics");
		mv.addObject("logisticsList", logisticsList);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// 分页查询
	@RequestMapping("fyLog")
	public ModelAndView fyLog(@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageSize = 5;// 页大小
		int count = logisticsService.count();// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		List<Logistics> logisticsList = null;// 当前页面数据

		
		if (currPage < 1) {//当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			logisticsList = logisticsService.findByPage(pageMin, pageMax);
		} else if (currPage > pageAll) {//当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			logisticsList = logisticsService.findByPage(pageMin, pageMax);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			logisticsList = logisticsService.findByPage(pageMin, pageMax);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/logistics");
		mv.addObject("logisticsList", logisticsList);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

}
