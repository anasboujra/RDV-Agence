package com.RDV.beans;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")

public class Reservation {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private String idReservation;
	@Column(name="date")
	private String date;
	@Column(name="heure")
	private String heure;
	@Column(name="statut")
	private String statut;
	@Column(name="idClient")
	private int idClient;
	@Column(name="cin")
	private String cin;
	public Reservation(String idReservation, String date, String heure, String statut, int idClient, String cin) {
		super();
		this.idReservation = idReservation;
		this.date = date;
		this.heure = heure;
		this.statut = statut;
		this.idClient = idClient;
		this.cin = cin;
	}
	public String getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
 
 
	
}
