package com.scm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.InvoiceMapper;
import com.scm.pojo.Dealer;
import com.scm.pojo.Invoice;
import com.scm.pojo.Invoice2;
import com.scm.pojo.Invoice3;
import com.scm.pojo.Logistics;

@Service("InvoiceService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class InvoiceService {
	// @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	@Resource(name = "InvoiceMapper")
	private InvoiceMapper icemapper;

	// 多条件查询所有发车管理所需数据
	public List<Invoice2> findInvoice(Integer dealerId, Date startDate, Date accessCarDate, Integer pageMin,
			Integer pageMax) {
		return icemapper.findInvoice(dealerId, startDate, accessCarDate, pageMin, pageMax);
	}

	// 多条件统计发车管理数据记录
	public int countIod(Integer dealerId, Date startDate, Date accessCarDate) {
		return icemapper.countIod(dealerId, startDate, accessCarDate);
	}

	// 查询所有经销商
	public List<Dealer> dealers() {
		return icemapper.dealers();
	}

	// 确认发车添加日期到发车管理表
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addStartDate(Integer invoiceId, Date startDate) {
		return icemapper.addStartDate(invoiceId, startDate);
	}

	// 确认接车添加日期到发车管理表
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addAccessCarDate(Integer invoiceId, Date accessCarDate) {

		return icemapper.addAccessCarDate(invoiceId, accessCarDate);
	}

	// 添加运费到经销商运费表
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addYunFei(Integer invoiceId, Double carriageCharge) {
		return icemapper.addYunFei(invoiceId, carriageCharge);
	}

	// 修改发车台账中发车状态
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int updStartA(Integer invoiceId, Integer startAccountingStates) {
		return icemapper.updStartA(invoiceId, startAccountingStates);
	}

	// 按发货表ID查询发车管理表信息
	public Invoice2 findInvoiceById(Integer invoiceId) {
		return icemapper.findInvoiceById(invoiceId);
	}

	// 查看某发车单号下详情
	public List<Invoice3> findInvoice3s(Integer invoiceId, Integer pageMin, Integer pageMax) {
		return icemapper.findInvoice3s(invoiceId, pageMin, pageMax);
	}

	// 统计某发车单号下车辆数量
	public int countStadInv(Integer invoiceId) {
		return icemapper.countStadInv(invoiceId);
	}

	// 查询所有物流公司
	public List<Logistics> findLogs() {
		return icemapper.findLogs();
	}

	// 查询所有已出库可以生成发车单的汽车
	public List<Invoice3> findtdyvs(Integer pageMin, Integer pageMax) {
		return icemapper.findtdyvs(pageMin, pageMax);
	}

	// 按ID修改发车单所需数据
	public List<Invoice3> findtdyvs2(Integer pageMin, Integer pageMax, Integer invoiceId) {
		return icemapper.findtdyvs2(pageMin, pageMax, invoiceId);
	}

	// 创建发车单
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int createInv(Integer logisticsId, Integer dealerId, Double carriageCharge, String invoiceNumber) {
		return icemapper.createInv(logisticsId, dealerId, carriageCharge, invoiceNumber);
	}

	// 创建发车单时在发车台账中添加发车单ID
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int upstata(Integer invoiceId, Integer startAccountingId) {
		return icemapper.upstata(invoiceId, startAccountingId);
	}

	// 统计所有已出库可以生成发车单的汽车的数量
	public int countCinv() {
		return icemapper.countCinv();
	}

	// 按ID统计修改发车单数据量
	public int countUinv(Integer invoiceId) {
		return icemapper.countUinv(invoiceId);
	}

	// 拿到创建发车单时发车单ID
	public int findInvoiceId() {
		return icemapper.findInvoiceId();
	}

	// 修改发车单数据
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int xgInv(Integer logisticsId, Integer dealerId, Double carriageCharge, String invoiceNumber,
			Integer invoiceId) {
		return icemapper.xgInv(logisticsId, dealerId, carriageCharge, invoiceNumber, invoiceId);
	}
	
	public Invoice findById(Integer invoiceId) {
		return icemapper.findById(invoiceId);
	}
}
