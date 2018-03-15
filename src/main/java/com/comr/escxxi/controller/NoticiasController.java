package com.comr.escxxi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comr.escxxi.model.ViewNames;

@Controller
public class NoticiasController {
	// FOR LOGS
	private static Log LOG = LogFactory.getLog(NoticiasController.class);
	
	@GetMapping("/noticias")
	public ModelAndView getNoticias() {
		LOG.info("/noticias -> " + ViewNames.HomeGeneral.NOTICIAS);
		ModelAndView mav=new ModelAndView(ViewNames.HomeGeneral.NOTICIAS);
		
		return mav;
	}

}
