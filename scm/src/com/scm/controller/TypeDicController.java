package com.scm.controller;

import java.util.ArrayList;
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

	@RequestMapping("tdyPage")
	public ModelAndView tdyPage() {
		Integer pageMin = 1;
		Integer pageMax = 2;
		int ct = typeDicService.countTdy();
		int pageAll = (int) Math.ceil(ct * 1.0 / 2);
		List<TypeDictionary> tdys = typeDicService.findByPageTdy(pageMin, pageMax);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/typeDictionary");
		mv.addObject("tdys", tdys);
		mv.addObject("currPage", pageMin);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	@RequestMapping("fyTdy")
	public ModelAndView fyTdy(@RequestParam(value = "currPage", required = false) Integer currPage) {
		List<TypeDictionary> tdys = new ArrayList<TypeDictionary>();
		int pageSize = 2;
		int count = typeDicService.countTdy();
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
		// System.out.println("一共"+pageAll+"页");
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > pageAll) {
			currPage = pageAll;
		}
		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;
		tdys = typeDicService.findByPageTdy(pageMin, pageMax);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/typeDictionary");
		mv.addObject("tdys", tdys);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}
}
