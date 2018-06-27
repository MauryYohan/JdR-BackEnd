package com.jdr.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="MJ")
public class MJ extends Utilisateur
{
//Attributs-------------------------------------------------------------------
	
	@OneToMany(mappedBy="mj", fetch = FetchType.EAGER)
	@JsonView(Views.MJWithPartie.class)
	private Set<Partie> partie;
	
//constructeur-------------------------------------------------------------------
	
	public MJ() {}
	
	public MJ(String mail, String login,String pseudo, String motDePasse) 
	{
		super(mail,login, pseudo, motDePasse);
	}

	public Set<Partie> getPartie() {
		return partie;
	}

	public void setPartie(Set<Partie> partie) {
		this.partie = partie;
	}

//Methodes -------------------------------------------------------------------
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
