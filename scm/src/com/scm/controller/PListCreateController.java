package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.PaymentListCreate;
import com.scm.service.PListCreateService;

@Controller
public class PListCreateController {
	
	@Resource(name="pListCreateService")
	private PListCreateService pListCreateService;
	
	@RequestMapping("paymentListCreate")
	public ModelAndView list() {
		List<PaymentListCreate> pListCreates= pListCreateService.findAll();
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("finance/paymentListCreate");
		mv.addObject("pListCreates", pListCreates);
		return mv;
	}
}
