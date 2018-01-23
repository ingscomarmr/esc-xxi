package com.comr.escxxi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comr.escxxi.model.ViewNames;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	//FOR LOGS
	private static Log LOG =  LogFactory.getLog(TeacherController.class);
		
	
	@GetMapping("/")
	public String indexView() {
		LOG.info("#/ -> " + ViewNames.Teacher.HOME);
		return ViewNames.Teacher.HOME;
	}
	
	@GetMapping("/login")
	public String loginView() {
		LOG.info("#/login -> " + ViewNames.Teacher.HOME);
		return ViewNames.Teacher.HOME;
	}
	
}
