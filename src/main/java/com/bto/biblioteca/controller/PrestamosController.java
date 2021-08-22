package com.bto.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bto.biblioteca.dto.Prestamo;
import com.bto.biblioteca.dto.PrestamoResponse;
import com.bto.biblioteca.interfaz.IPrestamosService;

@RestController
public class PrestamosController {
	
	@Autowired
	private IPrestamosService prestamoService;

	@GetMapping(value="/Prestamos", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Prestamo> getPrestamo(){
		List<Prestamo> listado = prestamoService.findAll();
		return listado;
	}
	
	@GetMapping(value="/Prestamos/Fecha/{fechaPrestamo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Prestamo> getFechaPrestamo(@PathVariable(name="fechaPrestamo") String fechaPrestamo){
		List<Prestamo> listado = prestamoService.findByFechaPrestamo(fechaPrestamo);
		return listado;
	}
	
	@GetMapping(value="/Prestamos/Usuario/{usuarioId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Prestamo> getUsuarioId(@PathVariable(name="usuarioId") Integer usuarioId){
		List<Prestamo> listado = prestamoService.findByUsuarioId(usuarioId);
		return listado;
	}
	
	@PostMapping(value="/Prestamos", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PrestamoResponse> savePrestamo(@RequestBody Prestamo prestamo) {
		
		PrestamoResponse response = prestamoService.save(prestamo);
		
		if(response.getCodigoRespuesta() == 0)
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);		

	}
}
