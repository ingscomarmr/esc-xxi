package com.comr.escxxi.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comr.escxxi.entity.Noticia;
import com.comr.escxxi.model.BootGridModel;
import com.querydsl.core.QueryResults;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticiaQueryDSLRepositoryTest {

	private static final Log LOG = LogFactory.getLog(NoticiaJpaRepositoryTest.class);

	@Autowired
	@Qualifier("noticiaQueryDSLRepository")
	NoticiaQueryDSLRepository noticiaQueryDSLRepository;
	
	
	@Test
	public void TestNoticiaFindByNombre() {				
		
		QueryResults<Noticia> query= noticiaQueryDSLRepository.findByTituloLikeOrContenidoLikeOrderBy("%", 5, 5);
		
		List<Noticia> nList = query.getResults();
		for (Noticia noticia : nList) {
			LOG.info("#" + noticia.toString());
		}
		
		assertTrue(nList.size() > 0 );
	}
}
