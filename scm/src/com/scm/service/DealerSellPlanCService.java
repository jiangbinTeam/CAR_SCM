package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.DealerSellPlanCMapper;
import com.scm.pojo.DealerSellPlanCensor;

@Service("dealerSellPlanCService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class DealerSellPlanCService {
	
	@Resource(name="dealerSellPlanCMapper")
	private DealerSellPlanCMapper mapper;
	
	//分页查询
	public List<DealerSellPlanCensor> pageList(Integer pageMin,Integer pageMax,String year,
			String yearPlanMouth,String typeCode,Integer dealerId){
		return mapper.pageList(pageMin, pageMax, year, yearPlanMouth, typeCode, dealerId);
	}
	
	//总记录条数
	public int total(String year,String mouth,String typeCode,Integer dealerId) {
		return mapper.total(year, mouth, typeCode, dealerId);
	}
	
	public List<String> listYear(){
		return mapper.listYear();
	}
}
