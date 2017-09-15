package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Logistics;
import com.scm.service.LogisticsService;

@Controller
public class ScmLogisticsController {

	@Resource(name = "logisticsService")
	private LogisticsService logisticsService;

	@RequestMapping("logistics")
	public ModelAndView list() {
		List<Logistics> logisticsList = logisticsService.findAll();
		ModelAndView mv = new ModelAndView("baseManager/logistics");
		mv.addObject("logisticsList", logisticsList);
		return mv;
	}

	@RequestMapping("logisticsCreate")
	public ModelAndView edit(@RequestParam(value = "logisticsId", required = false) Integer logisticsId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/logisticsCreate");
		if (logisticsId == null) {
			return mv;
		} else {
			Logistics logistics = logisticsService.findById(logisticsId);
			mv.addObject("logistics", logistics);
			return mv;
		}
	}

	@RequestMapping("logisticsEdit")
	public String addOrUpdate(Logistics scmLogistics) {
		if (scmLogistics.getLogisticsId() != null && scmLogistics != null) {
			logisticsService.update(scmLogistics);
		} else {
			logisticsService.add(scmLogistics);
		}
		return "redirect:logistics";
	}
}
