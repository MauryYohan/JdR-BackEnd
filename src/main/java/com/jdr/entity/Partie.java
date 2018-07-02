package com.jdr.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;
import com.jdr.entity.Views;
import com.jdr.entity.Views.PartieWithUtilisateur;

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
	
	@Column(name="nb_Joueurs_Partie")
	@NotNull
	@JsonView(Views.Common.class)
	public int nbJoueurs;
	
	@Column(name="titrePartie", length=100)
	@NotNull
	@JsonView(Views.Common.class)
	public String titrePartie;
	
	@OneToMany(mappedBy="partie", fetch = FetchType.EAGER)
	@JsonView(Views.PartieWithImage.class)
	private Set<Image> image;
	
	@ManyToOne
	@JsonView(Views.PartieWithUtilisateur.class)
	private Utilisateur userMj;
	
	@ManyToMany(mappedBy="listPartie",fetch = FetchType.EAGER)
	@JsonView(PartieWithUtilisateur.class)
	private List<Utilisateur> utilisateur;
	
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

	public Partie(String imageDeFond, @NotNull int nbJoueurs, @NotNull String titrePartie, Utilisateur userMj, List<Utilisateur> utilisateur,
			Set<Personnage> personnage) {
		super();
		ImageDeFond = imageDeFond;
		this.nbJoueurs = nbJoueurs;
		this.titrePartie = titrePartie;
		this.userMj = userMj;
		this.utilisateur = utilisateur;
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

	/**
	 * @return the image
	 */
	public Set<Image> getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Set<Image> image) {
		this.image = image;
	}

	/**
	 * @return the userMj
	 */
	public Utilisateur getUserMj() {
		return userMj;
	}

	/**
	 * @param userMj the userMj to set
	 */
	public void setUserMj(Utilisateur userMj) {
		this.userMj = userMj;
	}

	/**
	 * @return the utilisateur
	 */
	public List<Utilisateur> getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set<Personnage> getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Set<Personnage> personnage) {
		this.personnage = personnage;
	}
	
}
