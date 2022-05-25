package com.lby.springcloud.ddd.usercontext.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.nacos.client.utils.StringUtils;
import com.lby.springcloud.ddd.usercontext.api.request.LoginReq;
import com.lby.springcloud.ddd.usercontext.api.response.Response;
import com.lby.springcloud.ddd.usercontext.useraggregation.domain.User;
import com.lby.springcloud.ddd.usercontext.userapplication.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@PathVariable String string) {
		return "Hello Nacos Discovery login :" + string;
	}*/
	
	
    @PostMapping("/login")
    public Response<User> login(@RequestBody LoginReq loginReq) throws Exception {
    	String account = loginReq.getAccount();
    	String passport = loginReq.getPassport();
    	assertNull(account,passport);
    	User user = userService.login(account, passport);
    	Response<User> response = new Response<User>();
    	if(user != null) {
    		response.setCode("200");
    		response.setData(user);
    		response.setMsg("");
    	} else {
    		response.setCode("201");
    		response.setMsg("can not find user by passport");
    	}
    	return response;
    }

	private void assertNull(String account, String passport) throws Exception {
		if(StringUtils.isBlank(account) || StringUtils.isBlank(passport)) {
			throw new Exception("account or passport can be null");
		}
	}
	
}
