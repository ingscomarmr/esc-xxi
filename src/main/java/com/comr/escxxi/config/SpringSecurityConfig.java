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

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {

		/*
		 * forma 2 UserBuilder user = User.withDefaultPasswordEncoder();
		 * build.inMemoryAuthentication()
		 * .withUser(user.username("admin").password("12345").roles(
		 * "ADMIN,PROFESOR,ALUMNO,TUTOR"))
		 * .withUser(user.username("profe").password("12345").roles("PROFESOR"))
		 * .withUser(user.username("alumno").password("12345").roles("ALUMNO"))
		 * .withUser(user.username("tutor").password("12345").roles("TUTOR"));
		 */
		
		build.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
				.withUser("admin").password("12345").roles("ADMIN","PROFESOR","ALUMNO","TUTOR").and()
				.withUser("profe").password("12345").roles("PROFESOR").and()
				.withUser("alumno").password("12345").roles("ALUMNO").and()
				.withUser("tutor").password("12345").roles("TUTOR");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/", "/home", "/about", "/noticias", "/noticia/**", "/getnoticias", "/teacher/**",
								"/img/**", "/css/**", "/js/**", "/font-awesome/**").permitAll()
		.antMatchers("/teacher/**").hasAnyRole("ADMIN","PROFESOR")
		.antMatchers("/alumno/**").hasAnyRole("ADMIN","ALUMNO")
		.antMatchers("/advisor/**").hasAnyRole("ADMIN","TUTOR")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
		
		//primera forma
		//http.csrf().disable().authorizeRequests()
		//		.antMatchers("/", "/home", "/about", "/noticias", "/noticia/**", "/getnoticias", "/teacher/**",
		//				"/img/**", "/css/**", "/js/**", "/font-awesome/**")
		//		.permitAll().antMatchers("/admin/**").hasAnyRole("ADMIN").antMatchers("/user/**").hasAnyRole("USER")
		//		.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
		//		.permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

}
