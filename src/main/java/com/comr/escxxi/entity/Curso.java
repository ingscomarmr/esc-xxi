package com.comr.escxxi.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.sql.Timestamp;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@Table(name="Curso",schema="dbo")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="curso_id")
	private Integer cursoId;

	private String asignatura;

	private Integer desactivo;

	private Integer eliminado;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	@Column(name="usuario_id_mod")
	private Integer usuarioIdMod;

	//bi-directional many-to-one association to AreaTematica
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="area_tematica_id")
	private AreaTematica areaTematica;

	//bi-directional many-to-one association to Grado
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="grado_id")
	private Grado grado;

	//bi-directional many-to-one association to Grupo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="grupo_id")
	private Grupo grupo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="profesor_id")
	private Usuario usuario;

	public Curso() {
	}

	public Integer getCursoId() {
		return this.cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public String getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
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

	public Integer getUsuarioIdMod() {
		return this.usuarioIdMod;
	}

	public void setUsuarioIdMod(Integer usuarioIdMod) {
		this.usuarioIdMod = usuarioIdMod;
	}

	public AreaTematica getAreaTematica() {
		return this.areaTematica;
	}

	public void setAreaTematica(AreaTematica areaTematica) {
		this.areaTematica = areaTematica;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	@XmlTransient
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Curso [cursoId=" + cursoId + 
					", asignatura=" + asignatura + 					 
					", areaTematica=" + areaTematica + 
					", grado=" + grado + 
					", grupo=" + grupo + 
					", profesor=" + (usuario != null? usuario.toStrSimple() : "null") +
					", desactivo=" + desactivo + 
					", eliminado=" + eliminado + 
					", fechaModificacion=" + fechaModificacion + 
					", usuarioIdMod=" + usuarioIdMod +
				 "]";
	}

	
	
}