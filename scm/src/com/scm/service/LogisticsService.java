package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.LogisticsMapper;
import com.scm.pojo.Logistics;

@Service("logisticsService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class LogisticsService {

	@Resource(name = "logisticsMapper")
	private LogisticsMapper logisticsMapper;

	// 增添物流公司
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int add(Logistics scmLogistics) {
		return logisticsMapper.add(scmLogistics);
	}

	// 查询所有的物流公司
	public List<Logistics> findAll() {
		return logisticsMapper.findAll();
	}
	
	//修改物流公司信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int update(Logistics scmLogistics) {
		return logisticsMapper.update(scmLogistics);
	}
	
	//按id值查询物流公司信息
	public Logistics findById(Integer logisticsId) {
		return logisticsMapper.findById(logisticsId);
	}
}
