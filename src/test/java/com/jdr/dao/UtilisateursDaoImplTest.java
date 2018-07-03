package com.jdr.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	
	@Test
<<<<<<< Updated upstream
	public void testFindIdByPseudo() {
		Utilisateur u1 = userDao.findIdByPseudo("baz");
=======
	public void testFindIdByMail() {
		Utilisateur u1 = userDao.findIdByMail("mauryyohan1@gmail.com");
>>>>>>> Stashed changes
		Assert.assertEquals(1, u1.getId());
	}
	
	@Test
	public void testFindByPrimaryKey() {
		Utilisateur u1 = userDao.findByPrimaryKey(1);
		Assert.assertEquals("baz", u1.getPseudo());
	}
	
	@Test
	public void testFindAll() {
		listUser = userDao.findAll();
		Assert.assertNotNull(listUser);
	}

	@Test
	public void testSave() {
		Utilisateur u3 = new Utilisateur("cccccc@hotmail.fr", "coucou", "3429");
		Assert.assertNotNull(userDao.save(u3));
		Assert.assertEquals("cccccc@hotmail.fr", u3.getMail());
		Assert.assertEquals("coucou", u3.getPseudo());
		Assert.assertEquals("3429", u3.getMotDePasse());
	}
	
	@Test
	public void test
}
