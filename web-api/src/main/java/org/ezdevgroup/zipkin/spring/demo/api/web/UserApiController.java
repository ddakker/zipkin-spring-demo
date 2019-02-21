package org.ezdevgroup.zipkin.spring.demo.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
	private static final Logger logger = LoggerFactory.getLogger(UserApiController.class);

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public Map<String, Object> getUsers(@PathVariable String name){
		logger.info("API User service "+name);

        Map<String, Object> user = new HashMap<>();
        user.put("id", name);
        user.put("mail", name + "@dk.com");

				
		return user;
	}

}