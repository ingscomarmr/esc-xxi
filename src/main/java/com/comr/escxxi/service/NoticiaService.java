package com.comr.escxxi.service;

import java.util.Date;
import java.util.List;

import com.comr.escxxi.model.BootGridModel;
import com.comr.escxxi.model.NoticiaModel;

public interface NoticiaService {
	public abstract NoticiaModel findNoticiaById(int id);
	public abstract List<NoticiaModel> findTop2NoticiasHome(Date fecha);
	public abstract List<NoticiaModel> findAllNoticias();
	public abstract BootGridModel findByTituloLikeOrContenidoLikeOrderBy(String search, BootGridModel bGrid);
	
}
