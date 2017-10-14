package com.scm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.UsersMapper;
import com.scm.pojo.Authorities;
import com.scm.pojo.Employee;
import com.scm.pojo.Users;

@Service("usersService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class UsersService {
	@Resource(name = "usersMapper")
	private UsersMapper mapper;
	
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@Resource(name="authoritiesService")
	private AuthoritiesService authoritiesService;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int UpdatePwd(String newpassword, String userName) {
		return mapper.updateUser(newpassword, userName);
	}

	public Users findUser(String userName, String password) {
		return mapper.login(userName, password);
	}

	public Users findByName(String userName) {
		return mapper.findByName(userName);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public void add(Users user,String authority) {
		//增加系统用户
		mapper.add(user);
		Integer employeeId=Integer.parseInt(user.getUserName());
		
		//将创建的系统用户绑定到员工
		Employee employee=employeeService.find1(employeeId);
		employee.setUserName(user.getUserName());
		employeeService.modifa(employee);
		
		//创建权限表
		authoritiesService.add(new Authorities(user.getUserName(), authority));
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public void   updateEnabled(Users user,String authority) {
		 mapper.updateEnabled(user);
		 
		 Authorities authorities=authoritiesService.findByUserName(user.getUserName());
		 authorities.setAuthority(authority);
		 authoritiesService.modify(authorities);
	}
}
