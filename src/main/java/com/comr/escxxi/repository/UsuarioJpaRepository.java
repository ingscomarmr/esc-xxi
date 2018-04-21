package com.comr.escxxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comr.escxxi.entity.Usuario;

@Repository("usuarioJpaRepository")
public interface UsuarioJpaRepository extends JpaRepository<Usuario, Integer>{

	public Usuario findByEmail(String email);
}
