package com.comr.escxxi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.comr.escxxi.model.NoticiaModel;
import com.comr.escxxi.model.ViewNames;
import com.comr.escxxi.service.NoticiaService;
//import com.comr.escxxi.view.xml.NoticiasXmlRoot;

@Controller
public class NoticiasController {
	// FOR LOGS
	private static Log LOG = LogFactory.getLog(NoticiasController.class);
	
	@Autowired
	@Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	@GetMapping("/noticias")
	public ModelAndView getNoticias() {
		LOG.info("/noticias -> " + ViewNames.HomeGeneral.NOTICIAS);
		ModelAndView mav=new ModelAndView(ViewNames.HomeGeneral.NOTICIAS);						
		return mav;
	}
	
	//imitar un restcontroller que responda con xml(default) y json segun el deseo del formato que queremos
	/*
	@GetMapping("/noticias-rest")
	public @ResponseBody NoticiasXmlRoot getNoticiasRest() {
		LOG.info("/noticias -> noticias-rest");
		//al pasar el Root de xml matamos 2 pajaros de un tiro ya que no solo responde en xml si no tambine en jsno
		//para probar hacemos lo siguiente noticias-rest?form=json
		return new NoticiasXmlRoot(noticiaService.findAllNoticias());
		
	}*/
	
	@GetMapping("/noticia/{noticiaId}")
	public ModelAndView getNoticia(@PathVariable(name="noticiaId",required=true) int noticiaId) {
		LOG.info("/noticia/{noticiaId} ->" + ViewNames.HomeGeneral.VER_NOTICIAS + "/" + noticiaId);
		ModelAndView mav = new ModelAndView(ViewNames.HomeGeneral.VER_NOTICIAS);
		NoticiaModel noticia = noticiaService.findNoticiaById(noticiaId);
		LOG.info("#noticia:" + noticia.toString());
		mav.addObject("n", noticia);
		return mav;
	}

}
