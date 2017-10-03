package com.scm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Dealer;
import com.scm.pojo.DealerSettlement;
import com.scm.service.DealerSettlementService;

@Controller
public class DealerSettlementController {

	@Resource(name = "dealerSettlementService")
	private DealerSettlementService dealerSettlementService;

	@RequestMapping("dealerSettlementlist")
	public ModelAndView list() {
		List<DealerSettlement> deal = dealerSettlementService.listByDealerId(3);

		ModelAndView mv = new ModelAndView("sellManager/dealerChargeBalance");
		mv.addObject("deal", deal);
		return mv;
	}

	@RequestMapping("exportPayData")
	@ResponseBody
	public String exportPayData(Integer dealerId) {
		if (dealerId == 0) {
			dealerId = null;
		}

		// 声明一个工作薄，就是创建一个client，来使用各种接口
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建一个excel子标签
		HSSFSheet sheet = wb.createSheet();
		// 创建第一行（也可以称为表头）
		HSSFRow row = sheet.createRow(0);

		// 给表头创建单元格，poi给excel每一格定义为cell（细胞）
		HSSFCell cell = row.createCell((short) 0);
		// 生成一个样式
		HSSFCellStyle style = wb.createCellStyle();
		// 样式字体居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		cell.setCellValue("序号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);

		cell.setCellValue("订单号");
		cell = row.createCell((short) 2);

		cell.setCellValue("汽车VIN号");
		cell = row.createCell((short) 3);

		cell.setCellValue("车款（单位：万）");
		cell = row.createCell((short) 4);

		cell.setCellValue("经销商付款（单位：万）");
		cell = row.createCell((short) 5);

		List<DealerSettlement> deal = dealerSettlementService.listByDealerId(dealerId);

		// 向单元格里填充数据
		for (short i = 0; i < deal.size(); i++) {
			row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(i + 1);
			row.createCell(1).setCellValue(deal.get(i).getOrderNumber());
			row.createCell(2).setCellValue(deal.get(i).getVinNumber());
			row.createCell(3).setCellValue(deal.get(i).getSellPrice());
			row.createCell(4).setCellValue(deal.get(i).getSellPrice());
		}

		try {
			// 使用文件流导出,我默认在桌面
			FileOutputStream out = new FileOutputStream(new File("D:\\Jiangbin\\Workspaces2\\scm\\WebContent\\excel\\经销商付款明细.xls"));
			wb.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "成功！";
	}

	@RequestMapping("dealerSettlementListAll")
	public ModelAndView dealerSettlementList() {
		Integer currPage = 1;
		int pageSize = 5;

		int total = dealerSettlementService.totalcount(null);// 计算总记录数
		int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 计算总页数
		List<DealerSettlement> wars = dealerSettlementService.pageList(1, pageSize, null);// 首页记录
		List<Dealer> warName = dealerSettlementService.listid();// 获取所有的经销商
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/dealerChargeBalance");
		mv.addObject("dealerId", 0);
		mv.addObject("warName", warName);
		mv.addObject("wars", wars);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// 查单个
	@RequestMapping("dealerSettlementByid")
	public ModelAndView findByidku(@RequestParam(value = "currPage", required = true) Integer currPage,
			@RequestParam(value = "dealerId", required = false) Integer dealerId) {

		if (dealerId == 0 || dealerId.equals("")) {
			dealerId = null;
		}
		int pageSize = 5;// 页大小
		int count = dealerSettlementService.totalcount(dealerId);// 总记录数
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
		List<DealerSettlement> wars = null;// 当前页面数据

		List<Dealer> warName = dealerSettlementService.listid(); // 获取所有经销商

		if (currPage < 1) {
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			wars = dealerSettlementService.pageList(pageMin, pageMax, dealerId);
		} else if (currPage > pageAll) {
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			wars = dealerSettlementService.pageList(pageMin, pageMax, dealerId);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			wars = dealerSettlementService.pageList(pageMin, pageMax, dealerId);
		}
		if (dealerId == null) {
			dealerId = 0;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sellManager/dealerChargeBalance");
		mv.addObject("dealerId", dealerId);

		mv.addObject("warName", warName);
		mv.addObject("wars", wars);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}
}
