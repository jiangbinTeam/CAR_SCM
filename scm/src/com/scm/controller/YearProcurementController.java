package com.scm.controller;
/*
 * 表示层
 * 全年采购计划 处理器/控制器
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.TypeDictionary;
import com.scm.pojo.YearProcurementPlan;
import com.scm.service.TypeDicService;
import com.scm.service.YearProcurementService;

@Controller
public class YearProcurementController {

	@Resource(name = "yearProcurementService")
	private YearProcurementService yearProcurementService;
	
	@Resource(name = "typeDicService")
	private TypeDicService typeDicService;
	
	//列出全年采购计划
	//使用@RequestMapping 来映射URL 到控制器类，或者是到Controller 控制器的处理方法上
	@RequestMapping("yearProcurementPlan")
	public ModelAndView findAll(){
		List<YearProcurementPlan> ypp = yearProcurementService.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/developmentProcurementPlan"); // 逻辑视图名 (jsp名)
		mv.addObject("ypp", ypp); // 模型数据
		return mv;
	}
	
	//创建全年采购计划
	@RequestMapping("yearProcurementPlanCreate")
	//使用 @RequestParam 绑定 HttpServletRequest 请求参数到控制器方法参数
	public ModelAndView Add(@RequestParam(value = "yearProcurementPlanId",required=false) Integer yearProcurementPlanId){
		ModelAndView mv = new ModelAndView();
		List<TypeDictionary> typeDictionaries = typeDicService.list();
		
		mv.addObject("typeDictionaries", typeDictionaries);
		mv.setViewName("procurementManager/developmentProcurementPlanCreate");
		if (yearProcurementPlanId == null) {
			return mv;
		}else {
			YearProcurementPlan yearProcurementPlan = yearProcurementService.findById(yearProcurementPlanId);
			mv.addObject("yearProcurementPlan", yearProcurementPlan);
			return mv;
		}
	}
	
}
