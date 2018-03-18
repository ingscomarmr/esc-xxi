package com.comr.escxxi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.comr.escxxi.entity.Noticia;
import com.comr.escxxi.model.NoticiaDTO;
import com.comr.escxxi.repository.NoticiaJpaRepository;
import com.comr.escxxi.service.NoticiaService;

@Service("noticiaService")
public class NoticiaServiceImpl implements NoticiaService{

	private static final Log LOG = LogFactory.getLog(NoticiaServiceImpl.class);
	
	@Autowired
	@Qualifier("noticiaJpaRepository")
	NoticiaJpaRepository noticiaJpaRepository;
	
	
	
	@Override
	public List<NoticiaDTO> findTop2NoticiasHome(Date fecha) {
		LOG.info("#OBTENER LAS 2 ULTIMAS NOTICIAS SEGUN FECHA");
		ModelMapper mm = new ModelMapper();
		List<Noticia> nList = noticiaJpaRepository.findTop2ByFechaVigenciaFinLessThanOrderByFechaVigenciaFinDesc(fecha);
		List<NoticiaDTO> ndList = new ArrayList<NoticiaDTO>();
		for (Noticia noticia : nList) {
			NoticiaDTO nd = mm.map(noticia, NoticiaDTO.class);
			ndList.add(nd);
		}
		return ndList;
	}

	@Override
	public List<NoticiaDTO> findAllNoticias() {
		LOG.info("#BUSCAR TODAS LAS NOTICIAS");
		List<Noticia> nList = noticiaJpaRepository.findAll();
		List<NoticiaDTO> ndList = new ArrayList<NoticiaDTO>();
		ModelMapper mm = new ModelMapper();
		for (Noticia noticia : nList) {
			NoticiaDTO nd = mm.map(noticia, NoticiaDTO.class);
			ndList.add(nd);
		}
		return ndList;
	}

}
