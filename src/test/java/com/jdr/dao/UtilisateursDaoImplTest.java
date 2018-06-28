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
	
	@Before
	public void setUp() throws Exception {
		
		Utilisateur u = new Utilisateur();
		u.setMail("jdfkqj@hotmail.fr");
		u.setPseudo("abliblu");
		u.setMotDePasse("4547");
		userDao.save(u);
		
		this.log.info("Creation d'une entite Utilisateur");		
		this.log.info("Creation en cours...");
		this.userDao.save(u);
		this.log.info("Utilisateur Cree : "+u);
		
		
		Utilisateur u1 = new Utilisateur();
		u1.setMail("aaaaaa@hotmail.fr");
		u1.setPseudo("valalia");
		u1.setMotDePasse("4673");
		userDao.save(u1);
		
		this.log.info("Creation d'une entite Utilisateur");		
		this.log.info("Creation en cours...");
		this.userDao.save(u1);
		this.log.info("ActivityType Created:"+u1);
		
		
		Utilisateur u2 = new Utilisateur();
		u2.setMail("bbbbbb@hotmail.fr");
		u2.setPseudo("blablo");
		u2.setMotDePasse("3745");
		userDao.save(u2);
		
		this.log.info("Creation d'une entite Utilisateur");		
		this.log.info("Creation en cours...");
		this.userDao.save(u2);
		this.log.info("ActivityType Created:"+u2);
		
		listUser.add(u);
		listUser.add(u1);
		listUser.add(u2);

	}
	
	@Test
	public void testCountFindAll() {
		Assert.assertTrue(this.userDao.findAll().iterator().hasNext());
		Assert.assertTrue(this.userDao.count(listUser) == 3);
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindIdByPseudo() {
		fail("Not yet implemented");
	}

}
