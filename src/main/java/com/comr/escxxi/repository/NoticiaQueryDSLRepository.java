package com.comr.escxxi.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.comr.escxxi.entity.Noticia;
import com.comr.escxxi.entity.QNoticia;
import com.comr.escxxi.model.BootGridModel;
import com.comr.escxxi.model.NoticiaModel;
import com.comr.escxxi.utils.Utils;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("noticiaQueryDSLRepository")
public class NoticiaQueryDSLRepository {

	private static final Log LOG = LogFactory.getLog(NoticiaQueryDSLRepository.class);
	private QNoticia qNoticia = QNoticia.noticia;

	@PersistenceContext
	private EntityManager em;

	// Query utilizado para buscar cursos que contenga en el nombre alfunos
	// caracteres
	public QueryResults<Noticia> findByTituloLikeOrContenidoLikeOrderBy(String search, long numPage, long limit) {
		
		LOG.info("findByTituloLikeOrContenidoLikeOrderBy #obtener noticias por query dsl search:" 
		+ search + ", page:" + numPage + " ,limit:" + limit);
		JPAQuery<Noticia> noticiaQuery = new JPAQuery<Noticia>(em);

		BooleanBuilder bb = new BooleanBuilder();
		bb.and(qNoticia.eliminado.eq(0));
		bb.and(qNoticia.desactivo.eq(0));
		if(!Utils.isNullOrEmpty(search)) {
			search = "%" + search + "%";			
			bb.andAnyOf(qNoticia.titulo.like(search),
					qNoticia.contenido.like(search));
			
			
		}
						
		long offset  = (numPage - 1l) * limit;
		
		noticiaQuery = noticiaQuery
				.select(qNoticia)
				.from(qNoticia)
				.where(bb)
				.orderBy(qNoticia.fechaVigenciaInicio.desc()).offset(offset).limit(limit);		
		
		return noticiaQuery.fetchResults();
	}
}
