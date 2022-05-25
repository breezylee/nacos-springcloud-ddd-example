package com.lby.springcloud.ddd;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lby.springcloud.ddd.security.NeedLogin;

@RestController
public class EchoController {

	@RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
	public String echo(@PathVariable String string) {
		
		return "Hello Nacos Discovery " + string;
	}
	
	@RequestMapping(value = "/login/{string}", method = RequestMethod.GET)
	@NeedLogin
	public String login(@PathVariable String string) {
		
		return "Hello Nacos Discovery login :" + string;
	}
}
