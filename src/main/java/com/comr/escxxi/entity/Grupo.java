package com.comr.escxxi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@Table(name="Grupo",schema="dbo")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grupo_id")
	private Integer grupoId;

	private Integer eliminado;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String nombre;

	@Column(name="usuario_id_mod")
	private Integer usuarioIdMod;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="grupo")
	private List<Curso> cursos;

	public Grupo() {
	}

	public Integer getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
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

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setGrupo(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setGrupo(null);

		return curso;
	}

	@Override
	public String toString() {
		return "Grupo [grupoId=" + grupoId + ", nombre=" + nombre  + "]";
	}

	
}