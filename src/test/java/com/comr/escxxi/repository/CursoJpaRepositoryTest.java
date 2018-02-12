package com.comr.escxxi.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comr.escxxi.entity.Curso;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoJpaRepositoryTest {

	private static final Log LOG = LogFactory.getLog(CursoJpaRepositoryTest.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	CursoJpaRepository cursoJpaRepository;

	@Test
	public void getCursoByIdTest() {
		int id = 1;
		LOG.info("#Buscar curso por id:" + id);
		Curso c = cursoJpaRepository.findByCursoId(id);
		LOG.info("#findByAsignaturaOrderByAsignatura cursos encontrados:" + c.toString());
			
		assertTrue(c.getCursoId()  >= 0);
	}
		
	@Test	
	public void getCursoByNombreTest() {
		String n = "c++";
		LOG.info("#Buscar curso por asignatura:" + n);
		List<Curso> cursoList = cursoJpaRepository.findByAsignaturaOrderByAsignatura(n);
		LOG.info("#findByAsignaturaOrderByAsignatura cursos encontrados:" + cursoList.size());
		for (Curso c : cursoList) {
			LOG.info(c);
		}		
		assertTrue(cursoList.size()  >= 0);
	}
}
