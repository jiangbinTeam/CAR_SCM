package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.StartAccounting2;
import com.scm.service.StartAccountingService;

import net.sf.json.JSONArray;

@Controller
public class StartAccountingController {
	@Resource(name = "StartAccountingService")
	private StartAccountingService service;

	// 查看所有发车台账
	@RequestMapping(value = "startAone", produces = "application/json; charset=utf-8")
	public ModelAndView startAone() {
		ModelAndView mv = new ModelAndView();
		int pageMin = 1;
		int pageSize = 5;
		int pageMax = pageMin * pageSize;
		Integer dealerOrderId = null;
		String vinNumber = null;
		Integer startAccountingStates = null;
		int ct = service.countSatcc(dealerOrderId, vinNumber, startAccountingStates);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		List<StartAccounting2> stas2 = service.findSatcc(dealerOrderId, vinNumber, startAccountingStates, pageMin,
				pageMax);
		System.out.println(stas2.size());

		mv.addObject("stas2", stas2);
		mv.addObject("currPage", pageMin);
		mv.addObject("totalPage", pageAll);
		mv.setViewName("sellManager/startAccountingManager");
		return mv;
	}

	// 查找相应的Vin号
	@RequestMapping(value = "findVinct", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findVinct(String typeCode) {
		List<String> vins = service.findVins(typeCode);
		JSONArray jsons = JSONArray.fromObject(vins);
		System.out.println(jsons.toString());
		return jsons.toString();
	}

	// 按条件查询发车台账
	@RequestMapping(value = "startTwo", produces = "application/json; charset=utf-8")
	public ModelAndView startTwo(@RequestParam(value = "dealerOrderId", required = false) String dealerOrderId,
			@RequestParam(value = "vinNumber", required = false) String vinNumber,
			@RequestParam(value = "startAccountingStates", required = false) Integer startAccountingStates) {
		ModelAndView mv = new ModelAndView();
		Integer dealerOrderId2 = 0;
		if (dealerOrderId == null || dealerOrderId.equals("")) {
			dealerOrderId = null;
		} else {
			dealerOrderId2 = Integer.parseInt(dealerOrderId);
		}

		String vinNumber2 = null;
		if (vinNumber == null || vinNumber.equals("")) {
			vinNumber = null;
		} else {
			vinNumber2 = vinNumber;
		}
		/* System.out.println(startAccountingStates); */
		if (startAccountingStates == 22) {
			startAccountingStates = null;
		}
		int currPage = 1;
		int pageSize = 5;
		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;
		int ct = service.countSatcc(dealerOrderId2, vinNumber2, startAccountingStates);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		List<StartAccounting2> stas2 = service.findSatcc(dealerOrderId2, vinNumber2, startAccountingStates, pageMin,
				pageMax);
		/* System.out.println(stas2.size()+"信息条数"); */
		if (dealerOrderId != null) {
			mv.addObject("dealerOrderId", dealerOrderId);
		}
		if (vinNumber != null) {
			mv.addObject("vinNumber", vinNumber2);
		}
		if (startAccountingStates != null) {
			mv.addObject("startAccountingStates", startAccountingStates);
		}
		mv.addObject("stas2", stas2);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.setViewName("sellManager/startAccountingManager");
		return mv;
	}

	// 查看所有发车台账分页
	@RequestMapping(value = "fyStart", produces = "application/json; charset=utf-8")
	public ModelAndView fyStart(@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "dealerOrderId", required = false) Integer dealerOrderId,
			@RequestParam(value = "vinNumber", required = false) String vinNumber,
			@RequestParam(value = "startAccountingStates", required = false) Integer startAccountingStates) {
		ModelAndView mv = new ModelAndView();
		if (currPage == null || currPage.equals("")) {
			currPage = 1;
		}

		if (dealerOrderId == 0) {
			dealerOrderId = null;
		}

		String vinNumber2 = null;
		if (vinNumber.endsWith("sbs")) {
			vinNumber = null;
		} else {
			vinNumber2 = vinNumber;
		}

		if (startAccountingStates == 22) {
			startAccountingStates = null;
		}
		int pageSize = 5;
		int ct = service.countSatcc(dealerOrderId, vinNumber2, startAccountingStates);
		int pageAll = (int) Math.ceil(ct * 1.0 / pageSize);
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > pageAll) {
			currPage = pageAll;
		}

