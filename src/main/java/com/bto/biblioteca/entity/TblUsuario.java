package com.bto.biblioteca.entity;

import javax.persistence.*;

@Entity
@Table(name="Usuario")
public class TblUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuarioId;
	
	@Column(name="nombreUsuario", nullable=false)
	private String nombreUsuario;
	
	@Column(name="apellidoUsuario", nullable=false)
	private String apellidoUsuario;
	
	@Column(name="telefonoUsuario", nullable=false)
	private String telefonoUsuario;
	
	@Column(name="emailUsuario", nullable=false)
	private String emailUsuario;

	public TblUsuario(Integer usuarioId, String nombreUsuario, String apellidoUsuario, String telefonoUsuario,
			String emailUsuario) {
		super();
		this.usuarioId = usuarioId;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.emailUsuario = emailUsuario;
	}
	
	public TblUsuario() {
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
}
