package com.scm.pojo;

import java.io.Serializable;

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private Integer enabled;

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Users(String userName, String password, Integer enabled) {
		super();
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}

	public Users() {
		super();
	}

}
