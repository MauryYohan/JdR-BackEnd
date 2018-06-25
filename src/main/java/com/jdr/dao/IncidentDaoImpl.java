package com.jdr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdr.entity.Incident;

@Transactional
@Repository
public class IncidentDaoImpl implements IncidentDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Incident> findAll() {
		String querystring = "SELECT i FROM Incident i ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Incident> list = query.getResultList() ;
		return list;
	}

	@Override
	public Incident save(Incident entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Incident entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Incident findByPrimaryKey(Integer id) {
		return em.find(Incident.class, id);
	}

	@Override
	public Incident update(Incident entity) {
		return em.merge(entity);
	}
}
