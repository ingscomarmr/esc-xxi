package com.comr.escxxi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the permiso_usuario database table.
 * 
 */
@Entity
@Table(name="permiso_usuario",schema="dbo")
@NamedQuery(name="PermisoUsuario.findAll", query="SELECT p FROM PermisoUsuario p")
public class PermisoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="permiso_id")
	private Integer permisoId;

	private Integer desactivo;

	private Integer eliminado;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String role;

	@Column(name="usuario_id_mod")
	private Integer usuarioIdMod;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public PermisoUsuario() {
	}

	public Integer getPermisoId() {
		return this.permisoId;
	}

	public void setPermisoId(Integer permisoId) {
		this.permisoId = permisoId;
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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getUsuarioIdMod() {
		return this.usuarioIdMod;
	}

	public void setUsuarioIdMod(Integer usuarioIdMod) {
		this.usuarioIdMod = usuarioIdMod;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "PermisoUsuario [permisoId=" + permisoId + ", desactivo=" + desactivo + ", eliminado=" + eliminado
				+ ", fechaModificacion=" + fechaModificacion + ", role=" + role + ", usuarioIdMod=" + usuarioIdMod
				+ ", usuario=" + usuario + "]";
	}

	
}