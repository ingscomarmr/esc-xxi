package com.comr.escxxi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	//Bean para password enconder
	@Bean
	public BCryptPasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
	
	//para exportar a xml
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		
		//clases para que se mapen en xml
		Class[] classToXmlMap = new Class[] {com.comr.escxxi.view.xml.NoticiasXmlRoot.class};
		
		marshaller.setClassesToBeBound(classToXmlMap);
		return marshaller;
	}
}
