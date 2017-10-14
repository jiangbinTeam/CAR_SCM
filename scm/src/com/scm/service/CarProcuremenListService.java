package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.CarProcurementListMapper;
import com.scm.pojo.CarProcurementList;
import com.scm.pojo.ListView;
import com.scm.pojo.TypeDictionary;
import com.scm.pojo.Vin;

@Service("carProcuremenListService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CarProcuremenListService {
	@Resource(name = "carProcurementListMapper")
	private CarProcurementListMapper carProcurementListMapper;

	// 分页
	public List<CarProcurementList> listAllByPage(Integer pageMin, Integer pageMax) {
		return carProcurementListMapper.listAllByPage(pageMin, pageMax);
	}

	// 记录总数
	public int total() {
		return carProcurementListMapper.total();
	}

	// 增添采购单
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int add(CarProcurementList carProcurementList) {
		return carProcurementListMapper.add(carProcurementList);
	}

	// 使用id值查询
	public CarProcurementList findById(Integer carProcurementListId) {
		return carProcurementListMapper.findById(carProcurementListId);
	}

	// 修改采购单信息
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public int modify(CarProcurementList carProcurementList) {
		return carProcurementListMapper.modify(carProcurementList);
	}
}
