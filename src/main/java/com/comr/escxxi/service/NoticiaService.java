package com.comr.escxxi.service;

import java.util.Date;
import java.util.List;

import com.comr.escxxi.model.NoticiaDTO;

public interface NoticiaService {
	public abstract List<NoticiaDTO> findTop2NoticiasHome(Date fecha);
}
