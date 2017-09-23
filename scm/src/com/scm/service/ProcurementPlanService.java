package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.ProcurementPlanMapper;
import com.scm.pojo.ProcurementPlanAnalyze;
import com.scm.pojo.YearProcurement;
import com.scm.pojo.YearProcurementPlan;

@Service("procurementPlanService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class ProcurementPlanService {

	@Resource(name = "procurementPlanMapper")
	private ProcurementPlanMapper procurementPlanMapper;

	// 按年份id查全年采购计划
	public YearProcurement findById(Integer yearProcurementPlanId) {
		return procurementPlanMapper.findById(yearProcurementPlanId);
	}
	
	//按年份、id查看分解计划
	public List<YearProcurement> findByYear(Integer yearProcurementPlanYear, Integer yearProcurementPlanId){
		return procurementPlanMapper.findByYear(yearProcurementPlanYear, yearProcurementPlanId);
	}
	
	//按年份查看分解计划
		public List<YearProcurement> find(Integer yearProcurementPlanYear){
			return procurementPlanMapper.find(yearProcurementPlanYear);
		}

	//创建全年分解采购计划
	public int add(ProcurementPlanAnalyze procurementPlanAnalyze){
		return procurementPlanMapper.add(procurementPlanAnalyze);
	}
	
	//修改全年分解采购计划
	public int updates(ProcurementPlanAnalyze procurementPlanAnalyze){
		return procurementPlanMapper.updates(procurementPlanAnalyze);
	}
	
	//根据id修改状态 是否已经分解
	public int update(Integer yearProcurementPlanId){
		return procurementPlanMapper.update(yearProcurementPlanId);
	}
	
	//分页查询
	public List<YearProcurement> findByPage(Integer pageMin, Integer pageMax, Integer yearProcurementPlanYear){
		return procurementPlanMapper.findByPage(pageMin, pageMax,yearProcurementPlanYear);
	}
		
	//查询记录条数
	public int countPage(){
		return procurementPlanMapper.countPage();
	}
}
