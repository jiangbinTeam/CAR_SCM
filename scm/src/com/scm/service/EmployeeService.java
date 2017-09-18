package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.EmployeeMapper;
import com.scm.pojo.Employee;


@Service("employeeService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class EmployeeService {
	
	@Resource(name="employeeMapper")
    private EmployeeMapper employeeMapper;
	
	public List<Employee> find(){
		return employeeMapper.findAll();
		
	}
	
	public Employee find1(Integer employeeId){
		return employeeMapper.findByid(employeeId);
		
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public int  add(Employee scm){
		return employeeMapper.add(scm);
		
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public int modifa(Employee scm){
		return employeeMapper.modifa(scm);
	}
    
	public int total() {
		return employeeMapper.total();
	}
	
	public List<Employee>  listByPage(Integer pageMin,Integer pageMax){
		return employeeMapper.listByPage(pageMin, pageMax);
	}
	
}
