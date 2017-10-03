package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.DealerSettlementMapper;
import com.scm.pojo.Dealer;
import com.scm.pojo.DealerSettlement;

@Service("dealerSettlementService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class DealerSettlementService {

	@Resource(name = "dealerSettlementMapper")
	private DealerSettlementMapper dealerSettlementMapper;

	public List<DealerSettlement> listByDealerId(Integer dealerId) {
		return dealerSettlementMapper.listByDealerId(dealerId);

	}

	// 分页查询
	public List<DealerSettlement> pageList(Integer pageMin, Integer pageMax, Integer dealerId) {
		return dealerSettlementMapper.pageList(pageMin, pageMax, dealerId);
	}

	// 总记录条数
	public int totalcount(Integer dealerId) {

		return dealerSettlementMapper.totalcount(dealerId);
	}

	public List<Dealer> listid() {
		return dealerSettlementMapper.listid();
	}

}
