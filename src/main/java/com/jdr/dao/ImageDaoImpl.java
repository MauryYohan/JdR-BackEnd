package com.jdr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdr.entity.Image;

@Transactional
@Repository
public class ImageDaoImpl implements ImageDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Image> findAll() {
		String querystring = "SELECT j FROM Image j ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		@SuppressWarnings("unchecked")
		List<Image> list = query.getResultList() ;
		return list;
	}

	@Override
	public Image save(Image entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Image entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Image findByPrimaryKey(Integer id) {
		return em.find(Image.class, id);
	}

	@Override
	public Image update(Image entity) {
		return em.merge(entity);
	}


}
