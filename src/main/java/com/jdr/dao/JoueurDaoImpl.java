package com.jdr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdr.entity.Joueur;

@Transactional
@Repository
public class JoueurDaoImpl implements JoueurDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Joueur> findAll() {
		String querystring = "SELECT j FROM Joueur j ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Joueur> list = query.getResultList() ;
		return list;
	}

	@Override
	public Joueur save(Joueur entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Joueur entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Joueur findByPrimaryKey(Integer id) {
		return em.find(Joueur.class, id);
	}

	@Override
	public Joueur update(Joueur entity) {
		return em.merge(entity);
	}


}
