package com.bto.biblioteca.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bto.biblioteca.entity.TblPrestamo;

public interface IPrestamoRepository extends JpaRepository<TblPrestamo, Integer> {

}
