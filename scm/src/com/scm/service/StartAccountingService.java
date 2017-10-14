package com.scm.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.StartAccountingMapper;
import com.scm.pojo.StartAccounting2;

@Service("StartAccountingService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class StartAccountingService {
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
		@Resource(name = "StartAccountingMapper")
		private StartAccountingMapper staMapper;
//按条件查询发车台账管理数据
public List<StartAccounting2> findSatcc(
	      Integer dealerOrderId,
		  String vinNumber,
		  Integer startAccountingStates,
		  Integer pageMin, 
		  Integer pageMax ){
			
return staMapper.findSatcc(dealerOrderId, vinNumber, startAccountingStates, pageMin, pageMax);
		}	
//按条件统计发车台账管理数据记录	
public  int countSatcc(Integer dealerOrderId,String vinNumber,
			          Integer startAccountingStates){
		return staMapper.countSatcc(dealerOrderId, vinNumber, startAccountingStates);
	}
//修改发车台账数据在Vin表中
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)	
public int  updateAccounting(Double sellPrice,
		Integer ifRetrofitting,
		  String addAccessorizeNote,
		String vinNumber2,
		 String vinNumber){
	return staMapper.updateAccounting(sellPrice, ifRetrofitting, addAccessorizeNote, vinNumber2, vinNumber);
}
//按车型及其它条件查已生产发车台账的 VIN	
public List<String> findVins(String typeCode){
	return staMapper.findVins(typeCode);
}
//修改 VIN表中Vin 号
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public  int updateVin ( String vinNumber3, String vinNumber4){
	return staMapper.updateVin(vinNumber3, vinNumber4);
}
//修改有误台账 Vin表中信息
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public int updateVinX( Double sellPrice,
		        Integer ifRetrofitting,
		         String addAccessorizeNote,
		         String vinNumberx){
	return staMapper.updateVinX(sellPrice, ifRetrofitting, addAccessorizeNote, vinNumberx);
}
//清除填错的Vin 号的相关信息
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public int updateVin2( String vinNumber5){
	return staMapper.updateVin2(vinNumber5);
}
//修改台账管理中Vin号
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public int updateSat( String vinNumber6,String vinNumber7){
	
	return staMapper.updateSat(vinNumber6, vinNumber7);
}
//查看某Vin号在已生成的台账中是否存在
public  int seeVin(String vinNumber8){
	return staMapper.seeVin(vinNumber8);
}
//修改发车台账中发车状态
public int  updateStat3(String vinNumber9,String vinNumber10  ){
	return staMapper.updateStat3(vinNumber9, vinNumber10);
}
//查询所有订单号
public List<String> zdbqja() {
	return staMapper.zdbqja();
}
//查询生产发车台账的VIN号
public List<String> zdbqVins(){
	return staMapper.zdbqVins();
}
}
