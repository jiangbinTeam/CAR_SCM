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

	@RequestMapping("colorChange")
	public ModelAndView list() {
		List<ColorChange> colorChanges = colorChangeService.list();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("baseManager/colorChange");
		mv.addObject("colorChanges", colorChanges);
		return mv;
	}

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

		if (scmColorChange.getColorCode() != null && scmColorChange != null) {
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

}
