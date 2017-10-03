package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.TypeDictionary;
import com.scm.pojo.Warehouse;
import com.scm.service.CarOutManagerService;

@Controller
public class CarOutManagerController {
	@Resource(name = "carOutManagerService")
	private CarOutManagerService carOutManagerService;

	// ��ҳ��ҳ����
	@RequestMapping("CarOutManagerlist")
	public ModelAndView list() {
		Integer currPage = 1;
		int pageSize = 10;
		int total = carOutManagerService.totalcount(null, null, null);
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);
		List<Warehouse> wars = carOutManagerService.pageList(1, pageSize, null, null, null);

		List<Warehouse> win = carOutManagerService.listid();

		List<TypeDictionary> toye = carOutManagerService.listtypeCode();

		List<Warehouse> vinu = carOutManagerService.listvinNumber();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("warehouseManager/carOutManager");
		mv.addObject("win", 0);
		mv.addObject("toye", "0");
		mv.addObject("vinu", "0");

		mv.addObject("wars", wars);
		mv.addObject("win", win);
		mv.addObject("toye", toye);
		mv.addObject("vinu", vinu);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	@RequestMapping("findBychuku")
	public ModelAndView findBychuku(@RequestParam(value = "currPage", required = true) Integer currPage,
			@RequestParam(value = "warehouseId", required = false) Integer warehouseId,
			@RequestParam(value = "typeCode", required = false) String typeCode,
			@RequestParam(value = "vinNumber", required = false) String vinNumber) {

		if (typeCode.equals("0") || typeCode.equals("")) {
			typeCode = null;
		}

		if (vinNumber.equals("0") || vinNumber.equals("")) {
			vinNumber = null;
		}

		int pageSize = 10;// ҳ��С
		int count = carOutManagerService.totalcount(warehouseId, typeCode, vinNumber);// �ܼ�¼��
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
		List<Warehouse> wars = null;

		List<Warehouse> win = carOutManagerService.listid();// �ֿ�

		List<TypeDictionary> toye = carOutManagerService.listtypeCode();// ����

		List<Warehouse> vinu = carOutManagerService.listvinNumber();// vin

		if (currPage < 1) {
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			wars = carOutManagerService.pageList(pageMin, pageMax, warehouseId, typeCode, vinNumber);
		} else if (currPage > pageAll) {
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			wars = carOutManagerService.pageList(pageMin, pageMax, warehouseId, typeCode, vinNumber);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			wars = carOutManagerService.pageList(pageMin, pageMax, warehouseId, typeCode, vinNumber);
		}

		if (typeCode == null || typeCode.equals("")) {
			typeCode = "0";
		}
		if (vinNumber == null || vinNumber.equals("")) {
			vinNumber = "0";
		}
		if (warehouseId == null) {
			warehouseId = 0;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("warehouseManager/carOutManager");
		mv.addObject("warehouseId", warehouseId);
		mv.addObject("typeCode", typeCode);
		mv.addObject("vinNumber", vinNumber);

		mv.addObject("win", win);
		mv.addObject("toye", toye);
		mv.addObject("vinu", vinu);
		mv.addObject("wars", wars);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// ��������
	@RequestMapping("findBychukuku")
	public String save1(Integer storageAreasId) {
		if (storageAreasId != null) {
			carOutManagerService.findBychukua(storageAreasId);
		}
		return "redirect:CarOutManagerlist";

	}

}
