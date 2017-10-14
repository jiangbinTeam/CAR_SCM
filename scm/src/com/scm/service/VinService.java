package com.scm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.VinMapper;
import com.scm.pojo.Vin;

@Service("vinService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class VinService {

	@Resource(name = "vinMapper")
	private VinMapper vinMapper;

	// 修改实际打款时间
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addActualPaymentDate(Date actualPaymentDate, String vinNumber, Integer paymentListId) {
		return vinMapper.addActualPaymentDate(actualPaymentDate, vinNumber, paymentListId);
	}

	// 修改打款单id
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int addPaymentListId(Integer paymentListId, String vinNumber) {
		return vinMapper.addPaymentListId(paymentListId, vinNumber);
	}

	public List<Vin> findByPListId(Integer paymentListId) {
		return vinMapper.findByPListId(paymentListId);
	}

	public List<Vin> findAll() {
		return vinMapper.findAll();
	}

	// 使用采购单主键查询
	public List<Vin> findByCarProcurementListId(Integer pageMin, Integer pageMax, Integer carProcurementListId) {
		return vinMapper.findByCarProcurementListId(pageMin, pageMax, carProcurementListId);
	}

	//查询符合条件的记录数
	public int total(Integer carProcurementListId) {
		return vinMapper.total(carProcurementListId);
	}
	
	//增添vin信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int add(Vin vin) {
		return vinMapper.add(vin);
	}
	
	//使用vinNumber查询
	public Vin findByVinNumber(String vinNumber) {
		return vinMapper.findByVinNumber(vinNumber);
	}
	
	//修改出入库状态
	public int modifyOutOfStorage(int outOfStorage,String vinNumber) {
		return vinMapper.modifyOutOfStorage(outOfStorage, vinNumber);
	}
}
