package com.bachelor.fileUploadServer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {
// remeber to remove it in the production profile 
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("*");
	    }
	

}
