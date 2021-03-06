package com.jdr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdr.entity.Personnage;

@Transactional
@Repository
public class PersonnageDaoImpl implements PersonnageDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Personnage> findAll() {
		String querystring = "SELECT p FROM Personnage p ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		@SuppressWarnings("unchecked")
		List<Personnage> list = query.getResultList() ;
		return list;
	}

	@Override
	public Personnage save(Personnage entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Personnage entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Personnage findByPrimaryKey(Integer id) {
		return em.find(Personnage.class, id);
	}

	@Override
	public Personnage update(Personnage entity) {
		return em.merge(entity);
	}


}
