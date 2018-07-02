package com.jdr.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.jdr.entity.Views;
import com.jdr.entity.Views.UtilisateurWithPartie;

@Entity
@Table(name="Utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur 
{
//Attributs-------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	@Column(name="id_utilisateur")
	private int id;
	
	/*
	@Column(name="uid_utilisateur", length=28)
	@JsonView(Views.Common.class)
	protected String uid;
	*/
	
	@Column(name="mail_utilisateur", length=75)
	@JsonView(Views.Common.class)
	protected String mail;
	
	@Column(name="motDePasse_utilisateur", length=30)
	@JsonView(Views.Common.class)
	protected String motDePasse;
	
	@Column(name="avatar_utilisateur", length=1000)
	@JsonView(Views.Common.class)
	public String avatar;
	
	@Column(name="pseudo_utilisateur", length=30)
	@JsonView(Views.Common.class)
	public String pseudo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonView(UtilisateurWithPartie.class)
	private List<Partie> listPartie;
	
	@Column(name="role_utilisateur")
	@JsonView(Views.Common.class)
	public Boolean estUnMJ;


//Constructeur-------------------------------------------------------------------
	
	public Utilisateur() {}
	
	// Commonly constructor to use
	public Utilisateur(int id, String mail, String motDePasse, String avatar, String pseudo) {
		this.id = id;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.avatar = avatar;
		this.pseudo = pseudo;
		this.estUnMJ = false;
	}

	public Utilisateur (String mail, String pseudo, String motDePasse) 
	{
		this.mail  =mail;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.estUnMJ = false;
	}
	
	public Utilisateur (String mail, String motDePasse)
	{
		this.mail = mail;
		this.motDePasse=motDePasse;
		this.estUnMJ = false;
	}

//Getters setters-------------------------------------------------------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the estUnMJ
	 */
	public Boolean getEstUnMJ() {
		return estUnMJ;
	}

	/**
	 * @param estUnMJ the estUnMJ to set
	 */
	public void setEstUnMJ(Boolean estUnMJ) {
		this.estUnMJ = estUnMJ;
	}

	/**
	 * @return the partie
	 */
	public List<Partie> getPartie() {
		return listPartie;
	}

	/**
	 * @param partie the partie to set
	 */
	public void setPartie(List<Partie> listPartie) {
		this.listPartie = listPartie;
	}

	
}


