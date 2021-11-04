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

	//El siguiente metodo se llevo a cabo en la API prestamos
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
		
		/*
		 * PrestamoResponse response = new PrestamoResponse(); TblLibro ent =
		 * libroRepository.findByLibroId(libro.getLibroId());
		 * 
		 * if(ent != null) { //TblPedido ent = entity.get();
		 * ent.setEstado(libro.getEstado()); libroRepository.save(ent);
		 * response.setCodigoRespuesta(0);
		 * response.setMensajeRespuesta("El libro ha sido actualizado");
		 * 
		 * }else { response.setCodigoRespuesta(1);
		 * response.setMensajeRespuesta("El libro no existe");
		 *
		*}
	 */
	
		return null;
		
	}

	@Override
	public PrestamoResponse delete(Integer libroId) {

		PrestamoResponse response = new PrestamoResponse();
		libroRepository.deleteById(libroId);
		
		response.setCodigoRespuesta(0);
		response.setMensajeRespuesta("Se elimino Correctamente");

		return response;
	}
	
	public List<Libro> entityListToDtoList(List<TblLibro> lista) {
		
		List<Libro> listadoLibros = new ArrayList<>();

		for (TblLibro ent : lista) {

			Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());

			listadoLibros.add(libro);
		}

		return listadoLibros;
	}
	
	public Libro entityToDto(TblLibro libro) {
		
		Libro lib = new Libro(libro.getLibroId(), libro.getTitulo(), libro.getAutor(), libro.getEstado());

		return lib;
	}
	
	public List<Libro> entityListState(String estado, List<TblLibro> lista) {
		
		List<Libro> listadoLibros = new ArrayList<>();
		
		if(estado.toUpperCase().equals("Prestamo".toUpperCase())) {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				if(libro.getEstado().equals(estado)) {
					listadoLibros.add(libro);
				}
			}
		} else if(estado.equals("Inactivo")) {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				if(libro.getEstado().equals(estado)) {
					listadoLibros.add(libro);
				}
			}
		}  else if(estado.equals("Restauracion")) {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				if(libro.getEstado().equals(estado)) {
					listadoLibros.add(libro);
				}
			}
		}  else if(estado.equals("Disponible")) {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				if(libro.getEstado().equals(estado)) {
					listadoLibros.add(libro);
				}
			}
		} else {
			for (TblLibro ent : lista) {

				Libro libro = new Libro(ent.getLibroId(), ent.getTitulo(), ent.getAutor(), ent.getEstado());
				
				listadoLibros.add(libro);
			}
		}
		return listadoLibros;
	}

}
