package com.scm.pojo;

import java.io.Serializable;

/*
 * 权限表
 */
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Authorities(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	public Authorities() {
		super();
	}

	@Override
	public String toString() {
		return "Authorities [username=" + username + ", authority=" + authority + "]";
	}

}
