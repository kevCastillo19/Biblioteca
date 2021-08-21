package com.bto.biblioteca.repositoy;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bto.biblioteca.entity.TblPrestamo;

public interface IPrestamoRepository extends JpaRepository<TblPrestamo, Integer> {

	List<TblPrestamo> findByFechaPrestamo(Date fecha);

}
