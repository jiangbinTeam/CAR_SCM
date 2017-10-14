package com.scm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.DealerOrderMapper;
import com.scm.pojo.ColorChange;
import com.scm.pojo.Dealer;
import com.scm.pojo.DealerOrder;
import com.scm.pojo.DealerOrderDetails;
import com.scm.pojo.DealerOrderDetails2;
import com.scm.pojo.TypeDictionary;

@Service("DealerOrderService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class DealerOrderService {
	// @Transactional(propagation = Propagation.REQUIRED, isolation =
	// Isolation.DEFAULT, rollbackFor = Exception.class)
	@Resource(name = "DealerOrderMapper")
	private DealerOrderMapper delemapper;

	// 按经销商查订单分页
	public List<DealerOrder> findAll(Integer pageMin, Integer pageMax, Integer dealerId, Date beginDate, Date endDate,
			String orderNumber) {

		return delemapper.list(pageMin, pageMax, dealerId, beginDate, endDate, orderNumber);
	}

	// 按经销商统计订单
	public int countDealerOrder(Integer dealerId, Date beginDate, Date endDate, String orderNumber) {
		return delemapper.countDealerOrder(dealerId, beginDate, endDate, orderNumber);
	}

	// 按ID查经销商订单
	public DealerOrder findById(Integer dealerOrderId) {

		return delemapper.findById(dealerOrderId);
	}

	// 按经销商订单查询所有订单明细
	public List<DealerOrderDetails2> findDealDetails(Integer dealerorderid, Integer pageMin, Integer pageMax) {
		return delemapper.findByDetails(dealerorderid, pageMin, pageMax);
	}

	// 按经销商订单ID统计所有订单明细
	public int countDetails(Integer dealerOrderId) {
		return delemapper.countDetails(dealerOrderId);
	}

	// 查询所有经销商
	public List<Dealer> dealers() {

		return delemapper.dealers();
	}

	// 查询所有车型
	public List<TypeDictionary> typeDictionaries() {
		return delemapper.typeDictionaries();
	}

	// 查询所有车型颜色
	public List<ColorChange> colorChanges() {
		return delemapper.colorChanges();
	}

	// 添加经销商订单表数据
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addDealerOrder(DealerOrder dealoOrder) {
		return delemapper.addDealerOrder(dealoOrder);
	}

	// 添加经销商订单明细
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addDealerOrderDetails(DealerOrderDetails dod) {

		return delemapper.addDetails(dod);
	}

	// 按条件查询所有VIN号
	public List<String> findVin(Integer dealerOrderId) {

		return delemapper.vinn(dealerOrderId);
	}

	// 查询当前所下订单的Id
	public int dealorderId() {
		return delemapper.dealerOrderId();
	}

	// 生成发车台账后 修改VIN表数据
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addAccounting(Double sellPrice, Integer ifRetrofitting, String addAccessorizeNote, String vinNumber) {
		return delemapper.addAccounting(sellPrice, ifRetrofitting, addAccessorizeNote, vinNumber);

	}

	// 添加发车台账数据到 发车台账表
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addStartAccounting1(String vinNumber, Integer dealerOrderId) {
		return delemapper.addStartAccounting1(vinNumber, dealerOrderId);
	}

	// 修改订单明细表状态
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int updateDealerOrder(Integer dealerOrderDetailsId) {
		return delemapper.update(dealerOrderDetailsId);
	}

	// 查询所有订单
	public List<DealerOrder> listAllDealerOrder(Integer dealerId, String startDate,
			String endDate, String orderNumber) {
		return delemapper.listAllDealerOrder(dealerId, startDate, endDate, orderNumber);
	}

	// 统计订单记录总数
	public int total(Integer dealerId, String startDate, String endDate, String orderNumber) {
		return delemapper.total(dealerId, startDate, endDate, orderNumber);
	}

}
