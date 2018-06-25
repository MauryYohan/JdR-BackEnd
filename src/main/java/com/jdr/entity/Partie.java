package com.jdr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;
import com.jdr.entity.Views;

@Entity
@Table(name="Partie")
public class Partie 
{
	//Attributs
	
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
	
	@Column(name="nbJoueurs_Partie")
	@NotNull
	@JsonView(Views.Common.class)
	public String titrePartie;

	//Constructeurs
	public Partie() {}
	
	public Partie(String imageDeFond, @NotNull int nbJoueurs, @NotNull String titrePartie) {
		ImageDeFond = null;
		this.nbJoueurs = nbJoueurs;
		this.titrePartie = titrePartie;
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
	
	
	

}
