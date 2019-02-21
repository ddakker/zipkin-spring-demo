package org.ezdevgroup.zipkin.spring.demo.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("org.ezdevgroup.zipkin.spring.demo.home.web")
public class ZipkinDemoHomeApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDemoHomeApplication.class, args);
	}
}