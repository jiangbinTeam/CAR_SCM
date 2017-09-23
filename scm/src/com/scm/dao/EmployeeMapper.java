package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.scm.pojo.Employee;

@Repository("employeeMapper")
public interface EmployeeMapper {

	@Select("select employeeId,employeeName,employeeTel,employeeSex,employeeBirthday,employeePay,userName from Scm_Employee")
	List<Employee> findAll();

	@Select("select employeeId,employeeName,employeeTel,employeeSex,employeeBirthday,employeePay,userName from Scm_Employee where employeeId=#{employeeId}")
	Employee findByid(Integer employeeId);

	@Insert("insert into Scm_Employee (employeeId,userName,employeeName,employeeTel,employeeSex,employeeBirthday,employeePay) values"
			+ "(#{employeeId},#{userName,jdbcType=VARCHAR},#{employeeName,jdbcType=VARCHAR},"
			+ "#{employeeTel,jdbcType=VARCHAR},#{employeeSex,jdbcType=INTEGER},"
			+ "#{employeeBirthday,jdbcType=DATE},#{employeePay,jdbcType=INTEGER})")
	@SelectKey(keyProperty = "employeeId", statement = "select employee.nextval from dual", before = true, resultType = int.class)
	int add(Employee scm);

	@Update("update Scm_Employee set userName=#{userName,jdbcType=VARCHAR},employeeName=#{employeeName,jdbcType=VARCHAR},"
			+ "employeeTel=#{employeeTel,jdbcType=VARCHAR},employeeSex=#{employeeSex,jdbcType=INTEGER},"
			+ "employeeBirthday=#{employeeBirthday,jdbcType=DATE},employeePay=#{employeePay,jdbcType=INTEGER} where employeeId=#{employeeId}")
	int modifa(Employee scm);
	
	@Select("select count(EMPLOYEEID) from Scm_Employee")
	int total();
	
	@Select("select * from (select rownum rn,e.* from Scm_Employee e ) se where se.rn>=#{pageMin} and se.rn<=#{pageMax}")
	List<Employee> listByPage(@Param("pageMin") Integer pageMin, @Param("pageMax") Integer pageMax);
	
	
}
