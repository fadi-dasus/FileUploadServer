package com.bachelor.fileUploadServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.bachelor.fileUploadServer.exception.ResponseErrorHandler;

@Configuration
public class BeansConfig {
	@Autowired
	ResponseErrorHandler responseErrorHandler;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		template.setErrorHandler(responseErrorHandler);
		return template;
	}
}
