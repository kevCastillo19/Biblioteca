package com.bto.biblioteca.interfaz;

import java.util.List;

import com.bto.biblioteca.dto.Prestamo;
import com.bto.biblioteca.dto.PrestamoResponse;

public interface IPrestamosService {

	public List<Prestamo> findAll();
	
	public PrestamoResponse save(Prestamo prestamo);
}
