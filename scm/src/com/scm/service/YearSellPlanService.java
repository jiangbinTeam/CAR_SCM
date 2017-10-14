package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.scm.dao.YearSellPlanMapper;
import com.scm.pojo.Dealer;
import com.scm.pojo.SelectSell;
import com.scm.pojo.YearPlanDealerAnalyze;
import com.scm.pojo.YearPlanMonthAnalyze;
import com.scm.pojo.YearSellPlan;

@Service("yearSellPlanService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class YearSellPlanService {
	
	@Resource(name="yearSellPlanMapper")
	private YearSellPlanMapper yearSellPlanMapper;
	
	
	
	public List<SelectSell> list(){
		return yearSellPlanMapper.list( );
	}
	
	public int add(YearSellPlan yearSellPlan){
		return yearSellPlanMapper.add(yearSellPlan);
	}
	
	public List<SelectSell> findByPage(Integer pageMin,Integer pageMax){
		return yearSellPlanMapper.findByPageSell(pageMin, pageMax);
	}
	public int countPageSell(){
		return yearSellPlanMapper.countPageSell();
	}
	public int updateSell(YearSellPlan yearSellPlan){
		return yearSellPlanMapper.updateSell(yearSellPlan);
	}
	public SelectSell findByID(Integer yearsellplanid){
		return yearSellPlanMapper.findByid(yearsellplanid);
	}
	public int addMonth(YearPlanMonthAnalyze yearPlanMonthAnalyze){
		return yearSellPlanMapper.addMonth(yearPlanMonthAnalyze);
	}
	public int updateDec(Integer yearSellPlanId){
		return yearSellPlanMapper.updateDec(yearSellPlanId);
	}
	public List<SelectSell> findByMonth(Integer yearSellPlanId){
		return yearSellPlanMapper.findByMouth(yearSellPlanId);
	}
	public SelectSell findByMonthID(Integer yearPlanMonthAnalyzeId){
		return yearSellPlanMapper.findByMouthID(yearPlanMonthAnalyzeId);	
	}
	public int updateMonth(YearPlanMonthAnalyze yearPlanMonthAnalyze){
		return yearSellPlanMapper.updateMonth(yearPlanMonthAnalyze);
	}
	public List<Dealer> listDealer(){
		return yearSellPlanMapper.listDealer();
	}
	public int addDealer(YearPlanDealerAnalyze yearPlanDealerAnalyze){
		return yearSellPlanMapper.addDealer(yearPlanDealerAnalyze);
	}
	public int updateifDec(Integer yearPlanMonthAnalyzeId){
		return yearSellPlanMapper.updateifDec(yearPlanMonthAnalyzeId);
	}
	public int  findYearId(Integer yearPlanMonthAnalyzeId ){
		return yearSellPlanMapper.findYearId(yearPlanMonthAnalyzeId);
	}
	public List<SelectSell> findAllMonth(Integer pageMin,Integer pageMax,Integer year ,String typeCode){
		return yearSellPlanMapper.findAllMouth(pageMin, pageMax, year, typeCode);
	}
	public int countPageDealer( Integer year,String typeCode){
		return yearSellPlanMapper.countPageDealer(year, typeCode);
	}
	public List<SelectSell> findAllDea(Integer pageMin,Integer pageMax){
		return yearSellPlanMapper.findAllDea(pageMin, pageMax);
	}
	
	public int countPageDea(){
		return yearSellPlanMapper.countPageDea();
	}
	public List<SelectSell> selYearTypt(){
		return yearSellPlanMapper.selYearTypt();
	}
	public List<SelectSell> selYearTypt2(){
		return yearSellPlanMapper.selYearTypt2();
	}
	
	public List<SelectSell> findAllDea2( Integer pageMin,  Integer pageMax,
			  String  principalName){
		return yearSellPlanMapper.findAllDea2(pageMin, pageMax, principalName);
	}
	
	public int countPageDea2(String  principalName){
		return yearSellPlanMapper.countPageDea2(principalName);
	}
	public List<Dealer> selYearTypt3(){
		return yearSellPlanMapper.selYearTypt3();
	}
	
	
}
