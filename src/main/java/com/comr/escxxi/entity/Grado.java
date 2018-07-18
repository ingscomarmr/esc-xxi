package com.comr.escxxi.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the grado database table.
 * 
 */
@Entity
@Table(name="Grado",schema="dbo")
@NamedQuery(name="Grado.findAll", query="SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grado_id")
	private Integer gradoId;

	private Integer eliminado;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String nombre;

	@Column(name="usuario_id_mod")
	private Integer usuarioIdMod;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="grado")
	private List<Curso> cursos;

	public Grado() {
	}

	public Integer getGradoId() {
		return this.gradoId;
	}

	public void setGradoId(Integer gradoId) {
		this.gradoId = gradoId;
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
		curso.setGrado(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setGrado(null);

		return curso;
	}

	@Override
	public String toString() {
		return "Grado [gradoId=" + gradoId + ", nombre=" + nombre + "]";
	}

	
}