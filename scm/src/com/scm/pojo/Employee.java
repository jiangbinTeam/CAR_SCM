package com.scm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer employeeId;
	private String userName;
	private String employeeName;
	private String employeeTel;
	private Integer employeeSex;
	private Date employeeBirthday;
	private Double employeePay;

	public Employee(Integer employeeId, String userName, String employeeName, String employeeTel,
			Integer employeeSex, Date employeeBirthday, Double employeePay) {
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.employeeName = employeeName;
		this.employeeTel = employeeTel;
		this.employeeSex = employeeSex;
		this.employeeBirthday = employeeBirthday;
		this.employeePay = employeePay;
	}

	public Employee() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeTel() {
		return employeeTel;
	}

	public void setEmployeeTel(String employeeTel) {
		this.employeeTel = employeeTel;
	}

	public Integer getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(Integer employeeSex) {
		this.employeeSex = employeeSex;
	}

	public Date getEmployeeBirthday() {
		return employeeBirthday;
	}

	public void setEmployeeBirthday(Date employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}

	public Double getEmployeePay() {
		return employeePay;
	}

	public void setEmployeePay(Double employeePay) {
		this.employeePay = employeePay;
	}

	@Override
	public String toString() {
		return "Scm_Employee [employeeId=" + employeeId + ", username=" + userName + ", employeeName=" + employeeName
				+ ", employeeTel=" + employeeTel + ", employeeSex=" + employeeSex + ", employeeBirthday="
				+ employeeBirthday + ", employeePay=" + employeePay + "]";
	}

}
