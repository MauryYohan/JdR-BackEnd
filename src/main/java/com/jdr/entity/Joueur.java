package com.jdr.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Joueur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Joueur extends Utilisateur 
{
//Attributs------------------------------------------------------------------
	
	@ManyToMany(fetch = FetchType.LAZY) // dans ensemble car c'est le proprio et non le detenu.
	@JoinTable(name="Joueur_Partie",
	joinColumns=@JoinColumn(name="Joueur_id"),
	inverseJoinColumns=@JoinColumn(name="Partie_id"))
	@JsonView(Views.JoueurWithPartie.class)
	private List<Partie> listPartie; 
	
	@OneToMany(mappedBy="joueurs", fetch = FetchType.EAGER)
	@JsonView(Views.JoueurWithPersonnage.class)
	private Set<Personnage> personnage;
	
//Constructeur-------------------------------------------------------------------
	public Joueur() {}

	public Joueur(String mail, String pseudo, String motDePasse) {
		super(mail, pseudo, motDePasse);
	}
	
	public Joueur(String mail, String pseudo, String motDePasse, List<Partie> partie, Set<Personnage> personnage) {
		super(mail, pseudo, motDePasse);
		this.listPartie=partie;
		this.personnage=personnage;
	}

	public List<Partie> getListPartie() {
		return listPartie;
	}

	public void setListPartie(List<Partie> listPartie) {
		this.listPartie = listPartie;
	}
	
	public Set<Personnage> getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Set<Personnage> personnage) {
		this.personnage = personnage;
	}

	//Méthodes-------------------------------------------------------------------
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
