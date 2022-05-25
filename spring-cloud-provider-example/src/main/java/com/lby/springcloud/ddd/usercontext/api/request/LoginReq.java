package com.lby.springcloud.ddd.usercontext.api.request;

import java.io.Serializable;

public class LoginReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String account;
	private String passport;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
}
