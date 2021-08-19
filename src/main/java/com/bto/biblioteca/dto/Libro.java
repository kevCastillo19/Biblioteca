package com.bto.biblioteca.dto;

public class Libro {
	
	private Integer libroId;
	private String titulo;
	private String autor;
	private String estado;
	
	public Libro(Integer libroId, String titulo, String autor, String estado) {
		super();
		this.libroId = libroId;
		this.titulo = titulo;
		this.autor = autor;
		this.estado = estado;
	}
	
	public Libro() {
		
	}

	public Integer getLibroId() {
		return libroId;
	}
	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
