package com.jdr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Joueur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Joueur extends Utilisateur 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	public Joueur() {}

	public Joueur(String mail, String login, String pseudo, String motDePasse) {
		super(mail, login, pseudo, motDePasse);
	}

	protected void devenirMJ() 
	{
		this.devenirMJ();
	}
	
	protected void rejoindrePartie() 
	{
		this.rejoindrePartie();
	}
	
	protected void quitterPartie()
	{
		
	}
	
	protected void  sinscrirePartie()
	{
		
	}
	
	protected void creerSonPersonnage()
	{
		
	}
	
	protected void quitterLaPartieEncours()
	{
		
	}
	
	protected void accederASaFichePerso()
	{
		
	}
	
	protected void modifierSaFichePerso()
	{
		
	}
	
	protected void supprimerSaFichePerso()
	{
		
	}
}
