package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.DealerSellPlanCensorList;
import com.scm.service.DSellPlanCensorListService;

@Controller
public class DSellPlanCensorListController {
	
	@Resource(name="dSellPlanCensorListService")
	private DSellPlanCensorListService service;
	
	//首页加载
	@RequestMapping("dealerSellPlanCensorList")
	public ModelAndView list(Integer dealerId,String typeCode,Integer year,Integer month) {
		Integer currPage = 1;
		int pageSize = 8;
		int total=service.count(dealerId, typeCode, year, month);// 计算总记录数
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 计算总页数
		
		List<DealerSellPlanCensorList> sellLists=service.findByDealerAndDate(pageSize, 1, dealerId, typeCode, year, month);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/dealerSellPlanCensorList");
		mv.addObject("sellLists", sellLists);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		
		mv.addObject("dealerId", dealerId);
		mv.addObject("typeCode", typeCode);
		mv.addObject("year", year);
		mv.addObject("month", month);
		return mv;
	}
	
	// 分页查询
	@RequestMapping("sellPlanList")
	public ModelAndView fyLog(Integer dealerId,String typeCode,Integer year,Integer month,Integer currPage) {

		int pageSize = 8;// 页大小
		int total=service.count(dealerId, typeCode, year, month);// 计算总记录数
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 计算总页数
		List<DealerSellPlanCensorList> sellLists = null;// 当前页面数据

		
		if (currPage < 1) {//当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			sellLists = service.findByDealerAndDate(pageMax, pageMin, dealerId, typeCode, year, month);
		} else if (currPage > pageAll) {//当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			sellLists = service.findByDealerAndDate(pageMax, pageMin, dealerId, typeCode, year, month);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			sellLists = service.findByDealerAndDate(pageMax, pageMin, dealerId, typeCode, year, month);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/dealerSellPlanCensorList");
		mv.addObject("sellLists", sellLists);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		
		mv.addObject("dealerId", dealerId);
		mv.addObject("typeCode", typeCode);
		mv.addObject("year", year);
		mv.addObject("month", month);
		return mv;
	}
}
