package com.lby.springcloud.ddd.usercontext.userapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lby.springcloud.ddd.usercontext.useraggregation.domain.User;
import com.lby.springcloud.ddd.usercontext.useraggregation.domain.UserRepository;

@Service
public class UserService {

	@Autowired
	@Qualifier("userJDBCRepository")
	private UserRepository userRepository;
	
	public User login(String account, String passport) {
		User user = userRepository.findbyAccount(account);
		if(user != null) {
			boolean b = user.checkPassport(account, passport);
			if(b) {
				return user;
			}
		}
		return null;
	}
}
