package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Dealer;
import com.scm.pojo.DealerSellPlanCensor;
import com.scm.pojo.TypeDictionary;
import com.scm.service.DealerSellPlanCService;
import com.scm.service.DealerService;
import com.scm.service.TypeDicService;

@Controller
public class DealerSellPlanCController {

	@Resource(name = "dealerSellPlanCService")
	private DealerSellPlanCService service;

	@Resource(name = "typeDicService")
	private TypeDicService typeDicService;

	@Resource(name = "dealerService")
	private DealerService dealerService;

	// 加载首页
	@RequestMapping("dealerSellPlanCensor")
	public ModelAndView shouyePage() {
		Integer currPage = 1;
		int pageSize = 15;

		int total = service.total(null, null, null, null);// 计算总记录数
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 计算总页数
		List<DealerSellPlanCensor> dealerSellPlanCs = service.pageList(1, pageSize, null, null, null, null);// 首页记录

		List<String> years = service.listYear();// 获取所有的年份
		List<TypeDictionary> typeDictionarys = typeDicService.list();// 获取所车型
		List<Dealer> dealers = dealerService.find();// 获取所有的经销商

		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/dealerSellPlanCensor");
		mv.addObject("year", "0");
		mv.addObject("mouth", "0");
		mv.addObject("carType", "0");
		mv.addObject("dealerID", 0);
		mv.addObject("years", years);
		mv.addObject("typeDictionarys", typeDictionarys);
		mv.addObject("dealers", dealers);
		mv.addObject("dealerSellPlanCs", dealerSellPlanCs);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// 分页
	@RequestMapping("listPage")
	public ModelAndView listPage(@RequestParam(value = "currPage", required = true) Integer currPage,
			@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "mouth", required = false) String mouth,
			@RequestParam(value = "carType", required = false) String carType,
			@RequestParam(value = "dealerID", required = false) Integer dealerID) {

		if (year.equals("0") || year.equals("")) {
			year = null;
		}
		if (mouth.equals("0") || mouth.equals("")) {
			mouth = null;
		}
		if (carType.equals("0") || carType.equals("")) {
			carType = null;
		}
		if (dealerID == 0 || dealerID.equals("")) {
			dealerID = null;
		}

		int pageSize = 15;// 页大小
		int count = service.total(year, mouth, carType, dealerID);// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		List<DealerSellPlanCensor> dealerSellPlanCs = null;// 当前页面数据

		List<String> years = service.listYear();// 获取所有的年份
		List<TypeDictionary> typeDictionarys = typeDicService.list();// 获取所车型
		List<Dealer> dealers = dealerService.find();// 获取所有的经销商

		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			dealerSellPlanCs = service.pageList(pageMin, pageMax, year, mouth, carType, dealerID);
		} else if (currPage > pageAll) {// 当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			dealerSellPlanCs = service.pageList(pageMin, pageMax, year, mouth, carType, dealerID);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			dealerSellPlanCs = service.pageList(pageMin, pageMax, year, mouth, carType, dealerID);
		}
		if (year == null || year.equals("")) {
			year = "0";
		}
		if (mouth == null || mouth.equals("")) {
			mouth = "0";
		}
		if (carType == null || carType.equals("")) {
			carType = "0";
		}
		if (dealerID == null || carType.equals("")) {
			dealerID = 0;
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/dealerSellPlanCensor");
		mv.addObject("year", year);
		mv.addObject("mouth", mouth);
		mv.addObject("carType", carType);
		mv.addObject("dealerID", dealerID);
		
		mv.addObject("years", years);
		mv.addObject("typeDictionarys", typeDictionarys);
		mv.addObject("dealers", dealers);
		mv.addObject("dealerSellPlanCs", dealerSellPlanCs);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

}
