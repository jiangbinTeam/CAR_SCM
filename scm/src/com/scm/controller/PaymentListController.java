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

import com.scm.pojo.PaymentList;
import com.scm.pojo.Vin;
import com.scm.service.PaymentListService;
import com.scm.service.VinService;

@Controller
public class PaymentListController {

	@Resource(name = "paymentListService")
	private PaymentListService paymentListService;
	
	@Resource(name="vinService")
	private VinService vinService;

	// 首页加载
	@RequestMapping("paymentList")
	public ModelAndView list() {
		int currPage = 1;
		int pageSize = 10;// 页大小
		int ct = paymentListService.total();// 总记录数
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);// 总页数
		List<PaymentList> paymentLists = paymentListService.listAll(1, pageSize);// 首页记录

		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/paymentList");
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("paymentLists", paymentLists);
		return mv;
	}

	// 分页
	@RequestMapping("paymentListByPage")
	public ModelAndView fyTdy(@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageSize = 10;// 页大小
		int count = paymentListService.total();// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		List<PaymentList> paymentLists = null;// 当前页面数据

		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			paymentLists = paymentListService.listAll(pageMin, pageMax);
		} else if (currPage > pageAll) {// 当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			paymentLists = paymentListService.listAll(pageMin, pageMax);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			paymentLists = paymentListService.listAll(pageMin, pageMax);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/paymentList");
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("paymentLists", paymentLists);
		return mv;
	}
	
	//增加打款单
	@RequestMapping("paymentListAdd")
	public String add(PaymentList paymentList, String mydate,String[] check) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date paymentListDate = sdf.parse(mydate);
			paymentList.setPaymentListDate(paymentListDate);
			paymentListService.add(paymentList, check);
			
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return "redirect:paymentList";
	}
	
	//打款单详情
	@RequestMapping("paymentHistory")
	public ModelAndView paymentHistory(Integer paymentListId) {
		
		List<Vin> vins=vinService.findByPListId(paymentListId);
		PaymentList paymentList=paymentListService.findById(paymentListId);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("finance/paymentListHistory");
		mv.addObject("vins", vins);
		mv.addObject("paymentList", paymentList);
		return mv;
	}
	
}
