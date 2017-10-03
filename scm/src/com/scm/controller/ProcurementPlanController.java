package com.scm.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Ppa;
import com.scm.pojo.ProcurementPlanAnalyze;
import com.scm.pojo.TypeDictionary;
import com.scm.pojo.YearProcurement;
import com.scm.service.ProcurementPlanService;
import com.scm.service.TypeDicService;
import com.scm.service.YearProcurementService;

@Controller
public class ProcurementPlanController {

	@Resource(name = "procurementPlanService")
	private ProcurementPlanService procurementPlanService;

	@Resource(name = "yearProcurementService")
	private YearProcurementService yearProcurementService;

	@Resource(name = "typeDicService")
	private TypeDicService typeDicService;

	// 获取当前系统时间
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	Integer yppy = Integer.parseInt(sdf.format(date));

	// 通过年份ID查全年采购计划
	@RequestMapping("procurementPlanYear")
	public ModelAndView findById(
			@RequestParam(value = "yearProcurementPlanId", required = false) Integer yearProcurementPlanId) {

		YearProcurement ypp = procurementPlanService.findById(yearProcurementPlanId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanCreate"); // 逻辑视图名(jsp名)
		mv.addObject("ypp", ypp); // 模型数据

		return mv;
	}

	@RequestMapping("procurementPlanPage")
	public ModelAndView list() {
		int currPage = 1;
		int pageSize = 12;// 页大小

		int count = procurementPlanService.total(yppy, null);// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		List<YearProcurement> yp = procurementPlanService.findAll(1, pageSize, yppy, null);
	

		List<YearProcurement> years = yearProcurementService.findAll();
		List<TypeDictionary> typeDictionarys = typeDicService.list();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("years", years);
		mv.addObject("typeDictionarys", typeDictionarys);
		mv.addObject("yearProcurementPlanYear", yppy);
		mv.addObject("yp", yp);

		return mv;

	}

	@RequestMapping("procurementPlanSelect")
	public ModelAndView findList(
			@RequestParam(value = "yearProcurementPlanYear", required = false) Integer yearProcurementPlanYear,
			@RequestParam(value = "typeCode", required = false) String typeCode) {

		yearProcurementPlanYear = yearProcurementPlanYear == 0 ? null : yearProcurementPlanYear;
	
		typeCode = typeCode.equals("0") ? null : typeCode;
	
		int currPage = 1;
		int pageSize = 12;// 页大小

		int count = procurementPlanService.total(yearProcurementPlanYear, typeCode);// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数

		List<YearProcurement> yp = procurementPlanService.findAll(1, pageSize, yearProcurementPlanYear, typeCode);

		List<YearProcurement> years = yearProcurementService.findAll();
		List<TypeDictionary> typeDictionarys = typeDicService.list();


		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("years", years);
		mv.addObject("typeDictionarys", typeDictionarys);
		mv.addObject("typeCode", typeCode);
		mv.addObject("yearProcurementPlanYear", yearProcurementPlanYear);
		mv.addObject("yp", yp);

		return mv;

	}

	@RequestMapping("findProcurementPlanBypage")
	public ModelAndView findBypage(@RequestParam(value = "currPage", required = true) Integer currPage,
			@RequestParam(value = "yearProcurementPlanYear", required = false) Integer yearProcurementPlanYear,
			@RequestParam(value = "typeCode", required = false) String typeCode) {
		int pageSize = 12;// 页大小
		int count = procurementPlanService.total(yearProcurementPlanYear, typeCode);// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数

		List<YearProcurement> yp = null;
		List<YearProcurement> years = yearProcurementService.findAll();
		List<TypeDictionary> typeDictionarys = typeDicService.list();

		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			yp = procurementPlanService.findAll(pageMin, pageMax, yearProcurementPlanYear, typeCode);
		} else if (currPage > pageAll) {// 当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			yp = procurementPlanService.findAll(pageMin, pageMax, yearProcurementPlanYear, typeCode);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			yp = procurementPlanService.findAll(pageMin, pageMax, yearProcurementPlanYear, typeCode);
		}

		ModelAndView mv = new ModelAndView();

		mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("yearProcurementPlanYear", yearProcurementPlanYear);
		mv.addObject("typeCode", typeCode);
		mv.addObject("yp", yp);
		mv.addObject("years", years);
		mv.addObject("typeDictionarys", typeDictionarys);
		return mv;
	}

	// 按年份、id查看分解计划
	/* @RequestMapping("procurementPlanSelect") */
	public ModelAndView findByYear(
			@RequestParam(value = "yearProcurementPlanYear", required = true) Integer yearProcurementPlanYear,
			@RequestParam(value = "yearProcurementPlanId", required = false) Integer yearProcurementPlanId) {
		if (yearProcurementPlanId != null) {
			List<YearProcurement> yp = procurementPlanService.findByYear(yearProcurementPlanYear,
					yearProcurementPlanId);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
			mv.addObject("list", yp);
			return mv;
		} else {
			List<YearProcurement> yp = procurementPlanService.find(yearProcurementPlanYear);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
			mv.addObject("list", yp);
			return mv;
		}
	}

	// 按年份查看分解计划
	@RequestMapping("procurementPlanYearSelect")
	public ModelAndView find() {
		List<YearProcurement> yp = procurementPlanService.find(yppy);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
		mv.addObject("yp", yp);
		return mv;
	}

	// 创建全年分解采购计划
	@RequestMapping("procurementPlanAdd")
	public String add(Ppa ppa) {
		int a = 0;
		for (ProcurementPlanAnalyze y : ppa.getPpa()) {
			a = procurementPlanService.add(y);
			if (a > 0) {
				procurementPlanService.update(y.getYearProcurementPlanId());
				a = 0;
			}
		}
		return "redirect:yearProcurementPlanPage";
	}

	// 通过年份ID查全年采购计划修改页面
	@RequestMapping("procurementPlanupdates")
	public ModelAndView findByYearupdate(
			@RequestParam(value = "yearProcurementPlanYear", required = true) Integer yearProcurementPlanYear,
			@RequestParam(value = "yearProcurementPlanId", required = true) Integer yearProcurementPlanId) {
		List<YearProcurement> yp = procurementPlanService.findByYear(yearProcurementPlanYear, yearProcurementPlanId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanUpdate");
		mv.addObject("yp", yp);
		return mv;
	}

	// 修改全年分解采购计划
	@RequestMapping("procurementPlanupdate")
	public String updates(Ppa ppa) {
		for (ProcurementPlanAnalyze p : ppa.getPpa()) {
			procurementPlanService.updates(p);
		}
		return "redirect:procurementPlanPage"; // redirect重定向

	}

	// 分页查询
	/* @RequestMapping("procurementPlanPage") */
	public ModelAndView findByPage(@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "yearProcurementPlanYear", required = false) Integer yearProcurementPlanYear) {
		List<YearProcurement> list = new ArrayList<YearProcurement>();

		if (yearProcurementPlanYear == null) { // 判断查询年份值是否为空 如果为空用当前年份查询
			yearProcurementPlanYear = yppy;
		}

		int pageSize = 12;
		int count = procurementPlanService.countPage();
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

		list = procurementPlanService.findByPage(pageMin, pageMax, yearProcurementPlanYear);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
		mv.addObject("list", list);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);

		return mv;
	}

}
