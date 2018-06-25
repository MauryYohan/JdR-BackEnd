package com.jdr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Image")
public class Image {
	
//Attributs-------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	@Column(name="id_image")
	private int id;
	
	@JsonView(Views.Common.class)
	@Column(name="imageChemin_image", length=1000)
	private String imageChemin;
	
	@ManyToOne
	@JsonView(Views.ImageWithPartie.class)
	private Partie partie;

//Constructeurs-------------------------------------------------------------------

	public Image() {}
	
	public Image(String imageChemin, Partie partie) {
		this.imageChemin = imageChemin;
		this.partie = partie;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageChemin() {
		return imageChemin;
	}

	public void setImageChemin(String imageChemin) {
		this.imageChemin = imageChemin;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

}
