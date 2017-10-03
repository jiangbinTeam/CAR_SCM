package com.scm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Dealer;
import com.scm.pojo.DealerList;
import com.scm.pojo.SelectSell;
import com.scm.pojo.YearPlanDealerAnalyze;
import com.scm.pojo.Ypmas;
import com.scm.pojo.YearPlanMonthAnalyze;
import com.scm.pojo.YearSellPlan;

import com.scm.service.YearSellPlanService;

import net.sf.json.JSONArray;
import oracle.net.aso.b;


@Controller
public class YearSellPlanController {

	@Resource(name = "yearSellPlanService")
	private YearSellPlanService yearSellPlanService;

	@RequestMapping("yearSellPlan_list")
	public ModelAndView list() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Integer yearProcurementPlanYear = Integer.parseInt(sdf.format(date));

		List<SelectSell> list = yearSellPlanService.list();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanCreate");
		mv.addObject("yearSellPlanList", list);
		mv.addObject("year", yearProcurementPlanYear);
		return mv;
	}

	@RequestMapping("yearSellPlan_add")
	public String add(@RequestParam(value = "typeCode", required = true) String typeCode,
			@RequestParam(value = "year", required = true) Integer year,
			@RequestParam(value = "sellcount", required = false) Integer sellcount) {
		YearSellPlan yearSellPlan = new YearSellPlan();

		if (sellcount == null) {
			return "redirect:yearSellPlan_page";
		}
		yearSellPlan.setSellcount(sellcount);
		yearSellPlan.setYear(year);
		yearSellPlan.setTypeCode(typeCode);
		yearSellPlanService.add(yearSellPlan);

		return "redirect:yearSellPlan_page";
	}

	@RequestMapping("yearSellPlan_page")
	public ModelAndView findByPage(@RequestParam(value = "currPage", required = false) Integer currPage) {
		List<SelectSell> list = new ArrayList<SelectSell>();
		int pageSize = 12;
		int count = yearSellPlanService.countPageSell();
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
		if (currPage != null) {
			if (currPage < 1) {
				currPage = 1;
			}
			if (currPage > pageAll) {
				currPage = pageAll;
			}
		}
		if (currPage == null) {
			currPage = 1;
		}
		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;
		list = yearSellPlanService.findByPage(pageMin, pageMax);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlan");
		mv.addObject("list", list);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	@RequestMapping("yearSellPlan_findId")
	public ModelAndView findByid(@RequestParam("yearSellPlanId") Integer yearSellPlanId) {

		SelectSell selectSell = yearSellPlanService.findByID(yearSellPlanId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanID");
		mv.addObject("selectSell", selectSell);
		return mv;
	}

	@RequestMapping("yearSellPlan_update")
	public String update(@RequestParam("yearSellPlanId") Integer yearSellPlanId,
			@RequestParam("sellcount") Integer sellcount) {
		YearSellPlan yearSellPlan = new YearSellPlan();
		yearSellPlan.setSellcount(sellcount);
		yearSellPlan.setYearSellPlanId(yearSellPlanId);
		yearSellPlanService.updateSell(yearSellPlan);

		return "redirect:yearSellPlan_page";
	}

	@RequestMapping("yearSellPlan_findId2")
	public ModelAndView findByID(@RequestParam("yearSellPlanId") Integer yearSellPlanId) {

		SelectSell selectSell = yearSellPlanService.findByID(yearSellPlanId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanDecompositionByMouth");
		mv.addObject("selectSell", selectSell);
		return mv;
	}

	@RequestMapping("yearSellPlan_addMonth")
	public String add(Ypmas ypmas) {
		int a = 0;
		for (YearPlanMonthAnalyze y : ypmas.getYpmas()) {
			a = yearSellPlanService.addMonth(y);
			if (a > 0) {
				yearSellPlanService.updateDec(y.getYearSellPlanId());
				a = 0;
			}
		}
		return "redirect:yearSellPlan_page";
	}

	@RequestMapping("yearSellPlan_findMonth")
	public ModelAndView findMonth(Integer yearSellPlanId) {
		List<SelectSell> list = yearSellPlanService.findByMonth(yearSellPlanId);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanSelectByMouth");
		mv.addObject("list", list);
		System.out.println(list.size());
		return mv;
	}
	@RequestMapping("yearSellPlan_findAllMonth")
	public ModelAndView findAllMouth(@RequestParam(value = "currPage", required = false) Integer currPage ,
									 @RequestParam(value = "typeCode", required = false) String typeCode,
									 @RequestParam(value = "year", required = false) Integer year) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Integer PlanYear = Integer.parseInt(sdf.format(date));
		if(year==null){
			year=PlanYear;
		}
		if(typeCode==null){
			typeCode="byd2017V";
		}
		List<SelectSell> list = new ArrayList<SelectSell>();
		int pageSize = 12;
		int count = yearSellPlanService.countPageDealer(year,typeCode);
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
		if (currPage != null) {
			if (currPage < 1) {
				currPage = 1;
			}
			if (currPage > pageAll) {
				currPage = pageAll;
			}
		}
		if (currPage == null) {
			currPage = 1;
		}
		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;
		list = yearSellPlanService.findAllMonth(pageMin, pageMax,year,typeCode);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanSelectByMouth");
		mv.addObject("list", list);
		mv.addObject("currPage", currPage);
		mv.addObject("year",year);
		mv.addObject("typeCode",typeCode);
		mv.addObject("totalPage", pageAll);
		return mv;
	}
	
	@RequestMapping("yearSellPlan_findAlDea")
	public ModelAndView findAllDea(@RequestParam(value = "currPage", required = false) Integer currPage) {
		List<SelectSell> list = new ArrayList<SelectSell>();
		int pageSize = 12;
		int count = yearSellPlanService.countPageDea();
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
		if (currPage != null) {
			if (currPage < 1) {
				currPage = 1;
			}
			if (currPage > pageAll) {
				currPage = pageAll;
			}
		}
		if (currPage == null) {
			currPage = 1;
		}
		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;
		list = yearSellPlanService.findAllDea(pageMin, pageMax);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanSelectByDealer");
		mv.addObject("list", list);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}
	
	@RequestMapping("yearSellPlan_findAlDea2")
	public ModelAndView findAllDea2(@RequestParam(value = "currPage", required = false) Integer currPage,
									@RequestParam(value = "principalName", required = false) String principalName) {	
		
		
		List<SelectSell> list = new ArrayList<SelectSell>();
		int pageSize = 12;
		int count = yearSellPlanService.countPageDea2(principalName);
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
		if (currPage != null) {
			if (currPage < 1) {
				currPage = 1;
			}
			if (currPage > pageAll) {
				currPage = pageAll;
			}
		}
		if (currPage == null) {
			currPage = 1;
		}
		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;
		list = yearSellPlanService.findAllDea2(pageMin, pageMax,principalName);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanSelectByDealer");
		mv.addObject("list", list);
		mv.addObject("currPage", currPage);
		mv.addObject("principalName",principalName);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	@RequestMapping("yearSellPlan_findMonthID")
	public ModelAndView findMonthID(Integer yearPlanMonthAnalyzeId) {
		SelectSell selectSell = yearSellPlanService.findByMonthID(yearPlanMonthAnalyzeId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanDecompositionByMouth2");
		mv.addObject("selectSell", selectSell);
		return mv;
	}

	@RequestMapping("yearSellPlan_updateMonth")
	public String updateMonth(YearPlanMonthAnalyze yearPlanMonthAnalyze, Integer yearSellPlanId) {
		yearSellPlanService.updateMonth(yearPlanMonthAnalyze);

		return "redirect:yearSellPlan_findMonth?yearSellPlanId=" + yearSellPlanId;
	}

	@RequestMapping("yearSellPlan_Dealer")
	public ModelAndView findDealer(Integer yearSellPlanId, Integer yearPlanMouth) {
		SelectSell selectSell = new SelectSell();
		List<Dealer> list = yearSellPlanService.listDealer();
		List<SelectSell> list2 = yearSellPlanService.findByMonth(yearSellPlanId);
		for (SelectSell l : list2) {
			if (l.getYearPlanMouth() == yearPlanMouth) {
				selectSell = l;
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/sellPlanDecompositionByDealer");
		mv.addObject("selectSell", selectSell);
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("yearSellPlan_addDealer")
	public String addDerlea(DealerList dealers) {
		int a = 0;
		int yearSellPlanId = 0;
		for (YearPlanDealerAnalyze d : dealers.getDealers()) {
			a = yearSellPlanService.addDealer(d);
			if (a > 0) {
				yearSellPlanService.updateifDec(d.getYearPlanMonthAnalyzeId());
				yearSellPlanId = yearSellPlanService.findYearId(d.getYearPlanMonthAnalyzeId());
			}
		}
		return "redirect:yearSellPlan_findMonth?yearSellPlanId=" + yearSellPlanId;
	}
	//Json查年份
		@RequestMapping(value = "selectYea", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String findlist(HttpServletRequest request, HttpServletResponse response) {
			List<SelectSell> ses = yearSellPlanService.selYearTypt();
			
			// 转JSON 转换成JSONArray对象的形式的字符串 
			JSONArray jsonArray = JSONArray.fromObject(ses);
		    return jsonArray.toString();
		  }
		
		@RequestMapping(value = "selectYea2", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String findlist2(HttpServletRequest request, HttpServletResponse response) {
			List<SelectSell> ses = yearSellPlanService.selYearTypt2();
			
			// 转JSON 转换成JSONArray对象的形式的字符串 
			JSONArray jsonArray = JSONArray.fromObject(ses);
		    return jsonArray.toString();
		  }
		
		@RequestMapping(value = "selectYea3", produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String findlist3(HttpServletRequest request, HttpServletResponse response) {
			List<Dealer> ses = yearSellPlanService.selYearTypt3();
			
			// 转JSON 转换成JSONArray对象的形式的字符串 
			JSONArray jsonArray = JSONArray.fromObject(ses);
		    return jsonArray.toString();
		  }

}
