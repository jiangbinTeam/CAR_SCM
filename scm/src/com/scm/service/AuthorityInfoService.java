package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scm.dao.AuthorityInfoMapper;
import com.scm.pojo.AuthorityInfo;

@Service("authorityInfoService")
public class AuthorityInfoService {
	
	@Resource(name="authorityInfoMapper")
	private AuthorityInfoMapper mapper;
	
	//列出所有
	public List<AuthorityInfo> listAll(){
		return mapper.listAll();
	}
	
	//分页
	public List<AuthorityInfo> listByPage(Integer pageMin,Integer pageMax){
		return mapper.listByPage(pageMin, pageMax);
	}
	
	//记录总数
	public int total() {
		return mapper.total();
	}
	
	//使用员工编号查询
	public AuthorityInfo findByemployeeId(Integer employeeId) {
		return mapper.findByemployeeId(employeeId);
	}
	
	//使用用户名插叙
	public AuthorityInfo findByUserName(String  userName) {
		return mapper.findByUserName(userName);
	}
}
