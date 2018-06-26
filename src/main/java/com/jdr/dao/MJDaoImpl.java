package com.jdr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdr.entity.MJ;

@Transactional
@Repository
public class MJDaoImpl implements MJDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<MJ> findAll() {
		String querystring = "SELECT mj FROM MJ mj ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<MJ> list = query.getResultList() ;
		return list;
	}

	@Override
	public MJ save(MJ entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(MJ entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public MJ findByPrimaryKey(Integer id) {
		return em.find(MJ.class, id);
	}

	@Override
	public MJ update(MJ entity) {
		return em.merge(entity);
	}


}
