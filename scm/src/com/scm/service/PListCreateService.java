package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scm.dao.PListCreateMapper;
import com.scm.pojo.PaymentListCreate;

@Service("pListCreateService")
public class PListCreateService {

	@Resource(name="pListCreateMapper")
	private PListCreateMapper mapper;
	
	public List<PaymentListCreate> findAll(){
		return mapper.findAll();
	}
}
