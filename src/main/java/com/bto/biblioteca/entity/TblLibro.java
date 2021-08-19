package com.bto.biblioteca.entity;

import javax.persistence.*;

@Entity
@Table(name="Libro")
public class TblLibro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer libroId;
	
	@Column(name="titulo", nullable=false)
	private String titulo;
	
	@Column(name="autor", nullable=false)
	private String autor;
	
	@Column(name="estado", nullable=false)
	private String estado;

	public TblLibro(Integer libroId, String titulo, String autor, String estado) {
		super();
		this.libroId = libroId;
		this.titulo = titulo;
		this.autor = autor;
		this.estado = estado;
	}
	
	public TblLibro() {
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
