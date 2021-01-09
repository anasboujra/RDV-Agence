package com.RDV.beans;

import java.io.InputStream;
import java.sql.Date;

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
	private InputStream image;
 
	
	@Column(name="dateCreation")
	private Date date;
	
	
	
	public Publication(String titre, String contenu, InputStream image, Date date) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.image = image;
		this.date = date;
	}
	
	

 
	
	
	public Publication(int id, String titre, String contenu, InputStream image, Date date) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.image = image;
		this.date = date;
	}






	public Publication() {
		// TODO Auto-generated constructor stub
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

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}
	
	
	

}
