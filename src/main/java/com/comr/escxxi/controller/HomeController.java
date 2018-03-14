package com.comr.escxxi.controller;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comr.escxxi.model.NoticiaDTO;
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
		return "redirect:" + ViewNames.HomeGeneral.HOME;
	}
	
	@GetMapping("/home")
	public ModelAndView homeView() {
		LOG.info("/ -> " + ViewNames.HomeGeneral.HOME);
		ModelAndView mav = new ModelAndView(ViewNames.HomeGeneral.HOME);
		
		Calendar cal= Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		
		LOG.info("#CONSULTAR LAS home NOTICIAS DE LA FECHA:" + cal.toString());
		List<NoticiaDTO> nList = noticiaService.findTop2NoticiasHome(cal.getTime());
		LOG.info("#ENVIANDO LAS NOTICIAS A LA VIEW");
		//mav.addObject("noticias", nList);	
		mav.addObject("msg", "mi curso");
		return mav;
	}
	
	
}
