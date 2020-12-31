package com.RDV.beans;

public class Employe {
    private String cin;
    private String nom;
    private String prenom;
    private String numTele;
    private String adresse;
    private String email;
    private String photoProfile;

    public Employe() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Employe( String cin, String nom, String prenom, String numTele, String adresse, String email,
            String photoProfile ) {
        super();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.numTele = numTele;
        this.adresse = adresse;
        this.email = email;
        this.photoProfile = photoProfile;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile( String photoProfile ) {
        this.photoProfile = photoProfile;
    }

}
