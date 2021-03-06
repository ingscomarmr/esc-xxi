package com.comr.escxxi.model;

import java.util.Date;

public class NoticiaModel {
	private Integer noticiaId;
	private String titulo;
	private String contenido;
	private Integer desactivo;
	private Date fechaVigenciaFin;
	private Date fechaVigenciaInicio;
	
	public NoticiaModel() {
		
	}
	
	public NoticiaModel(Integer noticiaId, String titulo, String contenido, Integer desactivo, Date fechaVigenciaFin,
			Date fechaVigenciaInicio) {
		super();
		this.noticiaId = noticiaId;
		this.titulo = titulo;
		this.contenido = contenido;
		this.desactivo = desactivo;
		this.fechaVigenciaFin = fechaVigenciaFin;
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}

	public Integer getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Integer noticiaId) {
		this.noticiaId = noticiaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Integer getDesactivo() {
		return desactivo;
	}

	public void setDesactivo(Integer desactivo) {
		this.desactivo = desactivo;
	}

	public Date getFechaVigenciaFin() {
		return fechaVigenciaFin;
	}

	public void setFechaVigenciaFin(Date fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}

	public Date getFechaVigenciaInicio() {
		return fechaVigenciaInicio;
	}

	public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}

	public String getContenidoCorto() {
		if(this.contenido != null) {
			if(this.contenido.length() > 50) {
				return this.contenido.substring(0, 47) + "...";
			}else {
				return this.contenido;
			}			
		}else {
			return this.contenido;
		}
	}
	
	@Override
	public String toString() {
		return "NoticiaModel [noticiaId=" + noticiaId + ", titulo=" + titulo + ", contenido=" + contenido + ", desactivo="
				+ desactivo + ", fechaVigenciaFin=" + fechaVigenciaFin + ", fechaVigenciaInicio=" + fechaVigenciaInicio
				+ "]";
	}
			
	
}