		int pageMin = (currPage - 1) * pageSize + 1;
		int pageMax = currPage * pageSize;

		List<StartAccounting2> stas2 = service.findSatcc(dealerOrderId, vinNumber2, startAccountingStates, pageMin,
				pageMax);
		System.out.println(stas2.size());
		if (dealerOrderId != null) {
			mv.addObject("dealerOrderId", dealerOrderId);
		}
		if (vinNumber != null) {
			mv.addObject("vinNumber", vinNumber2);
		}
		if (startAccountingStates != null) {
			mv.addObject("startAccountingStates", startAccountingStates);
		}
		mv.addObject("stas2", stas2);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		mv.setViewName("sellManager/startAccountingManager");
		return mv;
	}

	// 修改发车台账
	@RequestMapping(value = "xgtz", produces = "application/json; charset=utf-8")
	public String xgtz(@RequestParam(value = "sellPrice", required = false) String sellPrice,
			@RequestParam(value = "vinNumber", required = false) String vinNumber,
			@RequestParam(value = "ifRetrofitting", required = false) Integer ifRetrofitting,
			@RequestParam(value = "addAccessorizeNote", required = false) String addAccessorizeNote,
			@RequestParam(value = "vinNumberg", required = false) String vinNumberg,
			@RequestParam(value = "startAccountingId", required = false) Integer startAccountingId) {
		int a = 1;
		a = service.seeVin(vinNumber);
		System.out.println(a + "重复次数");
		if (ifRetrofitting == 0) {
			addAccessorizeNote = "无";
		}
		Double sellPrice2 = Double.parseDouble(sellPrice);
		if (a == 0) {
			int t = service.updateVinX(sellPrice2, ifRetrofitting, addAccessorizeNote, vinNumber);// 修改VIN表 改之后VIN内容
			int t2 = service.updateVin2(vinNumberg);// 清除VIN表被改的VIN号内容
			int t3 = service.updateStat3(vinNumber, vinNumberg);// 修改台账表中VIN号对应的发车状态
			/*System.out.println("ttt1" + t + ":" + t2 + ":" + t3);*/
		}
		if (a > 0) {
			int b4 = service.updateSat("00", vinNumber);// 替换发车台账中需要冲突的VIN号
			int b5 = service.updateStat3(vinNumber, vinNumberg); // 修改发车台账状态
			int b6 = service.updateSat(vinNumber, "00");// 修改完发车台账表中需要修改的信息后 再改回来
			System.out.println("bbb2" + b4 + ":" + b5 + ":" + b6);
			int b = service.updateVin("00", vinNumber);// 如果选的Vin号与别的需要修改的车的Vin号相同 先把已存在的VIN号替换成00
			int b2 = service.updateAccounting(sellPrice2, ifRetrofitting, addAccessorizeNote, vinNumber, vinNumberg);
			int b3 = service.updateVin(vinNumberg, "00");// 修改完VIN表中需要修改的信息后 再改回来
		/*	System.out.println("bbb1" + b + ":" + b2 + ":" + b3);*/

		}

		return "redirect:startAone";
	}

//查询所有订单号
@RequestMapping(value="zdbqj",produces = "application/json; charset=utf-8")
@ResponseBody
public String zdbqj(){
	List<String> dods=service.zdbqja();
	 JSONArray jsons = JSONArray.fromObject(dods);
	 System.out.println(jsons.toString());
	return jsons.toString();
}
//查询已生成发车台帐的VIN号
@RequestMapping(value="zdbqv",produces = "application/json; charset=utf-8")
@ResponseBody
public String zdbqv(){
	List<String> vins=service.zdbqVins();
	 JSONArray jsons = JSONArray.fromObject(vins);
	 System.out.println(jsons.toString());
	return jsons.toString();
 }
}
