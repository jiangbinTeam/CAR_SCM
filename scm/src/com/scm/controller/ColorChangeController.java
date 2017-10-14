package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.ColorChange;
import com.scm.pojo.Logistics;
import com.scm.pojo.TypeDictionary;
import com.scm.service.ColorChangeService;
import com.scm.service.TypeDicService;

import net.sf.json.JSONArray;

@Controller
public class ColorChangeController {

	@Resource(name = "colorChangeService")
	private ColorChangeService colorChangeService;

	@Resource(name = "typeDicService")
	private TypeDicService typeDicService;

	/*
	 * @RequestMapping("colorChange") public ModelAndView list() { //获取所有的颜色信息
	 * List<ColorChange> colorChanges = colorChangeService.list(); //获取所有的车型信息
	 * List<TypeDictionary> typeDictionarys = typeDicService.list();
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * mv.setViewName("baseManager/colorChange");
	 * 
	 * mv.addObject("typeDictionarys", typeDictionarys);
	 * mv.addObject("colorChanges", colorChanges); return mv; }
	 */

	@RequestMapping("colorChangeCreate")
	public ModelAndView edit(@RequestParam(value = "colorCode", required = false) String colorCode) {
		ModelAndView mv = new ModelAndView();
		List<TypeDictionary> typeDictionarys = typeDicService.list();

		mv.addObject("typeDictionarys", typeDictionarys);
		mv.setViewName("baseManager/colorChangeCreate");
		if (colorCode == null) {
			return mv;
		} else {
			ColorChange scmColorChange = colorChangeService.findBycolorCode(colorCode);
			mv.addObject("scmColorChange", scmColorChange);
			return mv;
		}
	}

	@RequestMapping("colorChangeEdit")
	public String addOrUpdate(ColorChange scmColorChange) {

		String typeCode = scmColorChange.getTypeDictionary().getTypeCode();
		TypeDictionary typeDictionary = typeDicService.findByTypecode(typeCode);

		scmColorChange.setTypeDictionary(typeDictionary);

		if (colorChangeService.findBycolorCode(scmColorChange.getColorCode()) != null) {
			colorChangeService.update(scmColorChange);
		} else {
			colorChangeService.add(scmColorChange);
		}
		return "redirect:colorChange";
	}

	@RequestMapping(value = "selectType", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String listBrand(HttpServletRequest request, HttpServletResponse response) {
		List<TypeDictionary> typeDictionarys = typeDicService.list();

		JSONArray jsonArray = JSONArray.fromObject(typeDictionarys);

		return jsonArray.toString();

	}

	// 首页分页
	@RequestMapping("colorChange")
	public ModelAndView list() {

		Integer currPage = 1;
		int pageSize = 15;// 页大小
		int total = colorChangeService.count();// 总记录数
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 总页数

		List<ColorChange> colorChanges = colorChangeService.list(1, pageSize);// 首页记录
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/colorChange");
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// 点击分页
	@RequestMapping("fyCol")
	public ModelAndView fyCol(@RequestParam(value = "currPage", required = false) Integer currPage) {
		
		int pageSize = 15;// 页大小
		int count = colorChangeService.count();// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		List<ColorChange> colorChanges = null;// 当前页面数据

		
		if (currPage < 1) {//当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			colorChanges = colorChangeService.list(pageMin, pageMax);
		} else if (currPage > pageAll) {//当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			colorChanges = colorChangeService.list(pageMin, pageMax);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			colorChanges = colorChangeService.list(pageMin, pageMax);
		}
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/colorChange");
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

}
