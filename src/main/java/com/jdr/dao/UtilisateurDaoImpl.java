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
		int numRow = count(list);
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

	@Override
	public Utilisateur findIdByPseudo(String pseudo) {
		Utilisateur user = em.find(Utilisateur.class, pseudo);
		return user;
	}

	public int count(List<Utilisateur> list) {
		int compteur = 0;
		for (Utilisateur user : list) {
		    compteur += 1;
		}
		return compteur;
	}

	public Utilisateur findByPrimaryKey(long id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public Utilisateur findIdByMail(String mail) {
		Utilisateur user = em.find(Utilisateur.class, mail);
		return user;
	}

}
