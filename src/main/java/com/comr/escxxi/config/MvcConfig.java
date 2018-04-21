package com.comr.escxxi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	//Bean para password enconder
	@Bean
	public BCryptPasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
}
