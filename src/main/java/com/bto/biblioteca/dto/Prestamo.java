package com.bto.biblioteca.dto;

public class Prestamo {
	
	private Integer prestamoId;
	private Integer libroId;
	private Integer usuarioId;
	private String fechaPrestamo;
	
	public Prestamo(Integer prestamoId, Integer libroId, Integer usuarioId, String fechaPrestamo) {
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
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

}
