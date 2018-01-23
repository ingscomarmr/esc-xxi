package com.comr.escxxi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comr.escxxi.model.UserCredential;
import com.comr.escxxi.model.ViewNames;

@Controller
public class LoginController {

	private static Log LOG =  LogFactory.getLog(LoginController.class);		
	
	@GetMapping("/login")
	public String showFormLogin(@RequestParam(name="error", defaultValue="",required=false) String error, Model model) {
		model.addAttribute("userCredential", new UserCredential());
		model.addAttribute("error", error);
		LOG.info("showFormLogin -> " + ViewNames.HomeGeneral.LOGIN);
		return ViewNames.HomeGeneral.LOGIN;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredential") UserCredential userCredential) {
		if(userCredential.getUserName().equals("") &&
				userCredential.getPassword().equals("user")){
			
			LOG.info("loginCheck -> " + ViewNames.Teacher.HOME);
			
			return ViewNames.Teacher.HOME;			
		}
		
		LOG.info("loginCheck -> " + ViewNames.HomeGeneral.LOGIN + "?error");
		return ViewNames.HomeGeneral.LOGIN + "?error";
	}
}
