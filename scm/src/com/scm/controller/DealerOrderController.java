package com.scm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.ColorChange;
import com.scm.pojo.Dealer;
import com.scm.pojo.DealerOrder;
import com.scm.pojo.DealerOrderDetails;
import com.scm.pojo.DealerOrderDetails2;
import com.scm.pojo.TypeDictionary;
import com.scm.service.DealerOrderService;

import jdk.nashorn.internal.ir.ForNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class DealerOrderController {
	@Resource(name = "DealerOrderService")
	private DealerOrderService service;

	// 首页加载
	@RequestMapping("findAllDealer")
	public ModelAndView findAllDealer(HttpServletRequest request, HttpSession session) {

		List<DealerOrder> dealerOrders = service.listAllDealerOrder(null, null, null, null);

		ModelAndView mv = new ModelAndView();
		session = request.getSession();
		List<Dealer> dealers = service.dealers();
		// mv.addObject("dealers",dealers);
		session.setAttribute("dealers", dealers);
		mv.setViewName("sellManager/dealerOrderManager");
		mv.addObject("dealerOrders", dealerOrders);
		return mv;
	}

	// 条件查询
	@RequestMapping("FindListDealerOrder")
	public ModelAndView listDealerOrderByPage(@RequestParam(value = "dealerId", required = false) Integer dealerId,
			@RequestParam(value = "beginDate", required = false) String beginDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "orderNumber", required = false) String orderNumber) {

		dealerId = dealerId == 0 ? null : dealerId;
		// System.out.println(dealerId+"--"+beginDate+"--"+endDate+"--"+orderNumber);
		List<DealerOrder> dealerOrders = service.listAllDealerOrder(dealerId, beginDate, endDate, orderNumber);

		ModelAndView mv = new ModelAndView();
		// dealerId=dealerId==null?0:dealerId;
		// System.out.println(dealerId+"-/-"+beginDate+"-/-"+endDate+"-/-"+orderNumber);
		mv.setViewName("sellManager/dealerOrderManager");
		mv.addObject("dealerOrders", dealerOrders);
		mv.addObject("dealerId", dealerId);
		mv.addObject("beginDate", beginDate);
		mv.addObject("endDate", endDate);
		mv.addObject("orderNumber", orderNumber);
		return mv;

	}

	// 按条件查询所有订单
	@RequestMapping(value = "findDealerOrder", produces = "application/json; charset=utf-8")
	public ModelAndView findDealerOrder(
			// @RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "dealerId", required = true) Integer dealerId,
			@RequestParam(value = "beginDate", required = false) String beginDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "orderNumber", required = false) String orderNumber) throws ParseException {

		Integer pageMin = 1;
		Integer pageSize = 5;
		Integer pageMax = pageMin * 5;
		// String orderNumber1="";
		if (orderNumber == null || orderNumber.equals("")) {
			orderNumber = null;
			System.out.println(orderNumber);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate1 = null;
		Date endDate1 = null;

		if (beginDate == null || beginDate.equals("")) {
			beginDate1 = null;

		} else {

			beginDate1 = sdf.parse(beginDate);
		}

		if (endDate == null || endDate.equals("")) {

			endDate1 = null;
		} else {
			endDate1 = sdf.parse(endDate);
		}

		int ct = service.countDealerOrder(dealerId, beginDate1, endDate1, orderNumber);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		List<DealerOrder> dealerOrders = service.findAll(pageMin, pageMax, dealerId, beginDate1, endDate1, orderNumber);
		ModelAndView mv = new ModelAndView();

		mv.addObject("dealerOrders", dealerOrders);
		mv.addObject("currPage", pageMin);
		mv.addObject("totalPage", pageAll);
		mv.addObject("dealerId", dealerId);
		if (dealerOrders.size() > 0) {
			mv.addObject("sb", "sb");
		}

		if (beginDate != null && !beginDate.equals("")) {
			mv.addObject("beginDate", beginDate);
		}
		if (endDate != null && !endDate.equals("")) {
			mv.addObject("endDate", endDate);
		}
		if (orderNumber != null && !orderNumber.equals("")) {
			mv.addObject("orderNumber", orderNumber);
		}

		mv.setViewName("sellManager/dealerOrderManager");

		return mv;
	}

	// 按条件查询所有订单分页
	@RequestMapping(value = "fydod", produces = "application/json; charset=utf-8")
	public ModelAndView fydod(@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "dealerId", required = true) Integer dealerId,
			@RequestParam(value = "beginDate", required = false) String beginDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "orderNumber", required = false) String orderNumber) throws ParseException {
		if (currPage == null || currPage.equals("")) {
			currPage = 1;
		}
		int pageSize = 5;
		String st = "sbs";
		String st2 = null;
		if (orderNumber == null || orderNumber.equals("") || orderNumber.equals(st)) {
			orderNumber = null;

			// System.out.println(orderNumber);
		} else {
			st2 = orderNumber;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate1 = null;
		Date endDate1 = null;
		if (beginDate == null || beginDate.equals("") || beginDate.equals(st)) {
			beginDate1 = null;

		} else {

			beginDate1 = sdf.parse(beginDate);
		}
		if (endDate == null || endDate.equals("") || endDate.equals(st)) {

			endDate1 = null;
		} else {
			endDate1 = sdf.parse(endDate);
		}

		int ct = service.countDealerOrder(dealerId, beginDate1, endDate1, st2);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > pageAll) {
			currPage = pageAll;
		}

		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;

		List<DealerOrder> dealerOrders = service.findAll(pageMin, pageMax, dealerId, beginDate1, endDate1, st2);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dealerOrders", dealerOrders);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("dealerId", dealerId);
		if (dealerOrders.size() > 0) {
			mv.addObject("sb", "sb");
		}

		if (beginDate != null && !beginDate.equals("") && !beginDate.equals(st)) {
			mv.addObject("beginDate", beginDate);
		}
		if (endDate != null && !endDate.equals("") && !endDate.equals(st)) {
			mv.addObject("endDate", endDate);
		}
		String sd = "sbs";
		if (orderNumber != null && !orderNumber.equals("") && !orderNumber.equals(sd) && st2 != null
				&& st2.equals(sd)) {
			mv.addObject("orderNumber", st2);
			// System.out.println(orderNumber);
			// System.out.println(st);
		}
		mv.setViewName("sellManager/dealerOrderManager");

		return mv;
	}

	// 按订单ID查询订单明细
	@RequestMapping(value = "findDetails", produces = "application/json; charset=utf-8")
	public ModelAndView findDetails(Integer dealerOrderId) {
		Integer pageMin = 1;
		Integer pageSize = 5;
		Integer pageMax = pageMin * pageSize;

		ModelAndView mv = new ModelAndView();
		DealerOrder dealerOrder = service.findById(dealerOrderId);
		List<DealerOrderDetails2> details2 = service.findDealDetails(dealerOrderId, pageMin, pageMax);
		int ct = service.countDetails(dealerOrderId);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		/*
		 * System.out.println(pageAll); for (DealerOrderDetails2 ss:details2) {
		 * System.out.println(ss.getIfCreateStartAccounting()+"-----"); }
		 */

		List<String> vins = service.findVin(dealerOrderId);
		System.out.println(vins.size());
		mv.setViewName("sellManager/createStartAccounting");
		mv.addObject("dealerOrder", dealerOrder);
		mv.addObject("details2", details2);
		mv.addObject("currPage", pageMin);
		mv.addObject("totalPage", pageAll);
		mv.addObject("dealerOrderId", dealerOrderId);
		mv.addObject("vins", vins);
		return mv;
	}

	// 按订单ID查询订单明细分页
	@RequestMapping(value = "fydods2", produces = "application/json; charset=utf-8")
	public ModelAndView fydods2(@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "dealerOrderId", required = true) Integer dealerOrderId) throws ParseException {
		if (currPage == null || currPage.equals("")) {
			currPage = 1;
		}
		int pageSize = 5;
		System.out.println(dealerOrderId + "dealerOrderId");
		int ct = service.countDetails(dealerOrderId);
		System.out.println(ct + "ct");
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		System.out.println(pageAll);
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > pageAll) {
			currPage = pageAll;
		}

		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;
		DealerOrder dealerOrder = service.findById(dealerOrderId);
		List<DealerOrderDetails2> details2 = service.findDealDetails(dealerOrderId, pageMin, pageMax);
		List<String> vins = service.findVin(dealerOrderId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dealerOrder", dealerOrder);
		mv.addObject("details2", details2);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("dealerOrderId", dealerOrderId);
		mv.addObject("vins", vins);

		mv.setViewName("sellManager/createStartAccounting");

		return mv;
	}

	// 经销商添加订单第一步
	@RequestMapping("addDealOrder1")
	public ModelAndView addDealOrder1() {
		ModelAndView mv = new ModelAndView();
		List<ColorChange> colorChanges = service.colorChanges();
		List<TypeDictionary> typeDictionaries = service.typeDictionaries();
		mv.setViewName("sellManager/createSellList");
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("typeDictionaries", typeDictionaries);
		return mv;
	}

	// 经销商添加订单第二步
	@RequestMapping(value = "addDealOrder2", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addDealOrder2() {
		// JsonConfig jsonConfig = new JsonConfig();
		List<TypeDictionary> typeDictionaries = service.typeDictionaries();
		// JSONObject json = (JSONObject) JSONSerializer.toJSON(typeDictionaries,
		// jsonConfig);
		JSONArray jsons = JSONArray.fromObject(typeDictionaries);
		System.out.println(jsons.toString());
		return jsons.toString();
	}

	// 经销商添加订单第三步
	@RequestMapping(value = "addDealOrder3", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addDealOrder3() {
		// JsonConfig jsonConfig = new JsonConfig();
		List<ColorChange> colorChanges = service.colorChanges();
		// JSONObject json = (JSONObject) JSONSerializer.toJSON(colorChanges,
		// jsonConfig);
		JSONArray jsons = JSONArray.fromObject(colorChanges);
		System.out.println(jsons.toString());
		return jsons.toString();
	}

	// 经销商添加订单第三步
	@RequestMapping(value = "addDealOrder4", produces = "application/json; charset=utf-8")
	public String addDealOrder4(@RequestParam(value = "certificateDate", required = true) String certificateDate,
			@RequestParam(value = "dealerId", required = true) Integer dealerId,
			/* @RequestBody List<DealerOrderDetails> DealerOrderDetails */
			HttpServletRequest request) throws ParseException {
		System.out.println(certificateDate);
		System.out.println(dealerId);
		List<String> typeCodeas = new ArrayList<String>();
		List<String> colorCodes = new ArrayList<String>();
		List<String> addAccessorizeNotes = new ArrayList<String>();

		for (String s : request.getParameterValues("typeCode")) {
			typeCodeas.add(s);
		}
		for (String s : request.getParameterValues("colorCode")) {
			colorCodes.add(s);
		}
		for (String s : request.getParameterValues("addAccessorizeNote")) {
			addAccessorizeNotes.add(s);
		}
		/*
		 * while (request.getParameterNames().hasMoreElements()) { String name=(String)
		 * request.getParameterNames().nextElement(); String
		 * value=request.getParameter(name); System.out.println(value);
		 * 
		 * }
		 */

		DealerOrder dealerOrder = new DealerOrder();
		dealerOrder.setOrderNumber("11111w");
		dealerOrder.setDealerId(dealerId);
		dealerOrder.setDealerOrderId(121);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(certificateDate);
		dealerOrder.setCertificateDate(date);
		int a = service.addDealerOrder(dealerOrder);
		System.out.println(a + "第一次");
		if (a > 0) {
			int id = service.dealorderId();
			for (int i = 0; i < typeCodeas.size(); i++) {
				DealerOrderDetails ds = new DealerOrderDetails();
				ds.setDealerOrderId(id);
				ds.setDealerOrderDetailsId(111);
				ds.setIfCreateStartAccounting(0);
				ds.setTypeCode(typeCodeas.get(i));
				ds.setColorCode(colorCodes.get(i));
				ds.setAddAccessorizeNote(addAccessorizeNotes.get(i));
				if (ds.getAddAccessorizeNote() == null || ds.getAddAccessorizeNote().equals("")) {
					ds.setAddAccessorizeNote("无");
				}
				int ab = service.addDealerOrderDetails(ds);
				System.out.println(ab + "第二次-->OK");
			}
		}

		String dealerIds = dealerId.toString();
		String beginDate = "";
		String endDate = "";
		String orderNumbe = "";
		return "redirect:fydod?currPage=1&dealerId=" + dealerIds + "&" + "beginDate=" + beginDate + "&endDate="
				+ endDate + "&orderNumbe=" + orderNumbe;
	}

	// 查询所有Vin号
	@RequestMapping("findVins")
	public ModelAndView findVins(Integer dealerOrderId) {
		List<String> vins = service.findVin(dealerOrderId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/ChooseVin");
		mv.addObject("vins", vins);
		mv.addObject("dealerOrderId", dealerOrderId);
		return mv;
	}

	// 生产发车台账
	@RequestMapping(value = "fctz", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String fctz(HttpServletRequest request) {
		/*
		 * @RequestParam(value = "dealerOrderId", required = false) Integer
		 * dealerOrderId,
		 * 
		 * @RequestParam(value = "dealerOrderDetailsId", required = false) Integer
		 * dealerOrderDetailsId,
		 * 
		 * @RequestParam(value = "sellPrice", required = false) String sellPrice,
		 * 
		 * @RequestParam(value = "vinNumber", required = false) String vinNumber,
		 * 
		 * @RequestParam(value = "ifRetrofitting", required = false) Integer
		 * ifRetrofitting,
		 * 
		 * @RequestParam(value = "addAccessorizeNote", required = false) String
		 * addAccessorizeNote
		 */
		Integer dealerOrderId = Integer.parseInt(request.getParameter("dealerOrderId"));
		Integer dealerOrderDetailsId = Integer.parseInt(request.getParameter("dealerOrderDetailsId"));
		String sellPrice = (String) request.getParameter("sellPrice");
		String vinNumber = (String) request.getParameter("vinNumber");
		Integer ifRetrofitting = Integer.parseInt(request.getParameter("ifRetrofitting"));

		String addAccessorizeNote = (String) request.getParameter("addAccessorizeNote");

		if (ifRetrofitting == 0) {
			addAccessorizeNote = "无";
		}

		int a = 0;
		int b = 0;
		int c = 0;
		Double sellPrice1 = Double.parseDouble(sellPrice);
		a = service.addAccounting(sellPrice1, ifRetrofitting, addAccessorizeNote, vinNumber);
		if (a > 0) {
			b = service.addStartAccounting1(vinNumber, dealerOrderId);
		}
		if (b > 0) {
			c = service.updateDealerOrder(dealerOrderDetailsId);
		}
		System.out.println(a + ":" + b + ":" + c);

		return String.valueOf(12);

	}

}
