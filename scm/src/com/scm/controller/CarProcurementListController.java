package com.scm.controller;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.CarProcurementList;
import com.scm.pojo.ColorChange;
import com.scm.pojo.DealerPaymentCar;
import com.scm.pojo.DealerPaymentCarInfo;
import com.scm.pojo.ListView;
import com.scm.pojo.TypeDictionary;
import com.scm.pojo.UploadVins;
import com.scm.pojo.Vin;
import com.scm.service.CarProcuremenListService;
import com.scm.service.ColorChangeService;
import com.scm.service.TypeDicService;
import com.scm.service.VinService;
import com.scm.util.ImportExcleUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oracle.net.aso.p;

@Controller
public class CarProcurementListController {
	@Resource(name = "carProcuremenListService")
	private CarProcuremenListService carProcuremenListService;

	@Resource(name = "typeDicService")
	private TypeDicService typeDicService;

	@Resource(name = "colorChangeService")
	private ColorChangeService colorChangeService;
	
	@Resource(name="vinService")
	private VinService vinService;

	// 首页分页
	@RequestMapping("carProcurementList")
	public ModelAndView findAll() {

		int currPage = 1;
		int pageSize = 10;// 页大小
		int ct = carProcuremenListService.total();
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);// 总页数

		List<CarProcurementList> CarProcurementLists = carProcuremenListService.listAllByPage(1, pageSize);

