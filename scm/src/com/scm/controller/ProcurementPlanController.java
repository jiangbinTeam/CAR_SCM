package com.scm.controller;

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
import com.scm.pojo.YearProcurement;
import com.scm.service.ProcurementPlanService;

@Controller
public class ProcurementPlanController {

	@Resource(name = "procurementPlanService")
	private ProcurementPlanService procurementPlanService;
	
	// 获取当前系统时间
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	Integer yppy = Integer.parseInt(sdf.format(date));

	// 通过年份ID查全年采购计划
	@RequestMapping("procurementPlanYear")
	public ModelAndView findById(@RequestParam(value = "yearProcurementPlanId", required = false) Integer yearProcurementPlanId) {

		YearProcurement ypp = procurementPlanService.findById(yearProcurementPlanId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanCreate"); // 逻辑视图名(jsp名)
		mv.addObject("ypp", ypp); // 模型数据

		return mv;
	}
	
	//按年份、id查看分解计划
	@RequestMapping("procurementPlanSelect")
	public ModelAndView findByYear(@RequestParam(value = "yearProcurementPlanYear", required = true) Integer yearProcurementPlanYear,
															  @RequestParam(value = "yearProcurementPlanId", required = true) Integer yearProcurementPlanId){
		List<YearProcurement> yp = procurementPlanService.findByYear(yearProcurementPlanYear, yearProcurementPlanId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
		mv.addObject("list", yp);
		return mv;
	}
	
	//按年份查看分解计划
		@RequestMapping("procurementPlanYearSelect")
		public ModelAndView find(){
			List<YearProcurement> yp = procurementPlanService.find(yppy);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("procurementManager/decompositionProcurementPlanSelect");
			mv.addObject("yp", yp);
			return mv;
		}
	
	//创建全年分解采购计划
	@RequestMapping("procurementPlanAdd")
	public String add(Ppa ppa){
		int a =0;
		for(ProcurementPlanAnalyze y:ppa.getPpa()){			
			a=procurementPlanService.add(y);	
			if(a>0){
				procurementPlanService.update(y.getYearProcurementPlanId());
				a=0;
			}
		}	
		return "redirect:yearProcurementPlanPage";
	}
	
	//通过年份ID查全年采购计划修改页面
	@RequestMapping("procurementPlanupdates")
	public ModelAndView findByYearupdate(@RequestParam(value = "yearProcurementPlanYear", required = true) Integer yearProcurementPlanYear,
															  @RequestParam(value = "yearProcurementPlanId", required = true) Integer yearProcurementPlanId){
		List<YearProcurement> yp = procurementPlanService.findByYear(yearProcurementPlanYear, yearProcurementPlanId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/decompositionProcurementPlanUpdate");
		mv.addObject("yp", yp);
		return mv;
	}
	
	//修改全年分解采购计划
	@RequestMapping("procurementPlanupdate")
	public String updates(Ppa ppa){
		for(ProcurementPlanAnalyze p:ppa.getPpa()){			
			procurementPlanService.updates(p);
		}	
		return "redirect:procurementPlanPage"; // redirect重定向

	}
	
	
	// 分页查询
		@RequestMapping("procurementPlanPage")
		public ModelAndView findByPage(@RequestParam(value = "currPage", required = false) Integer currPage,
				@RequestParam(value = "yearProcurementPlanYear", required = false) Integer yearProcurementPlanYear) {
			List<YearProcurement> list = new ArrayList<YearProcurement>();

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
			if (yearProcurementPlanYear == null) { // 判断查询年份值是否为空 如果为空用当前年份查询
				yearProcurementPlanYear = yppy;
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
