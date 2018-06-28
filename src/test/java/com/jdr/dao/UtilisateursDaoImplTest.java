package com.jdr.dao;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.jdr.entity.Utilisateur;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class UtilisateursDaoImplTest {
	
	@Autowired
	UtilisateurDaoImpl userDao;
	
	Utilisateur u;
	Utilisateur u1;
	Utilisateur u2;
	
	@Before
	public void setUp() throws Exception {
		/* First Arguments = mail
		 * Second Args = login
		 * Third Args = pseudo		 
		 * Fourth Args = motDePasse
		 * string *4
		 */
		u = new Utilisateur("jdfkqj@hotmail.fr","Jaja", "abliblu", "4547");
		u1 = new Utilisateur("aaaaaa@hotmail.fr","Baba", "valalia", "4673");
		u2 = new Utilisateur("bbbbbb@hotmail.fr","Lala", "blablo", "3745");
		
		userDao.save(u);
		userDao.save(u1);
		userDao.save(u2);
	}
	
	@Test
	public void testFindAll() {
		fail("Not yet implemented");
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
	public void testFindIdByLogin() {
		fail("Not yet implemented");
	}

}
