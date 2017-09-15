package com.scm.pojo;

import java.io.Serializable;

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Integer enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Users(String username, String password, Integer enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Users() {
		super();
	}

}
