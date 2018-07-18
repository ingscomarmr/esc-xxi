package com.comr.escxxi.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the area_tematica database table.
 * 
 */
@Entity
@Table(name="area_tematica",schema="dbo")
@NamedQuery(name="AreaTematica.findAll", query="SELECT a FROM AreaTematica a")
public class AreaTematica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="area_tematica_id")
	private Integer areaTematicaId;

	private Integer eliminado;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String nombre;

	@Column(name="usuario_id_mod")
	private Integer usuarioIdMod;

	//bi-directional many-to-one association to Curso	
	@OneToMany(mappedBy="areaTematica")
	private List<Curso> cursos;

	public AreaTematica() {
	}

	public Integer getAreaTematicaId() {
		return this.areaTematicaId;
	}

	public void setAreaTematicaId(Integer areaTematicaId) {
		this.areaTematicaId = areaTematicaId;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getUsuarioIdMod() {
		return this.usuarioIdMod;
	}

	public void setUsuarioIdMod(Integer usuarioIdMod) {
		this.usuarioIdMod = usuarioIdMod;
	}
	
	@XmlTransient
	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setAreaTematica(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setAreaTematica(null);

		return curso;
	}

	@Override
	public String toString() {
		return "AreaTematica [areaTematicaId=" + areaTematicaId + ", nombre=" + nombre + "]";
	}

	
}