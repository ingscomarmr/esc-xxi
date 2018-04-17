package com.comr.escxxi.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comr.escxxi.model.NoticiaModel;
import com.comr.escxxi.model.Roles;
import com.comr.escxxi.model.ViewNames;
import com.comr.escxxi.service.NoticiaService;

@Controller
public class HomeController {
	
	//FOR LOGS
	private static Log LOG =  LogFactory.getLog(HomeController.class);
	
	//VIEW NAMES
	//public static final String HOME_VIEW="home";	
	
	@Autowired
	@Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	@GetMapping("/")
	public String indexView() {
		LOG.info("/ -> redirect to " + ViewNames.HomeGeneral.HOME);
		return "redirect:" + ViewNames.HomeGeneral.HOME;
	}
	
	@GetMapping("/home")
	public ModelAndView homeView() {
		LOG.info("/home -> " + ViewNames.HomeGeneral.HOME);
		ModelAndView mav = new ModelAndView(ViewNames.HomeGeneral.HOME);		
		
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		
		LOG.info("#CONSULTAR LAS home NOTICIAS DE LA FECHA:" + cal.toString());
		List<NoticiaModel> nList = noticiaService.findTop2NoticiasHome(cal.getTime());
		LOG.info("#ENVIANDO LAS NOTICIAS A LA VIEW");
		mav.addObject("noticias", nList);	
		
		//obtener el usuario autentificado
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		if(aut != null) {
			mav.addObject("user_name_login", aut.getName());
		}
		
		
		return mav;
	}
	
	@GetMapping("/defaultForLogin")
	public String defaultAfterLogin(HttpServletRequest request) {
        LOG.info("#IN LOGIN :" + request.getRemoteUser());	
       
        //redirigiendo a la pagina que le corresponde
		if (request.isUserInRole("ROLE_" + Roles.ADMIN)) {
            return "redirect:/" + ViewNames.HomeGeneral.HOME;
        }else if(request.isUserInRole("ROLE_" + Roles.TEACHER)) {
        	return "redirect:/" + ViewNames.HomeGeneral.TEACHER;
        }else if(request.isUserInRole("ROLE_" + Roles.STUDENT)) {
        	return "redirect:/" + ViewNames.HomeGeneral.STUDENT;
        }else if(request.isUserInRole("ROLE_" + Roles.ADVISOR)) {
        	return "redirect:/" + ViewNames.HomeGeneral.ADVISOR;
        }
		return "redirect:/" + ViewNames.HomeGeneral.HOME;
    }
	
	//este metodo nos ayuda a saber si el usuario logeado tiene el rol
	private boolean hasRole(Roles role) {
		SecurityContext context = SecurityContextHolder.getContext();
		
		if(context == null) {
			return false;
		}
		
		Authentication aut = context.getAuthentication();
		if(aut == null) {
			return false;
		}
		
		Collection<? extends GrantedAuthority> autohotities = aut.getAuthorities();
		for(GrantedAuthority ga : autohotities) {
			if(role.toString().equals(ga.getAuthority())) {
				return true;
			}
		}
		return false;
	}
}
