package com.comr.escxxi.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comr.escxxi.model.NoticiaDTO;
import com.comr.escxxi.service.NoticiaService;

@RestController
public class NoticiasRestController {
	private static Log LOG = LogFactory.getLog(NoticiasRestController.class);
	
	@Autowired
	@Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	@RequestMapping("/getnoticias")
	public List<NoticiaDTO> getNoticias(){
		LOG.info("/getnoticias - >");
		List<NoticiaDTO> nList=new ArrayList<NoticiaDTO>();
		nList = noticiaService.findAllNoticias();
		return nList;		
	}
}
