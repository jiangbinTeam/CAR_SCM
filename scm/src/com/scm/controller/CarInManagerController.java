package com.scm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scm.pojo.Warehouse;
import com.scm.service.CarInManagerService;

@Controller
public class CarInManagerController {
	@Resource(name = "carInManagerService")
	private CarInManagerService carInManagerService;
	
	// 首页分页数据
/*		@RequestMapping("CarInManagerlist")
		public ModelAndView list() {
			int currPage = 1;
			int pageSize = 5;
			int count = carInManagerService.total();
			int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
			List<Warehouse> comg = carInManagerService.listByPage(1, pageSize);
			ModelAndView mv = new ModelAndView("warehouseManager/carInManager");
			mv.addObject("comg", comg);
			mv.addObject("currPage", currPage);
			mv.addObject("totalPage", pageAll);
			return mv;
		}

		// 分页
		@RequestMapping("CarInManagerByPage")
		public ModelAndView fyTdy(@RequestParam(value = "currPage", required = false) Integer currPage) {

			int pageSize = 5;
			int count = carInManagerService.total();
			int pageAll = (int) Math.ceil(count * 1.0 / pageSize);
			List<Warehouse> comg = null;

			if (currPage < 1) {
				currPage = 1;
				int pageMin = 1;
				int pageMax = currPage * pageSize;
				comg = carInManagerService.listByPage(pageMin, pageMax);
			} else if (currPage > pageAll) {
				currPage = pageAll;
				int pageMin = (currPage - 1) * pageSize + 1;
				int pageMax = currPage * pageSize;
				comg = carInManagerService.listByPage(pageMin, pageMax);
			} else {
				int pageMin = (currPage - 1) * pageSize + 1;
				int pageMax = currPage * pageSize;
				comg = carInManagerService.listByPage(pageMin, pageMax);
			}
			
			ModelAndView mv = new ModelAndView("warehouseManager/carInManager");
			mv.addObject("comg", comg);
			mv.addObject("currPage", currPage);
			mv.addObject("totalPage", pageAll);
			return mv;
		}*/
		
		//入库下拉查集合
		@RequestMapping("CarInManagerfindByidc")  
		public ModelAndView findByid(){  
			 List<Warehouse> wc=carInManagerService.findByidruku();
			 System.out.println("fdsfdsfds");
		       ModelAndView mv=new ModelAndView();
		       mv.setViewName("warehouseManager/carInManager");
		       mv.addObject("wc", wc);
				return mv;
		}
	
	    @RequestMapping("CarInManagerlist")
		public ModelAndView list() {
				Integer currPage = 1;
				int pageSize = 15;
				int total = carInManagerService.totalcount(null);
				int pageAll = (int) Math.ceil(total * 1.0 / pageSize);
				List<Warehouse> wars = carInManagerService.pageList(1, pageSize, null);

				List<Warehouse> warName = carInManagerService.listid();
	 
				ModelAndView mv = new ModelAndView();
				mv.setViewName("warehouseManager/carInManager");
				mv.addObject("warehouseId", 0);
				
				mv.addObject("warName", warName);
				mv.addObject("wars", wars);
				mv.addObject("currPage", currPage);
				mv.addObject("totalPage", pageAll);
				return mv;
			}
	    
	   // 分页查询
	    @RequestMapping("CarInManagerByPage")
	    public ModelAndView findByidku(@RequestParam(value = "currPage", required = true) Integer currPage,
                @RequestParam(value = "warehouseId", required = false) Integer warehouseId) {
						if (warehouseId==0 || warehouseId.equals("")) {
						warehouseId = null;
						} 
						int pageSize = 15;// 页大小
						int count = carInManagerService.totalcount(warehouseId);// 总记录数
						int pageAll = (int) Math.ceil(count * 1.0 / pageSize);// 计算总页数
						List<Warehouse> wars = null;// 当前页面数据
						
						List<Warehouse> warName =carInManagerService.listid(); // 获取所有的仓库
						
						if (currPage < 1) {
						currPage = 1;
						int pageMin = 1; 
						int pageMax = currPage * pageSize;
						wars = carInManagerService.pageList(pageMin, pageMax,warehouseId);
						} else if (currPage > pageAll) {
						currPage = pageAll;
						int pageMin = (currPage - 1) * pageSize + 1; 
						int pageMax = currPage * pageSize;
						wars = carInManagerService.pageList(pageMin, pageMax,warehouseId);
						} else {
						int pageMin = (currPage - 1) * pageSize + 1;
						int pageMax = currPage * pageSize;
						wars = carInManagerService.pageList(pageMin, pageMax,warehouseId);
						}
						// List<Warehouse> warsk=warehouseService.findByidk(warehouseId);	
						if (warehouseId==null ) {
						warehouseId = 0;
						} 
						ModelAndView mv=new ModelAndView();
						mv.setViewName("warehouseManager/carInManager");
						mv.addObject("warehouseId", warehouseId);
						
						mv.addObject("warName", warName);
						mv.addObject("wars", wars); 
						mv.addObject("currPage", currPage);
						mv.addObject("totalPage", pageAll);
						return mv;
}
	  
		//入库添加
		@RequestMapping("CarInManagerfindmodifa")
		public String save(Warehouse who){ 
		
			if(who.getStorageAreasId()!=null){
				carInManagerService.modifa(who);
			}
			return "redirect:CarInManagerlist";
			
		}
		
		
}
