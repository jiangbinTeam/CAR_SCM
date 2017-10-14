package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.TypeDictionary;
import com.scm.service.TypeDicService;

@Controller
public class TypeDicController {

	@Resource(name = "typeDicService")
	private TypeDicService typeDicService;

	// 列出所有的车系信息
	@RequestMapping("typeDictionary")
	public ModelAndView list() {
		List<TypeDictionary> typeDictionarys = typeDicService.list();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/typeDictionary");
		mv.addObject("typeDictionarys", typeDictionarys);
		return mv;
	}

	// 增添或者修改车系信息
	@RequestMapping("typeDictionaryCreate")
	public ModelAndView edit(@RequestParam(value = "typeCode", required = false) String typeCode) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/typeDictionaryCreate");
		if (typeCode == null) {
			return mv;
		} else {
			TypeDictionary typeDictionary = typeDicService.findByTypecode(typeCode);
			mv.addObject("typeDictionary", typeDictionary);
			return mv;
		}
	}

	@RequestMapping("typeDictionaryEdit")
	public String addOrUpdate(TypeDictionary typeDictionary) {
		TypeDictionary typeDic = typeDicService.findByTypecode(typeDictionary.getTypeCode());
		if (typeDic != null) {
			typeDicService.update(typeDictionary);
		} else {
			typeDicService.add(typeDictionary);
		}
		return "redirect:tdyPage";
	}

	// 首页分页
	@RequestMapping("tdyPage")
	public ModelAndView tdyPage() {

		int currPage = 1;
		int pageSize = 15;// 页大小
		int ct = typeDicService.countTdy();// 总记录数
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);// 总页数
		List<TypeDictionary> tdys = typeDicService.findByPageTdy(1, pageSize);// 首页记录

		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/typeDictionary");
		mv.addObject("tdys", tdys);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// 分页
	@RequestMapping("fyTdy")
	public ModelAndView fyTdy(@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageSize = 15;// 页大小
		int count = typeDicService.countTdy();// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		List<TypeDictionary> tdys = null;// 当前页面数据

		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			tdys = typeDicService.findByPageTdy(pageMin, pageMax);
		} else if (currPage > pageAll) {// 当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			tdys = typeDicService.findByPageTdy(pageMin, pageMax);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			tdys = typeDicService.findByPageTdy(pageMin, pageMax);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/typeDictionary");
		mv.addObject("tdys", tdys);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}
}
