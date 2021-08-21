package com.bto.biblioteca.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestamo> findByFechaPrestamo(String fechaPrestamo) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha = null;
		
		try {
			fecha = format.parse(fechaPrestamo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		List<TblPrestamo> lista = prestamoRepository.findByFechaPrestamo(fecha);
		
		List<Prestamo> listadoPrestamos= entityPrestamosToDtoList(lista);

		return listadoPrestamos;
	}

	@Override
	public PrestamoResponse save(Prestamo prestamo) {
		PrestamoResponse response = new PrestamoResponse();
		
		Optional<TblLibro> libro = libroRepository.findById(prestamo.getLibroId()); 
		Optional<TblUsuario> usuario = usuarioRepository.findById(prestamo.getUsuarioId());
		
		TblPrestamo newPrestamo = new TblPrestamo(prestamo.getPrestamoId(), libro.get(), usuario.get(), prestamo.getFechaPrestamo());
		
		newPrestamo = prestamoRepository.save(newPrestamo);
		
		response.setCodigoRespuesta(0);
		response.setMensajeRespuesta("Se agrego Correctamente");
		
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

}
