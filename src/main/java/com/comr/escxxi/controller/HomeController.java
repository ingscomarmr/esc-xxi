package com.comr.escxxi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.comr.escxxi.model.ViewNames;

@Controller
public class HomeController {
	
	//FOR LOGS
	private static Log LOG =  LogFactory.getLog(HomeController.class);
	
	//VIEW NAMES
	//public static final String HOME_VIEW="home";	
	
	@GetMapping("/")
	public String indexView() {
		return "redirect:" + ViewNames.HomeGeneral.HOME;
	}
	
	@GetMapping("/home")
	public String homeView() {
		LOG.info("/ -> " + ViewNames.HomeGeneral.HOME);
		return ViewNames.HomeGeneral.HOME;
	}
	
	
}