		List<TypeDictionary> typeDictionaries = typeDicService.list();// 获取所有的车型信息
		List<ColorChange> colorChanges = colorChangeService.listAll();// 获取所有的颜色信息

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/carProcurementListMain");
		mv.addObject("CarProcurementLists", CarProcurementLists);
		mv.addObject("typeDictionaries", typeDictionaries);
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);

		return mv;

	}

	// 点击分页
	@RequestMapping("CarProcurementListByPage")
	public ModelAndView findCpl(@RequestParam(value = "currPage", required = false) Integer currPage) {
		int pageSize = 10;// 页大小
		int count = carProcuremenListService.total();
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		List<CarProcurementList> CarProcurementLists = null;

		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			CarProcurementLists = carProcuremenListService.listAllByPage(pageMin, pageMax);

		} else if (currPage > pageAll) {
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			CarProcurementLists = carProcuremenListService.listAllByPage(pageMin, pageMax);

		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			CarProcurementLists = carProcuremenListService.listAllByPage(pageMin, pageMax);

		}
		List<TypeDictionary> typeDictionaries = typeDicService.list();// 获取所有的车型信息
		List<ColorChange> colorChanges = colorChangeService.listAll();// 获取所有的颜色信息

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/carProcurementListMain");
		mv.addObject("CarProcurementLists", CarProcurementLists);
		mv.addObject("typeDictionaries", typeDictionaries);
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);

		return mv;
	}

	// 跳转采购单新增页面
	@RequestMapping("carProcurementListAdd")
	public ModelAndView carProcurementListAdd() {
		List<TypeDictionary> typeDictionaries = typeDicService.list();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/carProcurementListAdd");
		mv.addObject("typeDictionaries", typeDictionaries);

		return mv;
	}

	// ajax获取车型对应的颜色
	@RequestMapping(value = "listColorByTCode", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String listColorByTCode(String typeCode) {
		List<ColorChange> colorChanges = colorChangeService.findByTypeCode(typeCode);

		JSONArray jsonArray = JSONArray.fromObject(colorChanges);
		return jsonArray.toString();
	}

	@RequestMapping("carProcurementListCreate")
	public String carProcurementListCreate(String carProcurementNumber, Integer carProcurementListCount,
			Double procurementPrice, String carProcurementListDate, String typeCode, String expectedPaymentDate,
			String colorCode) {

		CarProcurementList carProcurementList = new CarProcurementList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			carProcurementList.setCarProcurementAmount(carProcurementListCount * procurementPrice);

			carProcurementList.setCarProcurementNumber(carProcurementNumber);
			carProcurementList.setCarProcurementListCount(carProcurementListCount);
			carProcurementList.setProcurementPrice(procurementPrice);

			carProcurementList.setTypeCode(typeCode);
			carProcurementList.setColorCode(colorCode);
			carProcurementList.setCarProcurementListDate(sdf.parse(carProcurementListDate));
			carProcurementList.setExpectedPaymentDate(sdf.parse(expectedPaymentDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		carProcuremenListService.add(carProcurementList);

		return "redirect:carProcurementList";
	}

	// 跳转修改页面
	@RequestMapping("carProcurementListUpdate")
	public ModelAndView carProcurementListUpdate(Integer carProcurementListId) {
		CarProcurementList carProcurementList = carProcuremenListService.findById(carProcurementListId);
		List<TypeDictionary> typeDictionaries = typeDicService.list();// 获取所有的车型信息
		List<ColorChange> colorChanges = colorChangeService.findByTypeCode(carProcurementList.getTypeCode());// 获取所有的颜色信息

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String createDate = sdf.format(carProcurementList.getCarProcurementListDate());
		String payDate = sdf.format(carProcurementList.getExpectedPaymentDate());

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/carProcurementListUpdate");
		mv.addObject("carProcurementList", carProcurementList);
		mv.addObject("typeDictionaries", typeDictionaries);
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("createDate", createDate);
		mv.addObject("payDate", payDate);
		return mv;
	}

	//修改采购单信息
	@RequestMapping("carProcurementListModify")
	public String carProcurementListModify(Integer carProcurementListId, String carProcurementNumber,
			Integer carProcurementListCount, Double procurementPrice, String carProcurementListDate, String typeCode,
			String expectedPaymentDate, String colorCode) {

		CarProcurementList carProcurementList = new CarProcurementList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			carProcurementList.setCarProcurementListId(carProcurementListId);
			carProcurementList.setCarProcurementAmount(carProcurementListCount * procurementPrice);

			carProcurementList.setCarProcurementNumber(carProcurementNumber);
			carProcurementList.setCarProcurementListCount(carProcurementListCount);
			carProcurementList.setProcurementPrice(procurementPrice);

			carProcurementList.setTypeCode(typeCode);
			carProcurementList.setColorCode(colorCode);
			carProcurementList.setCarProcurementListDate(sdf.parse(carProcurementListDate));
			carProcurementList.setExpectedPaymentDate(sdf.parse(expectedPaymentDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		carProcuremenListService.modify(carProcurementList);

		return "redirect:carProcurementList";
	}
	
	//查看采购单详情  加载首页
	@RequestMapping("findVinByCPListId")
	public ModelAndView findVinByCPListId(Integer carProcurementListId) {
		
		int currPage = 1;
		int pageSize = 10;// 页大小
		int ct = vinService.total(carProcurementListId);// 总记录数
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);// 总页数
		
		List<Vin> vins=vinService.findByCarProcurementListId(1, pageSize, carProcurementListId);
		
		CarProcurementList carProcurementList = carProcuremenListService.findById(carProcurementListId);
		List<TypeDictionary> typeDictionaries = typeDicService.list();// 获取所有的车型信息
		List<ColorChange> colorChanges = colorChangeService.findByTypeCode(carProcurementList.getTypeCode());// 获取所有的颜色信息

		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/carProcurementListView");
		mv.addObject("carProcurementList", carProcurementList);
		mv.addObject("typeDictionaries", typeDictionaries);
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);

		mv.addObject("vins", vins);
		return mv;
	}
	
	//查看采购单详情  分页
	@RequestMapping("findVinByCPListIdByPage")
	public ModelAndView findVinByCPListIdByPage(Integer currPage,Integer carProcurementListId) {
		int pageSize = 10;// 页大小
		int count = typeDicService.countTdy();// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		
		List<Vin> vins=null;
		
		if (currPage < 1) {// 当前页码小于1时
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			vins = vinService.findByCarProcurementListId(pageMin, pageMax, carProcurementListId);
		} else if (currPage > pageAll) {// 当前页码大于总页数时
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			vins = vinService.findByCarProcurementListId(pageMin, pageMax, carProcurementListId);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			vins = vinService.findByCarProcurementListId(pageMin, pageMax, carProcurementListId);
		}

		
		CarProcurementList carProcurementList = carProcuremenListService.findById(carProcurementListId);
		List<TypeDictionary> typeDictionaries = typeDicService.list();// 获取所有的车型信息
		List<ColorChange> colorChanges = colorChangeService.findByTypeCode(carProcurementList.getTypeCode());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/carProcurementListView");
		mv.addObject("carProcurementList", carProcurementList);
		mv.addObject("typeDictionaries", typeDictionaries);
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.addObject("vins", vins);
		
		return mv;
	}
	
	@RequestMapping("carProcurementVinAdd")
	public ModelAndView carProcurementVinAdd(Integer carProcurementListId) {
		
		CarProcurementList carProcurementList = carProcuremenListService.findById(carProcurementListId);
		List<TypeDictionary> typeDictionaries = typeDicService.list();// 获取所有的车型信息
		List<ColorChange> colorChanges = colorChangeService.findByTypeCode(carProcurementList.getTypeCode());//获取对应车型的颜色信息
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/carProcurementVinAdd");
		mv.addObject("carProcurementList", carProcurementList);
		mv.addObject("typeDictionaries", typeDictionaries);
		mv.addObject("colorChanges", colorChanges);
	
		return mv;
	}
	
	@RequestMapping(value="uploadVins",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView uploadVins(Integer carProcurementListId, String carProcurementNumber,
			Integer carProcurementListCount, Double procurementPrice, String carProcurementListDate, String typeCode,
			String expectedPaymentDate, String colorCode,HttpServletRequest request) throws Exception {
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		InputStream in = null;
		List<List<Object>> listob = null;
		MultipartFile file = multipartRequest.getFile("vinFile");

		if (file.isEmpty()) {
			throw new Exception("文件不存在！");
		}
		
		in = file.getInputStream();
		listob = ImportExcleUtil.getBankListByExcel(in, file.getOriginalFilename());
		List<String> errorVin = new ArrayList<String>();
		List<Vin> errors = new ArrayList<Vin>();
		
		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		for (int i = 0; i < listob.size(); i++) {

			List<Object> lo = listob.get(i);
			String vinNumber = String.valueOf(lo.get(0));
		if (vinService.findByVinNumber(vinNumber) == null) {

				Vin vin = new Vin();
				vin.setCarProcurementListId(carProcurementListId);
				vin.setStockPrice(procurementPrice);
				vin.setTypeCode(typeCode);
				vin.setColorCode((String)lo.get(3));
				vin.setVinNumber(vinNumber);
				vin.setEngineCode((String)lo.get(2));
				vin.setVinLast(String.valueOf(lo.get(1)));
				
				vinService.add(vin);
			} else {

				errorVin.add(vinNumber);
			}
		}

		if (errorVin.size() != 0) {
			for (String s : errorVin) {
				Vin vins= vinService.findByVinNumber(s);
				vins.setAddAccessorizeNote("VIN号已存在");
				errors.add(vins);
			}
		}
		
		List<ColorChange> colorChanges = colorChangeService.findByTypeCode(typeCode);
		CarProcurementList carProcurementList = carProcuremenListService.findById(carProcurementListId);
		List<TypeDictionary> typeDictionaries = typeDicService.list();// 获取所有的车型信息
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("procurementManager/carProcurementVinAdd");
		mv.addObject("errors", errors);
		mv.addObject("colorChanges", colorChanges);
		mv.addObject("carProcurementList", carProcurementList);
		mv.addObject("typeDictionaries", typeDictionaries);
		
		return mv;

		
	}
}
