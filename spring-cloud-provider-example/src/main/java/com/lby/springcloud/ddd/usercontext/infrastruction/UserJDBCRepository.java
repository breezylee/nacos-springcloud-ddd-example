package com.lby.springcloud.ddd.usercontext.infrastruction;

import org.springframework.stereotype.Component;

import com.lby.springcloud.ddd.usercontext.useraggregation.domain.User;
import com.lby.springcloud.ddd.usercontext.useraggregation.domain.UserRepository;

@Component("userJDBCRepository")
public class UserJDBCRepository implements UserRepository {

	@Override
	public User findbyId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findbyAccount(String account) {
		User user = new User();
		user.setAccount(account);
		user.setName(account);
		user.setPassport(account);
		return user;
	}

	
}
