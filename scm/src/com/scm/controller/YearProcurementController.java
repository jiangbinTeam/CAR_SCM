package com.scm.controller;
/*
 * 表示层
 * 全年采购计划 处理器/控制器
 */

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

import com.scm.pojo.YearProcurement;
import com.scm.pojo.YearProcurementPlan;
import com.scm.service.YearProcurementService;

import net.sf.json.JSONArray;

@Controller
public class YearProcurementController {

	@Resource(name = "yearProcurementService")
	private YearProcurementService yearProcurementService;

/*	@Resource(name = "typeDicService")
	private TypeDicService typeDicService;*/

	// 获取当前系统时间
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	Integer yppy = Integer.parseInt(sdf.format(date));

	// 列出全年采购计划
	// 使用@RequestMapping 来映射URL 到控制器类，或者是到Controller 控制器的处理方法上
/*	@RequestMapping("yearProcurementPlan")
	public ModelAndView findAll() {
		List<YearProcurement> ypp = yearProcurementService.findAll();
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("procurementManager/developmentProcurementPlan"); // 逻辑视图名 (jsp名)
		mv.addObject("ypp", ypp); // 模型数据
		
		return mv;
	}*/

	// 判断本年是否还有未做采购计划的车型
	@RequestMapping("yearProcurementPlanafind")
	public ModelAndView find() {

		List<YearProcurement> ypp = yearProcurementService.find();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/developmentProcurementPlanCreate"); // 逻辑视图名 (jsp名)

		mv.addObject("ypp", ypp); // 模型数据
		mv.addObject("yppy", yppy); // 模型数据

		return mv;
	}

	// 创建全年采购计划
	@RequestMapping("yearProcurementPlanCreate")
	public String Add(@RequestParam(value = "typeCode", required = true) String typeCode,
			@RequestParam(value = "yearProcurementPlanYear", required = true) Integer yearProcurementPlanYear,
			@RequestParam(value = "yearProcurementPlanCount", required = true) Integer yearProcurementPlanCount
			/*@RequestParam(value = "ifDecomposition", required = true) Integer ifDecomposition*/) {

		YearProcurementPlan ypp = new YearProcurementPlan();

		ypp.setTypeCode(typeCode);
		ypp.setYearProcurementPlanYear(yearProcurementPlanYear);
		ypp.setYearProcurementPlanCount(yearProcurementPlanCount);
		ypp.setIfDecomposition(0);

		yearProcurementService.add(ypp);

		return "redirect:yearProcurementPlanPage"; // redirect重定向
	}

	// 通过年份查全年采购计划
/*	@RequestMapping("yearProcurementPlanafindYear")
	public ModelAndView findYear() {

		List<YearProcurement> ypp = yearProcurementService.findYear(yppy);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/developmentProcurementPlan"); // 逻辑视图名 (jsp名)
		mv.addObject("ypp", ypp); // 模型数据

		return mv;
	}*/

	// 按id查全年采购计划
	@RequestMapping("yearProcurementPlanafindId")
	public ModelAndView findById(
			@RequestParam(value = "yearProcurementPlanId", required = false) Integer yearProcurementPlanId) {
		YearProcurement ypp = yearProcurementService.findById(yearProcurementPlanId);
		ModelAndView mv = new ModelAndView();

		mv.setViewName("procurementManager/developmentProcurementPlanUpdate"); // 逻辑视图名 (jsp名)
		mv.addObject("ypp", ypp); // 模型数据

		return mv;

	}

	// 修改全年采购计划
	@RequestMapping("yearProcurementPlanUpdate")
	public String Update(@RequestParam(value = "yearProcurementPlanId", required = true) Integer yearProcurementPlanId,
			@RequestParam(value = "yearProcurementPlanCount", required = true) Integer yearProcurementPlanCount) {

		YearProcurementPlan ypp = new YearProcurementPlan();

		ypp.setYearProcurementPlanId(yearProcurementPlanId);
		ypp.setYearProcurementPlanCount(yearProcurementPlanCount);


		yearProcurementService.update(ypp);

		return "redirect:yearProcurementPlanPage"; // redirect重定向
	}

	// 分页查询
	@RequestMapping("yearProcurementPlanPage")
	public ModelAndView findByPage(@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "yearProcurementPlanYear", required = false) Integer yearProcurementPlanYear) {
		List<YearProcurement> list = new ArrayList<YearProcurement>();

		if (yearProcurementPlanYear == null) { // 判断查询年份值是否为空 如果为空用当前年份查询
			yearProcurementPlanYear = yppy;
		}
		
		int pageSize = 15;
		int count = yearProcurementService.countPage(yearProcurementPlanYear); // 计算总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize); // 计算总页数
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

		list = yearProcurementService.findByPage(pageMin, pageMax, yearProcurementPlanYear);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/developmentProcurementPlan");
		mv.addObject("list", list);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);

		return mv;
	}

	// 按年份分页查询
	@RequestMapping("yearProcurementPlanSelect")
	public ModelAndView findBySelect(@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "yearProcurementPlanYear", required = false) Integer yearProcurementPlanYear) {
		
		List<YearProcurement> list = new ArrayList<YearProcurement>();
		if (yearProcurementPlanYear == null) { // 判断查询年份值是否为空 如果为空用当前年份查询
			yearProcurementPlanYear = yppy;
		}
		
		int pageSize = 15;
		int count = yearProcurementService.countPage(yearProcurementPlanYear);
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

		list = yearProcurementService.findByPage(pageMin, pageMax, yearProcurementPlanYear);
		
		List<YearProcurement> years = yearProcurementService.findAll();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/developmentProcurementPlanSelect");
		mv.addObject("list", list);
		mv.addObject("yearProcurementPlanYear", yearProcurementPlanYear);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("years", years);
		
		return mv;
	}
	
	//Json查年份
	@RequestMapping(value = "selectYear", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findlist(HttpServletRequest request, HttpServletResponse response) {
		List<YearProcurement> ypp = yearProcurementService.findAll();
		
		// 转JSON 转换成JSONArray对象的形式的字符串 
		JSONArray jsonArray = JSONArray.fromObject(ypp);
	    return jsonArray.toString();
	  }
	
	//Json根据年份查车型
	@RequestMapping(value = "selectType", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findType(@RequestParam(value = "yearProcurementPlanYear", required = false) Integer yearProcurementPlanYear,
											HttpServletRequest request, HttpServletResponse response){
		List<YearProcurement> ypp = yearProcurementService.findType(yearProcurementPlanYear);
		JSONArray jsonArray = JSONArray.fromObject(ypp);
	    return jsonArray.toString();
	}

}
