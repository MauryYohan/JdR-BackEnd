package com.jdr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdr.entity.Partie;

@Transactional
@Repository
public class PartieDaoImpl implements PartieDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Partie> findAll() {
		String querystring = "SELECT p FROM Partie p ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		@SuppressWarnings("unchecked")
		List<Partie> list = query.getResultList() ;
		return list;
	}

	@Override
	public Partie save(Partie entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Partie entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Partie findByPrimaryKey(Integer id) {
		return em.find(Partie.class, id);
	}

	@Override
	public Partie update(Partie entity) {
		return em.merge(entity);
	}


}
