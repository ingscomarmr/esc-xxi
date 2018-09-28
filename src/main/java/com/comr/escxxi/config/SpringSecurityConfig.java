package com.comr.escxxi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.comr.escxxi.model.Roles;
import com.comr.escxxi.service.impl.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired(required=true)
	BCryptPasswordEncoder passwordEnconder;
	
	@Autowired
	JpaUserDetailsService jpaUserDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		
		/* ya no sera necesario esta autentificación porque la pondremos desde base de datos
		build.inMemoryAuthentication().passwordEncoder(passwordEnconder)
				.withUser("admin").password(passwordEnconder.encode("admin")).roles(Roles.ADMIN.toString(),Roles.TEACHER.toString(), Roles.STUDENT.toString(),Roles.ADVISOR.toString()).and()
				.withUser("profe").password(passwordEnconder.encode("12345")).roles(Roles.TEACHER.toString()).and()
				.withUser("alumno").password(passwordEnconder.encode("12345")).roles(Roles.STUDENT.toString()).and()
				.withUser("tutor").password(passwordEnconder.encode("12345")).roles(Roles.ADVISOR.toString());

		*/
		
		build.userDetailsService(jpaUserDetailsService).passwordEncoder(passwordEnconder);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/", "/home", "/about", "/noticias**", "/noticia/**", "/api/**", "/teacher/**",
								"/img/**", "/css/**", "/js/**", "/font-awesome/**").permitAll()
		.antMatchers("/teacher/**").hasAnyRole(Roles.TEACHER.toString(),Roles.ADMIN.toString())
		.antMatchers("/student/**").hasAnyRole(Roles.ADMIN.toString(),Roles.STUDENT.toString())
		.antMatchers("/advisor/**").hasAnyRole(Roles.ADMIN.toString(),Roles.ADVISOR.toString())
		.anyRequest().authenticated()
		.and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/defaultForLogin/")
		.permitAll().and().logout().permitAll();
				
	}

}
