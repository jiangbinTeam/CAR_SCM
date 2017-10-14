package com.scm.dao;


import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Users;

@Repository("usersMapper")
public interface UsersMapper {
	// 使用户用户名和密码来查询用户
	@Select("select * from users where username=#{userName} and password=#{password}")
	Users login(@Param("userName") String userName, @Param("password") String password);

	// 修改密码
	@Update("update users set password=#{newpassword,jdbcType=VARCHAR} where username=#{userName} ")
	int updateUser(@Param("newpassword") String newpassword, @Param("userName") String userName);

	// 使用用户名来查询用户信息
	@Select("select * from users where userName=#{userName} ")
	Users findByName(String userName);
	
	@Insert("insert into users values(#{userName},#{password},#{enabled})")
	int add(Users user);
	
	@Update("update users set enabled=#{enabled} where username=#{userName} ")
	int updateEnabled(Users user);

}
