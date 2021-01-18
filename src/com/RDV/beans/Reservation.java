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
	private LocalDate date;
	@Column(name="heure")
	private LocalTime heure;
	@Column(name="statut")
	private String statut;
	@Column(name="cin")
	private String cin;
	
	public Reservation() {
		super();
	}
	
	public String getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getHeure() {
		return heure;
	}
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	
}
