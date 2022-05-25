package com.lby.springcloud.ddd.usercontext.useraggregation.domain;

public interface UserRepository {
	public User findbyId(long userId);
	public User findbyAccount(String account);
}
