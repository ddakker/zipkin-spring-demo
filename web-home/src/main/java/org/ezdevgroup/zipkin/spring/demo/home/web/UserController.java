package org.ezdevgroup.zipkin.spring.demo.home.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    RestTemplate restTemplate;

	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public Map<String, Object> getUsers(@PathVariable String name){
		logger.info("User service name: {}", name);

		Map<String, Object> user = restTemplate.exchange("http://localhost:8280/api/user/"+name
										,HttpMethod.GET,null
										,new ParameterizedTypeReference<Map<String, Object>>() {}).getBody();

		logger.info("name: {}, user: {}", name, user);
				
		return user;
	}

}