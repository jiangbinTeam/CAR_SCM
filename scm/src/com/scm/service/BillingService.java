package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scm.dao.BillingMapper;
import com.scm.pojo.Billing;

@Service("billingService")
public class BillingService {
  @Resource(name="billingMapper")
  private BillingMapper billingMapper;
  
     public List<Billing> pagelist(Integer pageMin,Integer pageMax,String vinNumber){
		return billingMapper.pagelist(pageMin, pageMax, vinNumber);
     }
     
     public int totalcount(String vinNumber){
		return billingMapper.totalcount(vinNumber);
     }
     
     public int modifa(Billing bil){
		return billingMapper.modifa(bil);  
     }
}
