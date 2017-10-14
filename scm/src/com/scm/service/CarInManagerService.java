package com.scm.service;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scm.dao.CarInManagerMapper;
import com.scm.pojo.Warehouse;

@Service("carInManagerService")
public class CarInManagerService {
	@Resource(name = "carInManagerManager")
	private CarInManagerMapper carInManagerManager; 
	
	@Resource(name="vinService")
	private VinService vinService;

		
		//入库查询
		public List<Warehouse> findByidruku(){
			return carInManagerManager.findByidruku();
			
		}  
		
		//入库添加
		public int modifa(Warehouse who){
			vinService.modifyOutOfStorage(1, who.getVinNumber());
			return carInManagerManager.modifa(who);
			 
		}
		//分页查询
		public List<Warehouse> pageList(Integer pageMin,Integer pageMax,Integer warehouseId){
			return carInManagerManager.pageList(pageMin, pageMax,warehouseId);
		}
		
		//总记录条数
		public int totalcount(Integer warehouseId) {
			return carInManagerManager.totalcount(warehouseId);
		}
		
		public List<Warehouse> listid(){
			return carInManagerManager.listid();
		}

		
}
