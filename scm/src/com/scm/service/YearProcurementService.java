package com.scm.service;
/*
 *  全年采购计划 业务逻辑类
 */

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.YearProcurementMapper;
import com.scm.pojo.YearProcurementPlan;

@Service("yearProcurementService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class YearProcurementService {

	// 查找指定的资源名 spring -> mybatis
	@Resource(name="yearProcurementMapper")
	private YearProcurementMapper yearProcurementMapper;
	
	
	//创建全年采购计划
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public int add(YearProcurementPlan yearProcurementPlan){
		return yearProcurementMapper.add(yearProcurementPlan);
	}
	
	//修改全年采购计划
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public int update(YearProcurementPlan yearProcurementPlan){
		return yearProcurementMapper.update(yearProcurementPlan);
		
	}
	
	//列出全年采购计划
	public List<YearProcurementPlan> findAll(){
		return yearProcurementMapper.findAll();
	}
	
	//通过id查找全年采购计划
	public YearProcurementPlan findById(Integer yearProcurementPlanId){
		return yearProcurementMapper.findById(yearProcurementPlanId);
	}
}
