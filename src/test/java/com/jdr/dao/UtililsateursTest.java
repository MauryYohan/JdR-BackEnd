package com.jdr.dao;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.jdr.dao.UtilisateurDaoImpl;
import com.jdr.entity.Utilisateur;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class UtililsateursTest {

	@Autowired
	UtilisateurDaoImpl userDao;
	
	Log log = LogFactory.getLog(Utilisateur.class);
	long idTested;
	/*
	@Test
	public void populate(){
		Utilisateur u = new Utilisateur("jdfkqj@hotmail.fr","jjjjj", "kkkk", "1234");
		Utilisateur u1 = new Utilisateur("aaaaaa@hotmail.fr","aaaa", "vvvvv", "0000");
		Utilisateur u2 = new Utilisateur("bbbbbb@hotmail.fr","bbbbb", "bbb", "123");
		
		userDao.save(u);
		userDao.save(u1);
		userDao.save(u2);
		
		int id = u.getId();
		
		Utilisateur ubdd = userDao.findByPrimaryKey(id);
		Assert.assertNotNull(ubdd);
		Assert.assertTrue(ubdd.getMail().equals("jdfkqj@hotmail.fr"));
	*/
	}