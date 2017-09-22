package com.scm.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.DealerPaymentCar;
import com.scm.pojo.DealerPaymentCarInfo;
import com.scm.service.DPaymentCarInfoService;
import com.scm.service.DPaymentCarService;
import com.scm.util.ImportExcleUtil;

@Controller
public class DPaymentCarController {

	@Resource(name = "dPaymentCarService")
	private DPaymentCarService dPaymentCarService;

	@Resource(name = "dPaymentCarInfoService")
	private DPaymentCarInfoService infoService;

	// 首页分页
	@RequestMapping("dealerPaymentCar")
	public ModelAndView list() {
		int currPage = 1;
		int pageSize = 10;// 页大小
		int ct = dPaymentCarService.total();// 总记录数
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);// 总页数

		List<String> vinNumbers = dPaymentCarService.findAllVinNumber(1, pageSize);

		List<DealerPaymentCarInfo> dPcars = new ArrayList<DealerPaymentCarInfo>();

		if (vinNumbers.size() != 0) {
			for (String s : vinNumbers) {
				DealerPaymentCarInfo carInfo = infoService.findByViNumber(s);
				dPcars.add(carInfo);
			}
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/dealerPaymentCar");
		mv.addObject("dPcars", dPcars);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;

	}

	// 分页
	@RequestMapping("dPCarByPage")
	public ModelAndView dPCarByPage(@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageSize = 10;// 页大小
		int ct = dPaymentCarService.total();// 总记录数
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);// 总页数

		List<String> vinNumbers = null;
		List<DealerPaymentCarInfo> dPcars = new ArrayList<DealerPaymentCarInfo>();// 当前页面数据

		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			vinNumbers = dPaymentCarService.findAllVinNumber(pageMin, pageMax);

			if (vinNumbers.size() != 0) {
				for (String s : vinNumbers) {
					DealerPaymentCarInfo carInfo = infoService.findByViNumber(s);
					dPcars.add(carInfo);
				}
			}

		} else if (currPage > pageAll) {// 当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;

			vinNumbers = dPaymentCarService.findAllVinNumber(pageMin, pageMax);
			if (vinNumbers.size() != 0) {
				for (String s : vinNumbers) {
					DealerPaymentCarInfo carInfo = infoService.findByViNumber(s);
					dPcars.add(carInfo);
				}
			}
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			vinNumbers = dPaymentCarService.findAllVinNumber(pageMin, pageMax);
			if (vinNumbers.size() != 0) {
				for (String s : vinNumbers) {
					DealerPaymentCarInfo carInfo = infoService.findByViNumber(s);
					dPcars.add(carInfo);
				}
			}
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/dealerPaymentCar");
		mv.addObject("dPcars", dPcars);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}
	
	//支付车款
	@RequestMapping("payDealerPaymentCar")
	public String payDealerPaymentCar(String vinNumber) {
		dPaymentCarService.payMoney(vinNumber);
		return "redirect:dealerPaymentCar";//重新加载首页数据
	}

	//导入Excel表格数据
	@RequestMapping(value = "uploadExcel", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView uploadExcel(HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		InputStream in = null;
		List<List<Object>> listob = null;
		MultipartFile file = multipartRequest.getFile("upfile");

		if (file.isEmpty()) {
			throw new Exception("文件不存在！");
		}

		in = file.getInputStream();
		listob = ImportExcleUtil.getBankListByExcel(in, file.getOriginalFilename());

		List<String> errorVin = new ArrayList<String>();
		List<DealerPaymentCarInfo> errors = new ArrayList<DealerPaymentCarInfo>();

		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		for (int i = 0; i < listob.size(); i++) {

			List<Object> lo = listob.get(i);
			String vinNumber = String.valueOf(lo.get(2));

			if (dPaymentCarService.findByVinNumber(vinNumber) == null) {

				DealerPaymentCar dealerPaymentCar = new DealerPaymentCar();
				Double money = Double.parseDouble((String) lo.get(3));

				dealerPaymentCar.setVinNumber(String.valueOf(lo.get(2)));
				dealerPaymentCar.setDealerPaymentCarCount(money);
				dealerPaymentCar.setIfCarriageCharge(0);
				dPaymentCarService.add(dealerPaymentCar);
			} else {

				errorVin.add(vinNumber);
			}
		}

		if (errorVin.size() != 0) {
			for (String s : errorVin) {
				DealerPaymentCarInfo carInfo = infoService.findByViNumber(s);
				carInfo.setInfo("该汽车的付款单已存在！");
				errors.add(carInfo);
			}
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("finance/dealerPaymentCarCreate");
		mv.addObject("errors", errors);

		return mv;

	}
}
