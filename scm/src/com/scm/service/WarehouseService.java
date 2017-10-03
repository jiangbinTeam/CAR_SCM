package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


import com.scm.dao.WarehouseMapper;
import com.scm.pojo.Warehouse;

@Service("warehouseService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class WarehouseService {
	@Resource(name = "warehouseMapper")
	private WarehouseMapper warehouseMapper;
	

	//库位分页
	public List<Warehouse> listByPagek(Integer pageMin, Integer pageMax) {
		return warehouseMapper.listByPagek(pageMin, pageMax);
	}
	
	//库位查单个集合
	public List<Warehouse> findByidk(Integer warehouseId){
		return warehouseMapper.findByidk(warehouseId);
	}
	
	//库位查单个单
		public Warehouse findByidkk(Integer storageAreasId){
			return warehouseMapper.findByidkk(storageAreasId);
		}
	
	//库位修改
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public int modifa(Warehouse warc){
		return warehouseMapper.modifa1(warc);
	} 
	
	//库位添加查所有
	public List<Warehouse> findAll(){
		return warehouseMapper.findAll();
	}
	
	//库位添加
	public int addku(Warehouse warc){
		return warehouseMapper.addku(warc);
		
	}
	
	//分页查询
	public List<Warehouse> pageList(Integer pageMin,Integer pageMax,Integer warehouseId){
		return warehouseMapper.pageList(pageMin, pageMax,warehouseId);
	}
	
	//总记录条数
	public int totalcount(Integer warehouseId) {
		return warehouseMapper.totalcount(warehouseId);
	}
	
	public List<Warehouse> listid(){
		return warehouseMapper.listid();
	}

	
	
	
	

	//仓库总记录
	public int total() {
		return warehouseMapper.total(); 	
	}

	//仓库分页
	public List<Warehouse> listByPage(Integer pageMin, Integer pageMax) {
		return warehouseMapper.listByPage(pageMin, pageMax);
	}
	//仓库查单个
	public Warehouse findByid(Integer warehouseId){
		return warehouseMapper.findByid(warehouseId);
	}

	
	//仓库修改
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public int update(Warehouse warh){
		return warehouseMapper.modifa(warh);
		
	}
	//仓库添加
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public int add(Warehouse warh){
		return warehouseMapper.add(warh);		
	}


}
