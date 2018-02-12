package com.comr.escxxi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="Usuario",schema="dbo")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private Integer usuarioId;

	@Column(name="apellido_m")
	private String apellidoM;

	@Column(name="apellido_p")
	private String apellidoP;

	private String curp;

	private Integer eliminado;

	private String email;

	@Column(name="email_alternativo")
	private String emailAlternativo;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String nombre;

	private String pwd;

	@Column(name="url_img")
	private String urlImg;

	@Column(name="usuario_id_mod")
	private Integer usuarioIdMod;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="usuario")
	private List<Curso> cursos;

	//bi-directional many-to-one association to Noticia
	@OneToMany(mappedBy="usuario")
	private List<Noticia> noticias;

	//bi-directional many-to-one association to PermisoUsuario
	@OneToMany(mappedBy="usuario")
	private List<PermisoUsuario> permisoUsuarios;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipo_usuario_id")
	private TipoUsuario tipoUsuario;

	public Usuario() {
	}

	public Integer getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getApellidoM() {
		return this.apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getApellidoP() {
		return this.apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Integer getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(Integer eliminado) {
		this.eliminado = eliminado;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAlternativo() {
		return this.emailAlternativo;
	}

	public void setEmailAlternativo(String emailAlternativo) {
		this.emailAlternativo = emailAlternativo;
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

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUrlImg() {
		return this.urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
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
		curso.setUsuario(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setUsuario(null);

		return curso;
	}

	public List<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Noticia addNoticia(Noticia noticia) {
		getNoticias().add(noticia);
		noticia.setUsuario(this);

		return noticia;
	}

	public Noticia removeNoticia(Noticia noticia) {
		getNoticias().remove(noticia);
		noticia.setUsuario(null);

		return noticia;
	}

	public List<PermisoUsuario> getPermisoUsuarios() {
		return this.permisoUsuarios;
	}

	public void setPermisoUsuarios(List<PermisoUsuario> permisoUsuarios) {
		this.permisoUsuarios = permisoUsuarios;
	}

	public PermisoUsuario addPermisoUsuario(PermisoUsuario permisoUsuario) {
		getPermisoUsuarios().add(permisoUsuario);
		permisoUsuario.setUsuario(this);

		return permisoUsuario;
	}

	public PermisoUsuario removePermisoUsuario(PermisoUsuario permisoUsuario) {
		getPermisoUsuarios().remove(permisoUsuario);
		permisoUsuario.setUsuario(null);

		return permisoUsuario;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String toStrSimple() {
		return "Usuario [usuarioId=" + usuarioId + 								
				", email=" + email +								
			"]";
		
	}
	
	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + 
					", nombre=" + nombre + 
					", apellidoM=" + apellidoM + 
					", apellidoP=" + apellidoP + 
					", curp=" + curp + 
					", urlImg="	+ urlImg +
					", email=" + email + 
					", emailAlternativo=" + emailAlternativo + 
					", tipoUsuario=" + tipoUsuario + 
					", eliminado=" + eliminado + 					
					", fechaModificacion=" + fechaModificacion + 					
					", usuarioIdMod=" + usuarioIdMod +
					//", pwd=" + pwd + 					 					 
					//", cursos=" + cursos + 
					//", noticias=" + noticias + 
					//", permisoUsuarios=" + permisoUsuarios + 
					
				"]";
	}

	
}