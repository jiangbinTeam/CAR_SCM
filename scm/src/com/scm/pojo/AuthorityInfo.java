package com.scm.pojo;

import java.io.Serializable;

public class AuthorityInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String employeeName;
	private Integer employeeId;
	private String userName;
	private Integer enabled;
	private String authority;

	public AuthorityInfo() {
		super();
	}

	public AuthorityInfo(String employeeName, Integer employeeId, String userName, Integer enabled, String authority) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.userName = userName;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "AuthorityInfo [employeeName=" + employeeName + ", employeeId=" + employeeId + ", userName=" + userName
				+ ", enabled=" + enabled + ", authority=" + authority + "]";
	}

}
