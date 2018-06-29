package com.jdr.dao;

import static org.junit.Assert.fail;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.jdr.entity.Utilisateur;

import org.junit.Assert; ;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class UtilisateursDaoImplTest {
	
	@Autowired
	UtilisateurDaoImpl userDao;
	List<Utilisateur> listUser;
	
	Log log = LogFactory.getLog(Utilisateur.class);
	long idTested;
	
	@Before
	public void setUp() throws Exception {
		
		Utilisateur u1 = new Utilisateur("jdfkqj@hotmail.fr", "abliblu", "4547");
		Utilisateur u2 = new Utilisateur("aaaaaa@hotmail.fr", "valalia", "4673");
		Utilisateur u3 = new Utilisateur("bbbbbb@hotmail.fr", "blablo", "3745");
		
		userDao.save(u1);
		userDao.save(u2);
		userDao.save(u3);
		
		int id  = u1.getId();
		int id1 = u2.getId();
		int id2 = u3.getId();

		Utilisateur ubdd1 = userDao.findByPrimaryKey(id);
		Assert.assertNotNull(ubdd1);
		Assert.assertTrue(ubdd1.getMail().equals("jdfkqj@hotmail.fr"));
		
		Utilisateur ubdd2 = userDao.findByPrimaryKey(id1);
		Assert.assertNotNull(ubdd2);
		Assert.assertTrue(ubdd2.getMail().equals("aaaaaa@hotmail.fr"));
		
		Utilisateur ubdd3 = userDao.findByPrimaryKey(id2);
		Assert.assertNotNull(ubdd3);
		Assert.assertTrue(ubdd3.getMail().equals("bbbbbb@hotmail.fr"));
	}
	
	@Test
	public void testFindAll() {
		listUser = userDao.findAll();
		Assert.assertEquals(3, listUser.size());
	}

	@Test
	public void testSave() {
		Utilisateur u3 = new Utilisateur("cccccc@hotmail.fr", "coucou", "3429");
		Assert.assertNotNull(userDao.save(u3));
		Assert.assertEquals("cccccc@hotmail.fr", u3.getMail());
		Assert.assertEquals("coucou", u3.getPseudo());
		Assert.assertEquals("3429", u3.getMotDePasse());
	}
}
