package com.bto.biblioteca.entity;

import javax.persistence.*;

@Entity
@Table(name="Prestamo")
public class TblPrestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prestamoId;
	
	@JoinColumn(name = "libroId", referencedColumnName = "libroId")
	@ManyToOne(optional = false)
	private TblLibro libro;
	
	@JoinColumn(name = "usuarioId", referencedColumnName = "usuarioId")
	@ManyToOne(optional = false)
	private TblUsuario usuario;
	
	@Column(name="fechaPrestamo", nullable=false)
	private String fechaPrestamo;

	public TblPrestamo(Integer prestamoId, TblLibro libro, TblUsuario usuario, String fechaPrestamo) {
		super();
		this.prestamoId = prestamoId;
		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
	}
	
	public TblPrestamo() {
	}


	public Integer getPrestamoId() {
		return prestamoId;
	}

	public void setPrestamoId(Integer prestamoId) {
		this.prestamoId = prestamoId;
	}

	public TblLibro getLibro() {
		return libro;
	}

	public void setLibro(TblLibro libro) {
		this.libro = libro;
	}

	public TblUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(TblUsuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	
}
