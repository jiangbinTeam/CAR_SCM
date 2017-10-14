package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Billing;
import com.scm.pojo.Warehouse;
import com.scm.service.BillingService;

@Controller
public class BillingController {
	@Resource(name="billingService")
	private BillingService billingService;
	
	@RequestMapping("Billinglist")
	public ModelAndView list(){
		Integer currPage = 1;
		int pageSize = 10;
		int total=billingService.totalcount(null);
		int pageAll=(int) Math.ceil(total * 1.0 / pageSize);
		List <Billing> bila=billingService.pagelist(1, pageSize, null);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/invoiceNumber");
		
		mv.addObject("bila", bila);
		mv.addObject("currPage", currPage);
		mv.addObject("pageAll", pageAll);
		return mv;
	}
	
	@RequestMapping("BillinglistByPage")
	public ModelAndView listByPage(@RequestParam(value = "currPage", required = false) Integer currPage){
		
		int pageSize = 10;
		int total=billingService.totalcount(null);
		int pageAll=(int) Math.ceil(total * 1.0 / pageSize);
		List <Billing> bila = null;

		if (currPage < 1) {
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			bila  = billingService.pagelist(pageMin, pageMax,null);
		} else if (currPage > pageAll) {
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			bila  = billingService.pagelist(pageMin, pageMax,null);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			bila  = billingService.pagelist(pageMin, pageMax,null);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/invoiceNumber");
		
		mv.addObject("bila", bila);
		mv.addObject("currPage", currPage);
		mv.addObject("pageAll", pageAll);
		return mv;
	}
	
	@RequestMapping("Billingupdate")
	public String save(Billing bil){
		System.out.println(bil);
		if(bil.getVinNumber()!=null){
			billingService.modifa(bil);
		System.out.println(bil.getVinNumber());
		}
		return "redirect:Billinglist";
		
	}

	
} 
