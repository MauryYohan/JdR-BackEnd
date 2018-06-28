package com.jdr.dao;

import com.jdr.entity.Utilisateur;

public interface UtilisateurDao extends GenericDao<Utilisateur, Integer>{

	Utilisateur findIdByPseudo(String pseudo);
}
