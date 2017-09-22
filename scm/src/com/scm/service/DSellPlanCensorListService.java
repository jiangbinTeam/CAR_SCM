package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.scm.dao.DSellPlanCensorListMapper;
import com.scm.pojo.DealerSellPlanCensorList;

@Service("dSellPlanCensorListService")
public class DSellPlanCensorListService {

	@Resource(name = "dSellPlanCensorListMapper")
	private DSellPlanCensorListMapper mapper;

	public List<DealerSellPlanCensorList> findByDealerAndDate(Integer pageMax, Integer pageMin, Integer dealerId,
			String typeCode, Integer year, Integer month) {
		return mapper.findByDealerAndDate(pageMax, pageMin, dealerId, typeCode, year, month);
	}

	public int count(Integer dealerId,String typeCode,Integer year,Integer month) {
		return mapper.count(dealerId, typeCode, year, month);
	};
}
