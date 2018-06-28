package com.jdr.entity;

import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.jdr.entity.Views;

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


//Constructeur-------------------------------------------------------------------
	
	public Utilisateur() {}
	
	public Utilisateur (String mail, String login,String pseudo, String motDePasse) 
	{
		this.mail=mail;
		this.motDePasse=motDePasse;
		this.pseudo=pseudo;
	}
	
	public Utilisateur (String login, String motDePasse) //ca c'est le constructeur car il y'a le nom de la classe et pas de retour
	{
		this.motDePasse=motDePasse;
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

// Methodes-------------------------------------------------------------------
	public void seConnecter() 
	{
	}
	
	public void creerUnCompte() 
	{
		
	}
	
	protected void modifierSonCompte(){
		
	}
	
	protected void SeDeconnecter(){
		
	}
	
	protected void recupererSonIdentifiant(){
		
	}
	
	protected void recupererSonMdp() {
	}
	
	protected void discuterSalleAttente() {
		
	}
	
	protected void lancerLesDes() {
		
	}
	
	protected void discuterDansLaPartie(){
		
	}

	public Object getFields() {
		// TODO Equivalence du ToString
		return null;
	}
	
}


