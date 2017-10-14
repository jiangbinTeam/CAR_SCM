package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.scm.pojo.AuthorityInfo;

@Repository("authorityInfoMapper")
public interface AuthorityInfoMapper {
	
	@Select("select rownum rn, EMPLOYEEID, employeeName,b.username,enabled,authority from \r\n" + 
			"(select EMPLOYEEID, employeeName,username,enabled from \r\n" + 
			"(select EMPLOYEEID, employeeName,u.username,enabled from users u right join \r\n" + 
			"scm_employee e on u.username=e.username )) b left join \r\n" + 
			"authorities a on a.username=b.username")
	List<AuthorityInfo> listAll();
	
	@Select("select * from\r\n" + 
			"(select rownum rn, EMPLOYEEID, employeeName,b.username,enabled,authority from \r\n" + 
			"(select EMPLOYEEID, employeeName,username,enabled from \r\n" + 
			"(select EMPLOYEEID, employeeName,u.username,enabled from users u right join \r\n" + 
			"scm_employee e on u.username=e.username )) b left join \r\n" + 
			"authorities a on a.username=b.username) "
			+ "where rn>=#{pageMin} and rn<=#{pageMax}")
	List<AuthorityInfo> listByPage(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);
	
	
	@Select("select count(*) from users u right join scm_employee e on u.username=e.username")
	int total();
	
	@Select("select rownum rn, EMPLOYEEID, employeeName,b.username,enabled,authority from \r\n" + 
			"(select employeeid, employeeName,username,enabled from \r\n" + 
			"(select employeeid, employeeName,u.username,enabled from users u right join \r\n" + 
			"scm_employee e on u.username=e.username )) b left join \r\n" + 
			"authorities a on a.username=b.username "
			+ " where employeeId=#{employeeId}")
	AuthorityInfo findByemployeeId(Integer employeeId);
	
	@Select("select rownum rn, EMPLOYEEID, employeeName,b.username,enabled,authority from \r\n" + 
			"(select employeeid, employeeName,username,enabled from \r\n" + 
			"(select employeeid, employeeName,u.username,enabled from users u right join \r\n" + 
			"scm_employee e on u.username=e.username )) b left join \r\n" + 
			"authorities a on a.username=b.username "
			+ " where b.userName=#{userName}")
	AuthorityInfo findByUserName(String  userName);
	
}
