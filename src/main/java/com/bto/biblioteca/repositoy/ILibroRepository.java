package com.bto.biblioteca.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bto.biblioteca.entity.TblLibro;

public interface ILibroRepository extends JpaRepository<TblLibro, Integer> {

	public TblLibro findByLibroId(Integer libroId); 
	
}
