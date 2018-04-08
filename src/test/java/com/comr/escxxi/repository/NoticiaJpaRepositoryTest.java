package com.comr.escxxi.repository;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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

import com.comr.escxxi.entity.Noticia;
import com.comr.escxxi.entity.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticiaJpaRepositoryTest {

	private static final Log LOG = LogFactory.getLog(NoticiaJpaRepositoryTest.class);
	
	@Autowired
	@Qualifier("noticiaJpaRepository")
	NoticiaJpaRepository noticiaJpaRepository;

	@Ignore
	@Test
	public void saveNoticia() {
		try {
			Noticia n = new Noticia();
			n.setTitulo("desfile el 16 de septiembre");
			n.setContenido("noticia de prueba por favor omitir");
			n.setDesactivo(0);
			n.setEliminado(0);
			n.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
			n.setUsuario(new Usuario(1));
			n.setFechaVigenciaInicio(new Date(2018, 02, 01));
			n.setFechaVigenciaFin(new Date(2018, 02, 28));
			
			LOG.info("GUARDAR NOTICIA:" + n.toString());
			
			n = noticiaJpaRepository.save(n);
			
			LOG.info("NOTICIA GUARDADA:" + n.toString());
			assertTrue(n.getNoticiaId() > 0);
			
		}catch (Exception e) {
			LOG.error(e.getMessage());
			throw e;
		}
		
		
	}
	
	@Test
	public void testTop3NoticiasHome() {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 1);
		LOG.info("#BUSCAR NOTICIA QUE SEAN MENORES A LA FECHA " + c.toString());
		d.setTime(c.getTimeInMillis());
		
		LOG.info("#OBTENIENDO LAS DOS ULTIMAS NOTICIAS SEGUN LA FECHA");
		List<Noticia> nList = noticiaJpaRepository.findTop2ByFechaVigenciaFinLessThanOrderByFechaVigenciaFinDesc(d);
		for (Noticia n : nList) {
			LOG.info("#" + n.toString());
		}
		
		assertTrue(nList.size() > 0);
	}
	
	@Ignore
	@Test
	public void testFindTop10Noticia() {
		LOG.info("TEST findTop10ByTituloLike");
		List<Noticia> nList = noticiaJpaRepository.findTop10ByTituloLikeOrderByNoticiaIdDesc("%a%");
		LOG.info("# DE NOTICIAS findTop10ByTituloLike=" + nList.size());
		for (Noticia noticia : nList) {
			LOG.info("#" + noticia.toString());
		}
		assertTrue(nList.size() == 10);
		
	}
}
