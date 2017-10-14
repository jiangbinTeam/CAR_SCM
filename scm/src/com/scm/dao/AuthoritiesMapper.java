package com.scm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Authorities;

@Repository("authoritiesMapper")
public interface AuthoritiesMapper {
	
	@Insert("insert into authorities values(#{username},#{authority}) ")
	int add(Authorities authorities);
	
	@Update("update  authorities set authority=#{authority} where username=#{username}")
	int modify(Authorities authorities);
	
	@Select("select * from authorities where username=#{username}")
	Authorities findByUserName(String userName);
}
