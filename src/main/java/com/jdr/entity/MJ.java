package com.jdr.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

public class MJ extends Utilisateur
{
	//Attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	//constructeur
	public MJ(String mail, String login,String pseudo, String motDePasse) 
	{
		super(mail,login, pseudo, motDePasse);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//Methodes 
	protected void devenirJoueur()
	{
		
	}
	
	protected void creerPartie()
	{
		
	}

	protected void rejoindrePartieMJ()
	{
		
	}
	
	protected void supprimerPartie()
	{
		
	}
	
	protected void modifierContexte()
	{
		
	}
	
	protected void supprimerJoueur()
	{
		
	}
	
	protected void inviterJoueur()
	{
		
	}
	
	protected void designerNouveauMJ()
	{
		
	}
	
	protected void partageImage()
	{
		
	}
	
	protected void creerPersonnage()
	{
		
	}
	
	protected void supprimerPersonnage()
	{
		
	}
	
	protected void modifierPersonnage()
	{
		
	}
	
	protected void accederPersonnages()
	{
		
	}
}
