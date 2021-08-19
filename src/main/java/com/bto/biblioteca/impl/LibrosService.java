package com.bto.biblioteca.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bto.biblioteca.dto.Libro;
import com.bto.biblioteca.dto.PrestamoResponse;
import com.bto.biblioteca.entity.TblLibro;
import com.bto.biblioteca.interfaz.ILibrosService;
import com.bto.biblioteca.repositoy.*;

@Service
public class LibrosService implements ILibrosService {
	
	@Autowired
	private ILibroRepository libroRepository;
	
	@Autowired
	private IPrestamoRepository prestamoRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<Libro> findAll() {
		
		List<TblLibro> lista = libroRepository.findAll(); // SELECT * FROM PEDIDOS;
		List<Libro> listadoLibros = entityListToDtoList(lista);

		return listadoLibros;
	}

	@Override
	public Libro findById(Integer libroId) {
		Libro result = new Libro();

		Optional<TblLibro> libro = libroRepository.findById(libroId);

		if (libro.isPresent()) {
			result = entityToDto(libro.get());
		}

		return result;
	}

	@Override
	public List<Libro> findByEstado(String estado) {
		
		List<TblLibro> lista = libroRepository.findAll(); // SELECT * FROM PEDIDOS;
		List<Libro> librosEstado = entityListState(estado, lista);

		return librosEstado;
	}

	@Override
	public List<Libro> findByUsuario(String usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrestamoResponse save(Libro libro) {
		
		PrestamoResponse response = new PrestamoResponse();
		
		TblLibro newLibro = new TblLibro(libro.getLibroId(), libro.getTitulo(), libro.getAutor(), libro.getEstado());
		newLibro = libroRepository.save(newLibro);
		
		response.setCodigoRespuesta(0);
		response.setMensajeRespuesta("Se agrego Correctamente");
		
		return response;
	}

	@Override
	public PrestamoResponse update(Libro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrestamoResponse delete(Libro libro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Libro> entityListToDtoList(List<TblLibro> lista) {
		
		List<Libro> listadoLibros = new ArrayList<>();

		for (TblLibro ent : lista) {

			Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());

			listadoLibros.add(libro);
		}

		return listadoLibros;
	}
	
	public Libro entityToDto(TblLibro libroId) {
		
		Libro libro = new Libro(libroId.getLibroId(), libroId.getTitulo(), libroId.getAutor(), libroId.getEstado());

		return libro;
	}
	
	public List<Libro> entityListState(String estado, List<TblLibro> lista) {
		
		List<Libro> listadoLibros = new ArrayList<>();
		
		if(estado == "Prestamo") {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				if(libro.getEstado() == estado) {
					listadoLibros.add(libro);
				}
			}
		} else if(estado == "Inactivo") {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				if(libro.getEstado() == estado) {
					listadoLibros.add(libro);
				}
			}
		} else if(estado == "Restauracion") {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				if(libro.getEstado() == estado) {
					listadoLibros.add(libro);
				}
			}
		} else if(estado == "Disponible") {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				if(libro.getEstado() == estado) {
					listadoLibros.add(libro);
				}
			}
		}
		return listadoLibros;
	}

}
