package com.jdr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Personnage")
public class Personnage {
	
	//Attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="nom_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public String nom;
	
	@Column(name="classe_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public String classe;
	
	@Column(name="pv_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public int pv;
	
	@Column(name="force_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public int force;
	
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
	
	@Column(name="equipement_Personnage")
	@JsonView(Views.Common.class)
	public String equipement;
	
	@Column(name="inventaire_Personnage")
	@JsonView(Views.Common.class)
	public String inventaire;
	
	@Column(name="background_Personnage")
	@JsonView(Views.Common.class)
	public String background;
	
	@Column(name="race_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public String race;
	
	@Column(name="sexe_Personnage")
	@JsonView(Views.Common.class)
	@NotNull
	public String sexe;

}
