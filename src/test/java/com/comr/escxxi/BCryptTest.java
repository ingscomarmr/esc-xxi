package com.comr.escxxi;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BCryptTest {

	private static final Log LOG = LogFactory.getLog(BCryptTest.class);
	
	@Autowired(required=true)
	BCryptPasswordEncoder passwordEnconder;
	
	@Test
	public void passwordTest() {
		String pwd = "admin";
		LOG.info("Probando con password  "  + pwd);
		LOG.info("#Password1:" + passwordEnconder.encode(pwd));
		LOG.info("#Password2:" + passwordEnconder.encode(pwd));
		
		assertTrue(passwordEnconder.encode(pwd).length() > 0);
	}
}
