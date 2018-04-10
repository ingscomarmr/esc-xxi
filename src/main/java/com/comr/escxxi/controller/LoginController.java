package com.comr.escxxi.controller;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	
	@Autowired
	private MessageSource msgSource;
	
	@GetMapping("/login")
	public String showFormLogin(@RequestParam(name="error",required=false) String error,
			@RequestParam(name="logout",required=false) String logout,
			Model model,
			Principal principal) {
				
		if(principal != null) { //ya esta logeado el usuario
			LOG.info("El usuario ya estaba logeado, se redirige a home");
			return "redirect:/";
		}
		
		if(error != null) {
			LOG.info("Error en Login:" + error);
			String msgError = msgSource.getMessage("login.msg.error", null, null);
			model.addAttribute("error", msgError);
		}
		
		if(logout != null) {
			LOG.info("Error en Login:" + logout);
			String msgLogout = msgSource.getMessage("login.msg.logout", null, null);
			model.addAttribute("logout", msgLogout);
		}
		
		LOG.info("showFormLogin -> " + ViewNames.HomeGeneral.LOGIN);
		return ViewNames.HomeGeneral.LOGIN;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredential") UserCredential userCredential) {
		
		if(userCredential.getUserName().equals("admin@admin.com") &&
				userCredential.getPassword().equals("admin")){
			
			LOG.info("loginCheck -> " + ViewNames.Teacher.HOME);
			
			return ViewNames.Teacher.HOME;			
		}
		
		LOG.info("loginCheck -> " + ViewNames.HomeGeneral.LOGIN + "?error");
		return "redirect:/" + ViewNames.HomeGeneral.LOGIN + "?error";
	}
}
