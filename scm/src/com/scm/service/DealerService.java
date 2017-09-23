package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.DealerMapper;
import com.scm.pojo.Dealer;

@Service("dealerService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class DealerService {
	@Resource(name = "dealerMapper")
	private DealerMapper dealerMapper;

	public Dealer find(Integer dealerId) {
		return dealerMapper.findByid(dealerId);
	}

	public List<Dealer> find() {
		return dealerMapper.All();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int add(Dealer scm) {
		return dealerMapper.add(scm);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int modifa(Dealer scm) {
		return dealerMapper.modifa(scm);
	}

	/*
	 * public Pager<Dealer>findPager(Integer pageno, Integer pagesize, String sort,
	 * String order,String dealerName){ Pager<Dealer> pager = new Pager<Dealer>();
	 * pager.setRows(scmdealerMapper.findPager(pageno, pagesize, sort, order,
	 * dealerName)); pager.setTotal(scmdealerMapper.findPagerTotal(dealerName));
	 * return pager; }
	 */

	// 查询总记录数
	public int total() {
		return dealerMapper.total();
	}

	// 分页
	public List<Dealer> listByPage(Integer pageMin, Integer pageMax) {
		return dealerMapper.listByPage(pageMin, pageMax);
	}

}
