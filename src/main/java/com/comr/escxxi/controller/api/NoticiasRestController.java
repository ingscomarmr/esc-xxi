package com.comr.escxxi.controller.api;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comr.escxxi.model.BootGridModel;
import com.comr.escxxi.service.NoticiaService;

@RestController
@RequestMapping("/api/noticia")
public class NoticiasRestController {
	private static Log LOG = LogFactory.getLog(NoticiasRestController.class);
	
	@Autowired
	@Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	@RequestMapping("/get-grid-noticias")
	public BootGridModel getNoticias(
			@RequestParam(name="current",required=false,defaultValue="1") int current,
			@RequestParam(name="rowCount",required=false,defaultValue="10") int rowCount,
			@RequestParam(name="searchPhrase",required=false,defaultValue="") String searchPhrase,
			@RequestParam(name="sort[]",required=false,defaultValue="") String[] sort
			){
		LOG.info("/getnoticias - >current:" + current + 
				", rowCount:" + rowCount + rowCount + ", searchPhrase:" + searchPhrase 
				+", sort:" + ((sort != null && sort.length > 0)? sort.length : "0"));
		//sort
		BootGridModel grd = new BootGridModel();
		try {
			grd.setCurrent(current);
			grd.setRowCount(rowCount);			
			grd = noticiaService.findByTituloLikeOrContenidoLikeOrderBy(searchPhrase, grd);
		}catch (Exception e) {
			LOG.error("Problema:" + e.getMessage());
		}		
						
		return grd;
	}
}
