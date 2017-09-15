package com.scm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.UsersMapper;
import com.scm.pojo.Users;

@Service("usersService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class UsersService {
	@Resource(name = "usersMapper")
	private UsersMapper usersMapper;

	// 修改密码
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int UpdatePwd(String newpassword, String password, String username) {
		return usersMapper.updateUser(newpassword, password, username);
	}

	// 登陆查询
	public Users findUser(String username, String password) {
		return usersMapper.login(username, password);
	}

	// 查询名字
	public String findByName(String username) {
		return usersMapper.findByName(username);
	}
}
