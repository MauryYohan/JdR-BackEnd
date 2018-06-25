package com.jdr.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;
import com.jdr.entity.Views;

@Entity
@Table(name="Partie")
public class Partie 
{
//Attributs-------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="imageFond_Partie")
	@JsonView(Views.Common.class)
	public String ImageDeFond;
	
	@Column(name="nbJoueurs_Partie")
	@NotNull
	@JsonView(Views.Common.class)
	public int nbJoueurs;
	
	@Column(name="nbJoueurs_Partie", length=100)
	@NotNull
	@JsonView(Views.Common.class)
	public String titrePartie;
	
	/*@OneToMany(mappedBy="partie", fetch = FetchType.EAGER)
	@JsonView(Views..class)
	private Set<Image> image;*/
	
	@OneToOne
	@JoinColumn(name="id_MJ")
	@JsonView(Views.PartieWithMJ.class)
	private MJ mj;
	
	@ManyToMany(mappedBy="listPartie")
	@JsonView(Views.JoueurWithPartie.class)
	private List<Joueur> joueur;
	
	@OneToMany(mappedBy="partie", fetch = FetchType.EAGER)
	@JsonView(Views.PartieWithPersonnage.class)
	private Set<Personnage> personnage;
	

//Constructeurs-------------------------------------------------------------------
	public Partie() {}
	
	public Partie(String imageDeFond, @NotNull int nbJoueurs, @NotNull String titrePartie) {
		ImageDeFond = null;
		this.nbJoueurs = nbJoueurs;
		this.titrePartie = titrePartie;
	}

	public Partie(String imageDeFond, @NotNull int nbJoueurs, @NotNull String titrePartie, MJ mj, List<Joueur> joueur,
			Set<Personnage> personnage) {
		super();
		ImageDeFond = imageDeFond;
		this.nbJoueurs = nbJoueurs;
		this.titrePartie = titrePartie;
		this.mj = mj;
		this.joueur = joueur;
		this.personnage = personnage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageDeFond() {
		return ImageDeFond;
	}

	public void setImageDeFond(String imageDeFond) {
		ImageDeFond = imageDeFond;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public String getTitrePartie() {
		return titrePartie;
	}

	public void setTitrePartie(String titrePartie) {
		this.titrePartie = titrePartie;
	}

	public MJ getMj() {
		return mj;
	}

	public void setMj(MJ mj) {
		this.mj = mj;
	}

	public List<Joueur> getJoueur() {
		return joueur;
	}

	public void setJoueur(List<Joueur> joueur) {
		this.joueur = joueur;
	}

	public Set<Personnage> getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Set<Personnage> personnage) {
		this.personnage = personnage;
	}
	
}
