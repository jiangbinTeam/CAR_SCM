package com.scm.service;

import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
import com.scm.dao.CarOutManagerMapper;
import com.scm.pojo.TypeDictionary;
import com.scm.pojo.Warehouse;

@Service("carOutManagerService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CarOutManagerService {
	@Resource(name = "carOutManager")
	private CarOutManagerMapper carOutManager; 
	
	//仓库总记录
	public int total() {
		return carOutManager.total();
	}

	//仓库分页
	public List<Warehouse> listByPage(Integer pageMin, Integer pageMax) {
		return carOutManager.listByPagek(pageMin, pageMax);
	}
	
	//模糊查询
	public List<Warehouse> findBychuku(Integer warehouseId,String typeCode,String vinNumber){
		return carOutManager.findBychuku(warehouseId, typeCode, vinNumber);
		
	}
	//汽车出库
	public int findBychukua(Integer storageAreasId ){
		return carOutManager.modifa(storageAreasId);
	}
	
	
	//分页查询
	public List<Warehouse> pageList(Integer pageMin,Integer pageMax,Integer warehouseId,
			String typeCode,String vinNumber){
		return carOutManager.pageList(pageMin, pageMax, warehouseId, typeCode,vinNumber);
	}
	
	//总记录条数
	public int totalcount(Integer warehouseId,String typeCode,String vinNumber) {
		return carOutManager.totalcount(warehouseId, typeCode, vinNumber);
	} 
	//仓库
	public List<Warehouse> listid(){
		return carOutManager.listid();
	}
	//车型
	public List<TypeDictionary> listtypeCode(){
		return carOutManager.listtypeCode();
	}
	//vin
	public List<Warehouse> listvinNumber(){
		return carOutManager.listvinNumber();
	}
}
