package com.lby.springcloud.ddd.usercontext.useraggregation.domain;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2166686812008378636L;
	private long id;
	private String name;
	private String account;
	private String passport;
	
	
	public boolean checkPassport(String account, String passport) {
		boolean b = false;
		if(account.equals(this.account) && passport.equals(this.passport)) {
			b = true;
		}
		return b;
	}
	
	public String getPassport() {
		return this.passport;
	}
	
	public String getName() {
		return name;
	}
	
	public long getId() {
		return id;
	}
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
}