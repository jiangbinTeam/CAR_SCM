package com.scm.dao;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Users;

@Repository("usersMapper")
public interface UsersMapper {
	@Select("select * from users where username=#{username} and password=#{password}")
	Users login(@Param("username") String username, @Param("password") String password);

	@Update("update users set password=#{newpassword,jdbcType=VARCHAR} where password=#{password} and username=#{username} ")
	int updateUser(@Param("newpassword") String newpassword, @Param("password") String password,
			@Param("username") String username);

	@Select("select username from users where username=#{username} ")
	String findByName(String username);
}
