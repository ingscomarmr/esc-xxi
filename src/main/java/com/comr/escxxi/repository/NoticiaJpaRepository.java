package com.comr.escxxi.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.comr.escxxi.entity.Noticia;

@Repository("noticiaJpaRepository")
public interface NoticiaJpaRepository extends JpaRepository<Noticia, Serializable>{
	public Noticia findByNoticiaId(Integer id);
	//public List<Noticia> findAllOrderByFechaVigenciaFinDesc(); 
	public List<Noticia> findByTituloLikeOrderByTitulo(String t);
	public List<Noticia> findByFechaVigenciaInicioGreaterThanAndFechaVigenciaFinLessThan(Date fi, Date ff);
	public List<Noticia> findTop10ByTituloLikeOrderByNoticiaIdDesc(String t);	
	public List<Noticia> findTop2ByFechaVigenciaFinLessThanOrderByFechaVigenciaFinDesc(Date fi);
	public List<Noticia> findByTituloLikeOrContenidoLikeOrderByFechaVigenciaInicio(String titulo, String contenido);
}
