package com.bto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bto.biblioteca.dto.PrestamoResponse;
import com.bto.biblioteca.dto.Libro;
import com.bto.biblioteca.interfaz.ILibrosService;

@RestController
public class LibrosController {

	@Autowired
	private ILibrosService libroService;
	
	@GetMapping(value="/Libros", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Libro> getLibro(){
		List<Libro> listado = libroService.findAll();
		return listado;
	}
	
	@GetMapping(value="/Libros/{libroId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Libro getLibroId(@PathVariable(name="libroId") Integer libroId){
		Libro libro = libroService.findById(libroId);
		return libro;
	}
	
	@GetMapping(value="/Libros/estado/{estado}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Libro> getLibro(@PathVariable(name="estado") String estado){
		List<Libro> listado = libroService.findByEstado(estado);
		return listado;
	}
	
	@PostMapping(value="/Libros", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PrestamoResponse> saveLibro(@RequestBody Libro libro) {
		
		PrestamoResponse response = libroService.save(libro);
		
		if(response.getCodigoRespuesta() == 0)
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);		

	}
	
	@PutMapping(value="/Libros", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PrestamoResponse> updatePedido(@RequestBody Libro libro) {
		
		PrestamoResponse response = libroService.update(libro);
		
		if(response.getCodigoRespuesta() == 0)
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);		
	}
	
	@DeleteMapping(value="/Libros/{libroId}")
	public ResponseEntity<PrestamoResponse> deleteLibro(@PathVariable(name="libroId") Integer libroId) {
		PrestamoResponse response = libroService.delete(libroId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	
}
