package com.scm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.AuthoritiesMapper;
import com.scm.pojo.Authorities;

@Service("authoritiesService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class AuthoritiesService {
	
	@Resource(name="authoritiesMapper")
	private AuthoritiesMapper mapper;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int add(Authorities authorities) {
		return mapper.add(authorities);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int modify(Authorities authorities) {
		return mapper.modify(authorities);
	}
	
	public Authorities findByUserName(String userName) {
		return mapper.findByUserName(userName);
	}
}
