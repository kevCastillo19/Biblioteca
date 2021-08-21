package com.bto.biblioteca.interfaz;

import java.util.List;

import com.bto.biblioteca.dto.Libro;
import com.bto.biblioteca.dto.PrestamoResponse;

public interface ILibrosService {
	
	public List<Libro> findAll();
	
	public Libro findById(Integer libroId);
	
	public List<Libro> findByEstado(String estado);
	
	public List<Libro> findByUsuario(String usuarioId);
	
	public PrestamoResponse save(Libro libro);
	
	public PrestamoResponse update(Libro libro);
	
	public PrestamoResponse delete(Integer libroId);
}
