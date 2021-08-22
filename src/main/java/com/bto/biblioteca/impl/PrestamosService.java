package com.bto.biblioteca.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bto.biblioteca.dto.Prestamo;
import com.bto.biblioteca.dto.PrestamoResponse;
import com.bto.biblioteca.entity.TblLibro;
import com.bto.biblioteca.entity.TblPrestamo;
import com.bto.biblioteca.entity.TblUsuario;
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
	public List<Prestamo> findByUsuarioId(Integer usuarioId) {

		List<TblPrestamo> lista = prestamoRepository.findAll();
		List<Prestamo> listadoPrestamos = entityPrestamosUsuarioList(lista, usuarioId);

		return listadoPrestamos;
	}

	@Override
	public List<Prestamo> findByFechaPrestamo(String fechaPrestamo) {
		
		List<TblPrestamo> lista = prestamoRepository.findByFechaPrestamo(fechaPrestamo);
		
		List<Prestamo> listadoPrestamos= entityPrestamosToDtoList(lista);

		return listadoPrestamos;
	}

	@Override
	public PrestamoResponse save(Prestamo prestamo) {
		PrestamoResponse response = new PrestamoResponse();
		
		Optional<TblLibro> libro = libroRepository.findById(prestamo.getLibroId()); 
		Optional<TblUsuario> usuario = usuarioRepository.findById(prestamo.getUsuarioId());
		List<TblPrestamo> lista = prestamoRepository.findAll();
		
		List<Prestamo> contUsuario = entityContUsuario(prestamo, usuario, lista);
		
		TblPrestamo newPrestamo = new TblPrestamo(prestamo.getPrestamoId(), libro.get(), usuario.get(), prestamo.getFechaPrestamo());
		
		if(contUsuario.size() < 3) {
			if(libro.get().getEstado().equals("Disponible")) {
				newPrestamo = prestamoRepository.save(newPrestamo);
				
				TblLibro ent = libroRepository.findByLibroId(prestamo.getLibroId());
				ent.setEstado("Prestamo");
				libroRepository.save(ent);
				
				response.setCodigoRespuesta(0);
				response.setMensajeRespuesta("Se agrego Correctamente");
			} else {
				response.setCodigoRespuesta(1);
				response.setMensajeRespuesta("El libro no esta disponible");
			}
		} else {
			response.setCodigoRespuesta(2);
			response.setMensajeRespuesta("El usuario ya posee 3 libros");
		}
		
		return response;
	}
	
	private List<Prestamo> entityPrestamosToDtoList(List<TblPrestamo> lista) {
		List<Prestamo> listadoPrestamos = new ArrayList<>();

		for (TblPrestamo ent : lista) {

			Prestamo prestamo = new Prestamo(ent.getPrestamoId(), ent.getLibro().getLibroId(), 
					ent.getUsuario().getUsuarioId(), ent.getFechaPrestamo());

			listadoPrestamos.add(prestamo);
		}

		return listadoPrestamos;
	}
	
	private List<Prestamo> entityPrestamosUsuarioList(List<TblPrestamo> lista, Integer usuarioId) {
		
		List<Prestamo> listadoPrestamos = new ArrayList<>();

		for (TblPrestamo ent : lista) {

			Prestamo prestamo = new Prestamo(ent.getPrestamoId(), ent.getLibro().getLibroId(), 
					ent.getUsuario().getUsuarioId(), ent.getFechaPrestamo());

			if(prestamo.getUsuarioId().equals(usuarioId)) {
				listadoPrestamos.add(prestamo);
			}
		}

		return listadoPrestamos;
	}
	
	private List<Prestamo> entityContUsuario(Prestamo newPrestamo, Optional<TblUsuario> usuario, List<TblPrestamo> lista) {
		List<Prestamo> UsuarioL = new ArrayList<>();
			
		for (TblPrestamo ent : lista) {

			Prestamo prestamo = new Prestamo(ent.getPrestamoId(), ent.getLibro().getLibroId(), 
					ent.getUsuario().getUsuarioId(), ent.getFechaPrestamo());

			if(prestamo.getUsuarioId().equals(usuario.get().getUsuarioId()) ) {
				UsuarioL.add(newPrestamo);
			}
		}


		return UsuarioL;
	}

}
