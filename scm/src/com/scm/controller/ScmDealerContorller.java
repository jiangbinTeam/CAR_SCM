package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Dealer;
import com.scm.pojo.TypeDictionary;
import com.scm.service.DealerService;

@Controller
public class ScmDealerContorller {

	@Resource(name = "dealerService")
	private DealerService dealerService;

	// 首页分页数据
	@RequestMapping("ScmDealerlist")
	public ModelAndView list() {
		int currPage = 1;
		int pageSize = 5;// 页大小
		int count = dealerService.total();// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 总页数
		List<Dealer> dealers = dealerService.listByPage(1, pageSize);// 首页记录
		ModelAndView mv = new ModelAndView("baseManager/dealer");
		mv.addObject("dealers", dealers);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// 分页
	@RequestMapping("dealerByPage")
	public ModelAndView fyTdy(@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageSize = 5;// 页大小
		int count = dealerService.total();// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 总页数
		List<Dealer> dealers = null;// 当前页面数据

		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			dealers = dealerService.listByPage(pageMin, pageMax);
		} else if (currPage > pageAll) {// 当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			dealers = dealerService.listByPage(pageMin, pageMax);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			dealers = dealerService.listByPage(pageMin, pageMax);
		}
		
		ModelAndView mv = new ModelAndView("baseManager/dealer");
		mv.addObject("dealers", dealers);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	@RequestMapping("ScmDealersave")
	public String save(Dealer scm) {
		if (scm.getDealerId() != null) {
			dealerService.modifa(scm);
		} else {
			dealerService.add(scm);
		}
		return "redirect:ScmDealerlist";

	}

	@RequestMapping("ScmDealerByid")
	public ModelAndView findByid(@RequestParam(value = "dealerId", required = false) Integer dealerId) {

		ModelAndView mv = new ModelAndView();
		if (dealerId != null) {
			Dealer scmd = dealerService.find(dealerId);
			mv.addObject("scmd", scmd);
		}
		mv.setViewName("baseManager/dealerCreate");
		return mv;

	}

}
