package com.jdr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdr.entity.Utilisateur;

@Transactional
@Repository
public class UtilisateurDaoImpl implements UtilisateurDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Utilisateur> findAll() {
		String querystring = "SELECT u FROM Utilisateur u ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Utilisateur> list = query.getResultList() ;
		return list;
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Utilisateur entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Utilisateur findByPrimaryKey(Integer id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		return em.merge(entity);
	}


}
