package com.comr.escxxi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the noticia database table.
 * 
 */
@Entity
@Table(name="Noticia",schema="dbo")
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="noticia_id")
	private Integer noticiaId;

	private String contenido;

	private Integer desactivo;

	private Integer eliminado;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vigencia_fin")
	private Date fechaVigenciaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vigencia_inicio")
	private Date fechaVigenciaInicio;

	private String titulo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id_mod")
	private Usuario usuario;

	public Noticia() {
	}

	public Integer getNoticiaId() {
		return this.noticiaId;
	}

	public void setNoticiaId(Integer noticiaId) {
		this.noticiaId = noticiaId;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Integer getDesactivo() {
		return this.desactivo;
	}

	public void setDesactivo(Integer desactivo) {
		this.desactivo = desactivo;
	}

	public Integer getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(Integer eliminado) {
		this.eliminado = eliminado;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaVigenciaFin() {
		return this.fechaVigenciaFin;
	}

	public void setFechaVigenciaFin(Date fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}

	public Date getFechaVigenciaInicio() {
		return this.fechaVigenciaInicio;
	}

	public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Noticia [noticiaId=" + noticiaId +
				", titulo=" + titulo +
				", fechaVigenciaInicio=" + fechaVigenciaInicio +
				", fechaVigenciaFin=" + fechaVigenciaFin + 
				", contenido=" + contenido + 
				", desactivo=" + desactivo + 
				", eliminado=" + eliminado + 
				", fechaModificacion=" + fechaModificacion + 								 				
				 "]";
	}

	
}