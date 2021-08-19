package com.bto.biblioteca.dto;

import java.util.Date;

public class Prestamo {
	
	private Integer prestamoId;
	private Integer libroId;
	private Integer usuarioId;
	private Date fechaPrestamo;
	
	public Prestamo(Integer prestamoId, Integer libroId, Integer usuarioId, Date fechaPrestamo) {
		super();
		this.prestamoId = prestamoId;
		this.libroId = libroId;
		this.usuarioId = usuarioId;
		this.fechaPrestamo = fechaPrestamo;
	}
	
	public Prestamo() {
	}
	
	public Integer getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(Integer prestamoId) {
		this.prestamoId = prestamoId;
	}
	public Integer getLibroId() {
		return libroId;
	}
	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

}
