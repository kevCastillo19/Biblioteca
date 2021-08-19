package com.bto.biblioteca.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bto.biblioteca.entity.TblUsuario;

public interface IUsuarioRepository extends JpaRepository<TblUsuario, Integer> {

}
