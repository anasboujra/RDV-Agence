package com.RDV.beans;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publication")
public class Publication {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="contenu")
	private String contenu;
	
	@Column(name="image")
	private String image;
 
 
 	public Publication() {
		// TODO Auto-generated constructor stub
	}


	 


	public Publication(int id, String titre, String contenu, String image) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.image = image;
		 
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

 
 	
 

}
