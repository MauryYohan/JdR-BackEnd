package com.jdr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Personnage")
public class Personnage {
	
//Attributs-------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="nom_Personnage", length=20)
	@JsonView(Views.Common.class)
	@NotNull
	public String nom;
	
	@Column(name="classe_Personnage", length=20)
	@JsonView(Views.Common.class)
	@NotNull
	public String classe;
	
	@Column(name="pv_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public int pv;
	
	@Column(name="puissance_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public int puissance; //puissance = force car force pose un problème dans eclipse
	
	@Column(name="defense__Personnage")
	@NotNull
	@JsonView(Views.Common.class)
	public int defense;
	
	@Column(name="esprit_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public int esprit;
	
	@Column(name="intelligence_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public int intelligence;
	
	@Column(name="init_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public int init;
	
	@Column(name="equipement_Personnage", length=4000)
	@JsonView(Views.Common.class)
	public String equipement;
	
	@Column(name="inventaire_Personnage", length=4000)
	@JsonView(Views.Common.class)
	public String inventaire;
	
	@Column(name="background_Personnage", length=4000)
	@JsonView(Views.Common.class)
	public String background;
	
	@Column(name="race_Personnage", length=20)
	@JsonView(Views.Common.class)
	@NotNull
	public String race;
	
	@Column(name="sexe_Personnage", length=20)
	@JsonView(Views.Common.class)
	@NotNull
	public String sexe;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonView(Views.PersonnageWithPartie.class)
	private Partie partie;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonView(Views.PersonnageWithJoueur.class)
	private Joueur joueurs;

//Constructeurs-------------------------------------------------------------------
	public Personnage() {}
	
	public Personnage(@NotNull String nom, @NotNull String classe, @NotNull int pv, @NotNull int puissance,
			@NotNull int defense, @NotNull int esprit, @NotNull int intelligence, @NotNull int init, String equipement,
			String inventaire, String background, @NotNull String race, @NotNull String sexe, Partie partie, Joueur joueurs) {
		super();
		this.nom = nom;
		this.classe = classe;
		this.pv = pv;
		this.puissance = puissance;
		this.defense = defense;
		this.esprit = esprit;
		this.intelligence = intelligence;
		this.init = init;
		this.equipement = equipement;
		this.inventaire = inventaire;
		this.background = background;
		this.race = race;
		this.sexe = sexe;
		this.partie = partie;
		this.joueurs=joueurs;
	}

	
//Getters et setters-------------------------------------------------------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getEsprit() {
		return esprit;
	}

	public void setEsprit(int esprit) {
		this.esprit = esprit;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getInit() {
		return init;
	}

	public void setInit(int init) {
		this.init = init;
	}

	public String getEquipement() {
		return equipement;
	}

	public void setEquipement(String equipement) {
		this.equipement = equipement;
	}

	public String getInventaire() {
		return inventaire;
	}

	public void setInventaire(String inventaire) {
		this.inventaire = inventaire;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Joueur getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Joueur joueurs) {
		this.joueurs = joueurs;
	}

	
}
