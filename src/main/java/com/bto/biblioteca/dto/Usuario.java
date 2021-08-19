package com.bto.biblioteca.dto;

public class Usuario {
	
	private Integer usuarioId;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String telefonoUsuario;
	private String emailUsuario;
	
	public Usuario(Integer usuarioId, String nombreUsuario, String apellidoUsuario, String telefonoUsuario,
			String emailUsuario) {
		super();
		this.usuarioId = usuarioId;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.emailUsuario = emailUsuario;
	}
	
	public Usuario() {
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
