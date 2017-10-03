package com.scm.controller;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Dealer;
import com.scm.pojo.Warehouse;
import com.scm.service.WarehouseService;

@Controller
public class WarehouseController {
	
	@Resource(name = "warehouseService")
	private WarehouseService warehouseService;
	
	// 首页分页数据
	@RequestMapping("Warehouselist")
	public ModelAndView list() {
		int currPage = 1;
		int pageSize = 5;
		int count = warehouseService.total();
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
		List<Warehouse> wars = warehouseService.listByPage(1, pageSize);
		ModelAndView mv = new ModelAndView("warehouseManager/warehouse");
		mv.addObject("wars", wars);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}

	// 分页
	@RequestMapping("WarehouseByPage")
	public ModelAndView fyTdy(@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageSize = 5;
		int count = warehouseService.total();
		int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
		List<Warehouse> wars = null;

		if (currPage < 1) {
			currPage = 1;
			int pageMin = 1;
			int pageMax = currPage * pageSize;
			wars = warehouseService.listByPage(pageMin, pageMax);
		} else if (currPage > pageAll) {
			currPage = pageAll;
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			wars = warehouseService.listByPage(pageMin, pageMax);
		} else {
			int pageMin = (currPage - 1) * pageSize + 1;
			int pageMax = currPage * pageSize;
			wars = warehouseService.listByPage(pageMin, pageMax);
		}
		
		ModelAndView mv = new ModelAndView("warehouseManager/warehouse");
		mv.addObject("wars", wars);
		mv.addObject("currPage", currPage);
		mv.addObject("totalPage", pageAll);
		return mv;
	}
	
	 @RequestMapping("WarehousefindByid")
	 public ModelAndView findByid(@RequestParam(value = "warehouseId", required = false) Integer warehouseId) {

			ModelAndView mv = new ModelAndView();
			if (warehouseId != null) {
				Warehouse whs = warehouseService.findByid(warehouseId);
				mv.addObject("whs", whs);
			}
			mv.setViewName("warehouseManager/warehouseCreate");
			return mv;
		}
	 
		@RequestMapping("Warehousefindsave")
		public String save(Warehouse war) {
			if (war.getWarehouseId() != null) {
				warehouseService.update(war);
			} else {
				warehouseService.add(war);
			}
			return "redirect:Warehouselist";

		}
   //==========================================================================================
		// 首页分页数据
		@RequestMapping("Warehousekulist")
		public ModelAndView list1() {
			Integer currPage = 1;
			int pageSize = 10;

			int total = warehouseService.totalcount(null);// 计算总记录数
			int pageAll = (int) Math.ceil(total * 1.0 / pageSize);// 计算总页数
			List<Warehouse> wars = warehouseService.pageList(1, pageSize, null);// 首页记录
			List<Warehouse> warName = warehouseService.listid();// 获取所有的年份
 
			ModelAndView mv = new ModelAndView();
			mv.setViewName("warehouseManager/storageAreas");
			mv.addObject("warehouseId", 0);
			mv.addObject("warName", warName);
			
			mv.addObject("wars", wars);
			mv.addObject("currPage", currPage);
			mv.addObject("totalPage", pageAll);
			return mv;
		}


		
		
	     //查单个                                
		 @RequestMapping("WarehousekuByid")
		 public ModelAndView findByidku(@RequestParam(value = "currPage", required = true) Integer currPage,
				                        @RequestParam(value = "warehouseId", required = false) Integer warehouseId) {
			 
			 if (warehouseId==0 || warehouseId.equals("")) {
				 warehouseId = null;
				} 
			    int pageSize = 10;// 页大小
				int count = warehouseService.totalcount(warehouseId);// 总记录数
				int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
				List<Warehouse> wars = null;// 当前页面数据
				
				List<Warehouse> warName =warehouseService.listid(); // 获取所有的仓库
				   
				if (currPage < 1) {
					currPage = 1;
					int pageMin = 1; 
					int pageMax = currPage * pageSize;
					wars = warehouseService.pageList(pageMin, pageMax,warehouseId);
				} else if (currPage > pageAll) {
					currPage = pageAll;
					int pageMin = (currPage - 1) * pageSize + 1; 
					int pageMax = currPage * pageSize;
					wars = warehouseService.pageList(pageMin, pageMax,warehouseId);
				} else {
					int pageMin = (currPage - 1) * pageSize + 1;
					int pageMax = currPage * pageSize;
					wars = warehouseService.pageList(pageMin, pageMax,warehouseId);
				}
			  // List<Warehouse> warsk=warehouseService.findByidk(warehouseId);	
				 if (warehouseId==null ) {
					 warehouseId = 0;
					} 
				ModelAndView mv=new ModelAndView();
				mv.setViewName("warehouseManager/storageAreas");
				mv.addObject("warehouseId", warehouseId);
		 
				mv.addObject("warName", warName);
				mv.addObject("wars", wars); 
				mv.addObject("currPage", currPage);
				mv.addObject("totalPage", pageAll);
				return mv;
			}
		 
		 
		  //添加查单个集合
		 @RequestMapping("WarehousekuByiAll")
		 public ModelAndView findAll(){
	       List<Warehouse> wdk=warehouseService.listid();
	       ModelAndView mv=new ModelAndView();
	       mv.setViewName("warehouseManager/storageAreasCreate");
	       mv.addObject("wdk", wdk);
			return mv;
			 
		 }

		 
		  //修改查单个单
			 @RequestMapping("WarehousekuByiduuuup")
			 public ModelAndView findByidkuuuup(@RequestParam(value = "storageAreasId", required = false) Integer storageAreasId) {
				 ModelAndView mv = new ModelAndView();
					if (storageAreasId != null) {
						Warehouse warsk=new Warehouse();
				        warsk = warehouseService.findByidkk(storageAreasId);
						mv.addObject("warsk", warsk);
					}
					mv.setViewName("warehouseManager/storageAreasCreate");
					return mv;

				}
		 
		 //库位修改
		 @RequestMapping("Warehousekumodifa")
			public String save1(Warehouse warw) {
				if (warw.getStorageAreasId()!= null) {
					warehouseService.modifa(warw);
				} else{
					warehouseService.addku(warw);
				}
				return "redirect:Warehousekulist";

			}
		 
  	
	
}
