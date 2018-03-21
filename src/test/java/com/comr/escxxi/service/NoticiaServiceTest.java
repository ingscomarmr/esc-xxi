package com.comr.escxxi.service;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comr.escxxi.model.NoticiaModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticiaServiceTest {

	private static final Log LOG = LogFactory.getLog(NoticiaServiceTest.class);
	
	@Autowired
	@Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	@Test
	public void testTop2Noticia() {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DATE, 1);
		LOG.info("#BUSCAR NOTICIA QUE SEAN MENORES A LA FECHA " + c.toString());
		d.setTime(c.getTimeInMillis());
		
		LOG.info("#OBTENIENDO LAS DOS ULTIMAS NOTICIAS SEGUN LA FECHA");
		List<NoticiaModel> nList = noticiaService.findTop2NoticiasHome(d);
		for (NoticiaModel n : nList) {
			LOG.info("#" + n.toString());
		}
		
		assertTrue(nList.size() > 0);
	}
}
