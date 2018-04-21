package com.comr.escxxi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comr.escxxi.entity.PermisoUsuario;
import com.comr.escxxi.entity.Usuario;
import com.comr.escxxi.repository.UsuarioJpaRepository;


@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	private Logger log = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Autowired
	UsuarioJpaRepository usuarioJpaRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("buscar el usuario " + username);
		//obtenemos el usuario
		Usuario user = usuarioJpaRepository.findByEmail(username);
		
		if(user != null)
			log.info("Usuario encontrado " + username);
		else {
			log.info("No existe el usuario:" + username + " en el sistema!");
			throw new UsernameNotFoundException("No existe el usuario:" + username + " en el sistema!");
		}
			
		
		log.info("Obteniendo los permisos");
		//vamos a registrar los roles que tiene
		List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();
		
		//obtenemos los roles y los registramos en la lista
		for (PermisoUsuario rol : user.getPermisoUsuarios()) {
			authoritiesList.add(new SimpleGrantedAuthority(rol.getRole()));
		}
		
		if (authoritiesList.isEmpty()){
			log.info("El usuario:" + username + " no tiene roles!");
			throw new UsernameNotFoundException("El usuario:" + username + " no tiene roles!");
		}
		
		log.info("retornando el usuario logeado con su password");
		return new User(username, user.getPwd(), authoritiesList);
	}

}
