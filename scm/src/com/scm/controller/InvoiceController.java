package com.scm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Dealer;
import com.scm.pojo.Invoice;
import com.scm.pojo.Invoice2;
import com.scm.pojo.Invoice3;
import com.scm.pojo.Logistics;
import com.scm.service.InvoiceService;

@Controller
public class InvoiceController {
	@Resource(name = "InvoiceService")
	private InvoiceService service;

	// 查询所有发车管理数据
	@RequestMapping(value = "InvoiceAll", produces = "application/json; charset=utf-8")
	public ModelAndView InvoiceAll(HttpServletRequest request) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String st1 = "2017-08-09";

		Integer dealerId = null;
		Date startDate = null;
		Date accessCarDate = sdf.parse(st1);
		Integer pageMin = 1;
		Integer pageSize = 5;
		int ct = service.countIod(dealerId, startDate, accessCarDate);
		// System.out.println(ct+"统计数量");
		int pageMax = pageMin * pageSize;
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		// System.out.println(pageAll+"页数");
		ModelAndView mv = new ModelAndView();
		List<Invoice2> invoice2s = service.findInvoice(dealerId, startDate, accessCarDate, pageMin, pageMax);
		List<Dealer> dealers = service.dealers();
		HttpSession session = request.getSession();
		session.setAttribute("dealers", dealers);
		mv.addObject("invoice2s", invoice2s);
		mv.addObject("currPage", pageMin);
		mv.addObject("totalPage", pageAll);
		mv.addObject("dealerId", -1);
		mv.addObject("fczt", 0);
		mv.setViewName("logisticsManager/invoice");
		return mv;
	}

	// 按条件查询发车管理数据
	@RequestMapping(value = "InvoiceTwo", produces = "application/json; charset=utf-8")
	public ModelAndView InvoiceTwo(@RequestParam(value = "dealerId", required = false) Integer dealerId,
			@RequestParam(value = "fczt", required = false) Integer fczt) throws ParseException {
		// @RequestParam(value = "currPage", required = false) Integer currPage
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String st1 = "2017-08-09";
		String st2 = "2017-09-09";
		Date de1 = sdf.parse(st1);
		Date de2 = sdf.parse(st2);
		if (dealerId == -1) {
			dealerId = null;
		}
		Date startDate = null;
		Date accessCarDate = null;
		if (fczt == 0 || fczt == null) {
			startDate = null;
			accessCarDate = de2;
		}
		if (fczt == 1) {
			startDate = null;
			accessCarDate = null;
		}
		if (fczt == 2) {
			startDate = de1;
			accessCarDate = null;
		}
		if (fczt == 3) {
			startDate = de1;
			accessCarDate = de2;
		}
		Integer pageMin = 1;
		Integer pageSize = 5;
		int ct = service.countIod(dealerId, startDate, accessCarDate);
		int pageMax = pageMin * pageSize;
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		ModelAndView mv = new ModelAndView();
		List<Invoice2> invoice2s = service.findInvoice(dealerId, startDate, accessCarDate, pageMin, pageMax);
		/* List<Dealer> dealers=service.dealers(); */
		mv.addObject("invoice2s", invoice2s);
		mv.addObject("currPage", pageMin);
		mv.addObject("totalPage", pageAll);
		if (dealerId == null) {
			dealerId = -1;
		}
		mv.addObject("dealerId", dealerId);
		mv.addObject("fczt", fczt);
		mv.setViewName("logisticsManager/invoice");
		return mv;
	}

	// 按条件管理分页
	@RequestMapping(value = "fyInvoice", produces = "application/json; charset=utf-8")
	public ModelAndView fyInvoice(@RequestParam(value = "dealerId", required = false) Integer dealerId,
			@RequestParam(value = "fczt", required = false) Integer fczt,
			@RequestParam(value = "currPage", required = false) Integer currPage) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String st1 = "2017-08-09";
		String st2 = "2017-09-09";
		Date de1 = sdf.parse(st1);
		Date de2 = sdf.parse(st2);
		if (dealerId == -1) {
			dealerId = null;
		}
		Date startDate = null;
		Date accessCarDate = null;
		if (fczt == 0 || fczt == null) {
			startDate = null;
			accessCarDate = de2;
		}
		if (fczt == 1) {
			startDate = null;
			accessCarDate = null;
		}
		if (fczt == 2) {
			startDate = de1;
			accessCarDate = null;
		}
		if (fczt == 3) {
			startDate = de1;
			accessCarDate = de2;
		}
		Integer pageSize = 5;

		int ct = service.countIod(dealerId, startDate, accessCarDate);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > pageAll) {
			currPage = pageAll;
		}
		Integer pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;

		ModelAndView mv = new ModelAndView();
		List<Invoice2> invoice2s = service.findInvoice(dealerId, startDate, accessCarDate, pageMin, pageMax);
		/* List<Dealer> dealers=service.dealers(); */
		mv.addObject("invoice2s", invoice2s);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		if (dealerId == null) {
			dealerId = -1;
		}
		mv.addObject("dealerId", dealerId);
		mv.addObject("fczt", fczt);
		mv.setViewName("logisticsManager/invoice");
		return mv;
	}

	// 确认发车日期
	@RequestMapping(value = "addStartDate", produces = "application/json; charset=utf-8")
	public String addStartDate(@RequestParam(value = "invoiceId", required = false) Integer invoiceId,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "dealerId", required = false) Integer dealerId,
			@RequestParam(value = "fczt", required = false) Integer fczt,
			@RequestParam(value = "currPage", required = false) Integer currPage) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate2 = sdf.parse(startDate);
		int a = service.addStartDate(invoiceId, startDate2);
		Integer startAccountingStates = 2;
		int b = service.updStartA(invoiceId, startAccountingStates);
		// System.out.println("确认发车"+a);
		String st1 = dealerId.toString();
		String st2 = fczt.toString();
		String st3 = currPage.toString();
		return "redirect:fyInvoice?dealerId=" + st1 + "&fczt=" + st2 + "&currPage=" + st3;

	}

	// 确认接车
	@RequestMapping(value = "addAccessCarDate", produces = "application/json; charset=utf-8")
	public String addAccessCarDate(@RequestParam(value = "invoiceId", required = false) Integer invoiceId,
			@RequestParam(value = "accessCarDate", required = false) String accessCarDate,
			@RequestParam(value = "dealerId", required = false) Integer dealerId,
			@RequestParam(value = "fczt", required = false) Integer fczt,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "carriageCharge", required = false) String carriageCharge) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date accessCarDate2 = sdf.parse(accessCarDate);
		int b = service.addAccessCarDate(invoiceId, accessCarDate2);
		// System.out.println("确认接车"+b);
		Double carriageCharge2 = Double.parseDouble(carriageCharge);
		int c = service.addYunFei(invoiceId, carriageCharge2);
		Integer startAccountingStates = 3;
		int d = service.updStartA(invoiceId, startAccountingStates);
		// System.out.println("添加运费"+c);
		String st1 = dealerId.toString();
		String st2 = fczt.toString();
		String st3 = currPage.toString();
		return "redirect:fyInvoice?dealerId=" + st1 + "&fczt=" + st2 + "&currPage=" + st3;

	}

	// 查看详情
	@RequestMapping(value = "findStaInv", produces = "application/json; charset=utf-8")
	public ModelAndView findStaInv(@RequestParam(value = "invoiceId", required = false) Integer invoiceId) {

		ModelAndView mv = new ModelAndView();
		Integer pageMin = 1;
		Integer pageSize = 2;
		Integer pageMax = 2;
		List<Invoice3> invoice3s = service.findInvoice3s(invoiceId, pageMin, pageMax);
		Invoice2 invoice2 = service.findInvoiceById(invoiceId);
		int ct = service.countStadInv(invoiceId);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		mv.addObject("currPage", 1);
		mv.addObject("totalPage", pageAll);
		mv.addObject("invoice3s", invoice3s);
		mv.addObject("invoice2", invoice2);
		mv.addObject("invoiceId", invoiceId);
		mv.setViewName("logisticsManager/invoiceSelect");
		return mv;
	}

	// 查看详情分页
	@RequestMapping(value = "fyStaInv", produces = "application/json; charset=utf-8")
	public ModelAndView fyStaInv(@RequestParam(value = "invoiceId", required = false) Integer invoiceId,
			@RequestParam(value = "currPage", required = false) Integer currPage) {
		ModelAndView mv = new ModelAndView();

		Integer pageSize = 2;
		int ct = service.countStadInv(invoiceId);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > pageAll) {
			currPage = pageAll;
		}
		Integer pageMax = currPage * pageSize;
		Integer pageMin = (currPage - 1) * pageSize + 1;
		List<Invoice3> invoice3s = service.findInvoice3s(invoiceId, pageMin, pageMax);
		Invoice2 invoice2 = service.findInvoiceById(invoiceId);

		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("invoice3s", invoice3s);
		mv.addObject("invoice2", invoice2);
		mv.addObject("invoiceId", invoiceId);
		mv.setViewName("logisticsManager/invoiceSelect");
		return mv;
	}

	// 进入创建发车单面页
	@RequestMapping(value = "createInvoice1", produces = "application/json; charset=utf-8")
	public ModelAndView createInvoice1() {
		ModelAndView mv = new ModelAndView();
		List<Logistics> logistics = service.findLogs();
		Integer pageMin = 1;
		Integer pageMax = 5;
		Integer pageSize = 5;
		Integer ct = service.countCinv();
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		List<Invoice3> invoice3s = service.findtdyvs(pageMin, pageMax);
		mv.addObject("currPage", 1);
		mv.addObject("totalPage", pageAll);
		mv.addObject("logistics", logistics);
		mv.addObject("invoice3s", invoice3s);
		mv.setViewName("logisticsManager/invoiceCreate");
		return mv;
	}

	// 创建发车单资料分页
	@RequestMapping(value = "fyCinv", produces = "application/json; charset=utf-8")
	public ModelAndView fyCinv(@RequestParam(value = "currPage", required = false) Integer currPage) {
		ModelAndView mv = new ModelAndView();
		Integer pageSize = 5;
		Integer ct = service.countCinv();
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > pageAll) {
			currPage = pageAll;
		}
		Integer pageMin = (currPage - 1) * pageSize + 1;
		Integer pageMax = currPage * pageSize;
		List<Logistics> logistics = service.findLogs();
		List<Invoice3> invoice3s = service.findtdyvs(pageMin, pageMax);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("logistics", logistics);
		mv.addObject("invoice3s", invoice3s);
		mv.setViewName("logisticsManager/invoiceCreate");
		return mv;

	}

	// 创建发车单
	@RequestMapping(value = "createInv", produces = "application/json; charset=utf-8")
	public String createInv(@RequestParam(value = "logisticsId", required = false) Integer logisticsId,
			@RequestParam(value = "dealerId", required = false) Integer dealerId,
			@RequestParam(value = "carriageCharge", required = false) Double carriageCharge,
			@RequestParam(value = "invoiceNumber", required = false) String invoiceNumber,
			// @RequestParam(value="startAccountingId" ,required=false) Integer
			// startAccountingId,
			HttpServletRequest request) {
		String[] startAccountingIds = request.getParameterValues("startAccountingId");
		int a = service.createInv(logisticsId, dealerId, carriageCharge, invoiceNumber);
		int invoiceId = service.findInvoiceId();
		int b = 0;
		for (String s : startAccountingIds) {
			Integer startAccountingId = Integer.parseInt(s);
			b += service.upstata(invoiceId, startAccountingId);
		}
		System.out.println("a=" + a + ":invoiceId=" + invoiceId + ":b=" + b);
		return "redirect:InvoiceAll";
	}

	// 进入修改页面
	@RequestMapping(value = "inUpdInv", produces = "application/json; charset=utf-8")
	public ModelAndView inUpdInv(@RequestParam(value = "invoiceId", required = false) Integer invoiceId) {
		ModelAndView mv = new ModelAndView();
		int pageMin = 1;
		int pageSize = 5;
		int pageMax = 5;
		int ct = service.countUinv(invoiceId);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		List<Invoice3> invoice3s = service.findInvoice3s(invoiceId, pageMin, pageMax);
		List<Logistics> logistics = service.findLogs();

		Invoice invoice = service.findById(invoiceId);
		System.out.println(invoice);
		mv.addObject("invoice", invoice);

		mv.addObject("currPage", 1);
		mv.addObject("totalPage", pageAll);
		mv.addObject("logistics", logistics);
		mv.addObject("invoice3s", invoice3s);
		mv.addObject("invoiceId", invoiceId);
		mv.setViewName("logisticsManager/invoiceUpdate");
		return mv;
	}

	// 进入修改页面后的分页
	@RequestMapping(value = "fyUpdInv", produces = "application/json; charset=utf-8")
	public ModelAndView fyUpdInv(@RequestParam(value = "invoiceId", required = false) Integer invoiceId,
			@RequestParam(value = "currPage", required = false) Integer currPage) {
		ModelAndView mv = new ModelAndView();
		int pageSize = 5;
		int ct = service.countUinv(invoiceId);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > pageAll) {
			currPage = pageAll;
		}
		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;

		List<Invoice3> invoice3s = service.findInvoice3s(invoiceId, pageMin, pageMax);
		List<Logistics> logistics = service.findLogs();
		Invoice invoice = service.findById(invoiceId);
		System.out.println(invoice);
		mv.addObject("invoice", invoice);

		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("logistics", logistics);
		mv.addObject("invoice3s", invoice3s);
		mv.addObject("invoiceId", invoiceId);
		mv.setViewName("logisticsManager/invoiceUpdate");
		return mv;
	}

	// 修改发车单资料
	@RequestMapping(value = "xgUpdInv", produces = "application/json; charset=utf-8")
	public String xgUpdInv(@RequestParam(value = "logisticsId", required = false) Integer logisticsId,
			@RequestParam(value = "dealerId", required = false) Integer dealerId,
			@RequestParam(value = "carriageCharge", required = false) Double carriageCharge,
			@RequestParam(value = "invoiceNumber", required = false) String invoiceNumber,
			@RequestParam(value = "invoiceId", required = false) Integer invoiceId) {
		int a = service.xgInv(logisticsId, dealerId, carriageCharge, invoiceNumber, invoiceId);
		return "redirect:InvoiceAll";

	}
}
