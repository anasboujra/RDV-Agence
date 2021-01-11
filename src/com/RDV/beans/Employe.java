package com.RDV.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "employe" )
public class Employe {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int    id;
    @Column( name = "cin" )
    private String cin;
    @Column( name = "nom" )
    private String nom;
    @Column( name = "prenom" )
    private String prenom;
    @Column( name = "num_telephone" )
    private String numTele;
    @Column( name = "ville" )
    private String ville;
    @Column( name = "email" )
    private String email;
    @Column( name = "mot_de_passe" )
    private String password;
    @Column( name = "photo_profil" )
    private String photoProfile;
    @Column( name = "date_debut" )
    private String date_debut;

    public Employe() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employe( String cin, String nom, String prenom, String numTele, String ville, String email,
            String photoProfile ) {
        super();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.numTele = numTele;
        this.ville = ville;
        this.email = email;
        this.photoProfile = photoProfile;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin( String cin ) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getNumTele() {
        return numTele;
    }

    public void setNumTele( String numTele ) {
        this.numTele = numTele;
    }

    public String getVille() {
        return ville;
    }

    public void setVille( String ville ) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile( String photoProfile ) {
        this.photoProfile = photoProfile;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut( String date_debut ) {
        this.date_debut = date_debut;
    }

}
