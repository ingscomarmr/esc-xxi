package com.comr.escxxi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comr.escxxi.model.ViewNames;

@Controller
@RequestMapping("/student")
public class StudentController {

	// FOR LOGS
	private static Log LOG = LogFactory.getLog(TeacherController.class);

	@GetMapping("/")
	public String indexView() {
		LOG.info("#/ -> NO DISPONIBLE AUN");
		return ViewNames.Student.HOME;
	}
	
	
}
