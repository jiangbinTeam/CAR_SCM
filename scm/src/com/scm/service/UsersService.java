package com.scm.service;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.UsersMapper;
import com.scm.pojo.Users;


@Service("usersService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class UsersService {
	@Resource(name="usersMapper")
	private UsersMapper mapper;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,
			rollbackFor=Exception.class)
public int UpdatePwd(String newpassword,String password,String userName){
	return mapper.updateUser(newpassword,password,userName);
}

public  Users findUser(String userName,String password){
	return mapper.login(userName, password);
}

public String findByName(String userName){
	return mapper.findByName(userName);
}
}
