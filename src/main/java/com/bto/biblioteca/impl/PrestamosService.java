package com.bto.biblioteca.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bto.biblioteca.dto.Libro;
import com.bto.biblioteca.dto.Prestamo;
import com.bto.biblioteca.dto.PrestamoResponse;
import com.bto.biblioteca.entity.TblLibro;
import com.bto.biblioteca.entity.TblPrestamo;
import com.bto.biblioteca.interfaz.IPrestamosService;
import com.bto.biblioteca.repositoy.ILibroRepository;
import com.bto.biblioteca.repositoy.IPrestamoRepository;
import com.bto.biblioteca.repositoy.IUsuarioRepository;

@Service
public class PrestamosService implements IPrestamosService {

	@Autowired
	private ILibroRepository libroRepository;
	
	@Autowired
	private IPrestamoRepository prestamoRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public List<Prestamo> findAll() {
		List<TblPrestamo> lista = prestamoRepository.findAll(); // SELECT * FROM PEDIDOS;
		List<Prestamo> listadoPrestamos = entityPrestamosToDtoList(lista);

		return listadoPrestamos;
	}

	@Override
	public PrestamoResponse save(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<Prestamo> entityPrestamosToDtoList(List<TblPrestamo> lista) {
		List<Prestamo> listadoPrestamos = new ArrayList<>();

		for (TblPrestamo ent : lista) {

			Prestamo prestamo = new Prestamo(ent.getPrestamoId(), ent.getLibro().getLibroId(), 
					ent.getUsuario().getUsuarioId(), ent.getFechaPrestamo());
			/*for(TblLibro lib : ent.getLibro()) {
				
			}*/

			listadoPrestamos.add(prestamo);
		}

		return listadoPrestamos;
	}

}
