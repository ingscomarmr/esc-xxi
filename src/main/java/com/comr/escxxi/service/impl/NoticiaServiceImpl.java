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
import com.comr.escxxi.model.BootGridModel;
import com.comr.escxxi.model.NoticiaModel;
import com.comr.escxxi.repository.NoticiaJpaRepository;
import com.comr.escxxi.repository.NoticiaQueryDSLRepository;
import com.comr.escxxi.service.NoticiaService;
import com.querydsl.core.QueryResults;

@Service("noticiaService")
public class NoticiaServiceImpl implements NoticiaService {

	private static final Log LOG = LogFactory.getLog(NoticiaServiceImpl.class);

	@Autowired
	@Qualifier("noticiaJpaRepository")
	NoticiaJpaRepository noticiaJpaRepository;

	@Autowired
	@Qualifier("noticiaQueryDSLRepository")
	NoticiaQueryDSLRepository noticiaQueryDSLRepository;

	@Override
	public List<NoticiaModel> findTop2NoticiasHome(Date fecha) {
		LOG.info("#OBTENER LAS 2 ULTIMAS NOTICIAS SEGUN FECHA");
		ModelMapper mm = new ModelMapper();
		List<Noticia> nList = noticiaJpaRepository.findTop2ByFechaVigenciaFinLessThanOrderByFechaVigenciaFinDesc(fecha);
		List<NoticiaModel> ndList = new ArrayList<NoticiaModel>();
		for (Noticia noticia : nList) {
			NoticiaModel nd = mm.map(noticia, NoticiaModel.class);
			ndList.add(nd);
		}
		return ndList;
	}

	@Override
	public List<NoticiaModel> findAllNoticias() {
		LOG.info("#BUSCAR TODAS LAS NOTICIAS");
		List<Noticia> nList = noticiaJpaRepository.findAll();
		List<NoticiaModel> ndList = new ArrayList<NoticiaModel>();
		ModelMapper mm = new ModelMapper();
		for (Noticia noticia : nList) {
			NoticiaModel nd = mm.map(noticia, NoticiaModel.class);
			ndList.add(nd);
		}
		return ndList;
	}

	@Override
	public BootGridModel findByTituloLikeOrContenidoLikeOrderBy(String search, BootGridModel bGrid) {

		QueryResults<Noticia> nQuery = noticiaQueryDSLRepository.findByTituloLikeOrContenidoLikeOrderBy(search,
				bGrid.getCurrent(), bGrid.getRowCount());

		bGrid.setTotal(nQuery.getTotal());
		;
		ModelMapper mm = new ModelMapper();

		List<Noticia> nList = nQuery.getResults();
		List<NoticiaModel> nmList = new ArrayList<NoticiaModel>();
		for (Noticia noticia : nList) {
			NoticiaModel ndo = mm.map(noticia, NoticiaModel.class);
			nmList.add(ndo);
		}

		bGrid.setRows(nmList);
		return bGrid;
	}
		
	@Override
	public NoticiaModel findNoticiaById(int id) {
		LOG.info("#Buscando la niticia id:" + id);
		NoticiaModel n = new NoticiaModel();

		if (id > 0) {
			Noticia noticia = noticiaJpaRepository.findByNoticiaId(id);			
			if(noticia != null) {
				LOG.info("#Noticia " + id + " encontrada " + noticia);
				n = new ModelMapper().map(noticia, NoticiaModel.class);
			}
		}

		return n;
	}

	@Override
	public List<Noticia> findByTituloLikeOrContenidoLikeOrderByFechaVigenciaInicio(String tituloContenido) {		
		return noticiaJpaRepository.findByTituloLikeOrContenidoLikeOrderByFechaVigenciaInicio(tituloContenido, tituloContenido);
	}

	
}
