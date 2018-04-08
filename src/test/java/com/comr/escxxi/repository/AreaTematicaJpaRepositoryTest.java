package com.comr.escxxi.repository;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
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

import com.comr.escxxi.entity.AreaTematica;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaTematicaJpaRepositoryTest {

	private static final Log LOG = LogFactory.getLog(AreaTematicaJpaRepositoryTest.class);
	
	@Autowired
	@Qualifier("areaTematicaJapRepository")
	AreaTematicaJapRepository areaTematicaJapRepository;
	
	@Test
	public void findByNombre() {
		String nombre ="Matematicas";
		LOG.info("#Buscar cursos que su nombre sea igual a:" + nombre);
		List<AreaTematica> aList = areaTematicaJapRepository.findByNombre(nombre);
		for (AreaTematica areaTematica : aList) {
			LOG.info(areaTematica.toString());
		}
		assertTrue(aList.size() > 0);	
	}
	
	@Test
	public void findByNombreLike() {
		String nombre ="%ma%";
		LOG.info("#Buscar cursos que contengan:" + nombre);
		List<AreaTematica> aList = areaTematicaJapRepository.findByNombreLikeOrderByNombre(nombre);
		for (AreaTematica areaTematica : aList) {
			LOG.info(areaTematica.toString());
		}
		assertTrue(aList.size() > 0);	
	}
	
	@Ignore
	@Test
	public void getAllTest() {
		LOG.info("Obtener todoas las areas tematicas");
		List<AreaTematica> aList = areaTematicaJapRepository.findAll();
		for (AreaTematica areaTematica : aList) {
			LOG.info(areaTematica.toString());
		}
		assertTrue(aList.size() > 0);	
	}
	
	@Ignore
	@Test
	public void getSaveTest() {
		LOG.info("Guardar area tematica");
		AreaTematica a = new AreaTematica();
		a.setEliminado(0);
		a.setNombre("TEST AREA TEMANITCA");
		a.setUsuarioIdMod(1);
		a.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
		
		LOG.info("Guardar AT:" + a.toString());
		a = areaTematicaJapRepository.save(a);
		LOG.info("#AT:" + a);
		assertTrue(a.getAreaTematicaId() > 0);
	}
}
