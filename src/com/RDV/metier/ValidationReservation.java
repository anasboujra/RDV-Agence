package com.RDV.metier;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.RDV.beans.Reservation;

public class ValidationReservation {
    private static final String CHAMP_CIN = "cin";
    private static final String CHAMP_DATE = "date";
    
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Reservation creerReservation( HttpServletRequest request ) throws IOException, ServletException {
    	Reservation reservation = new Reservation();
    	String cin = request.getParameter(CHAMP_CIN);
    	
    	DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate date = LocalDate.parse(request.getParameter("date"), formatterDate);
    	DateTimeFormatter formatterHeure = DateTimeFormatter.ofPattern("HH:mm");
    	LocalTime heure = LocalTime.parse(request.getParameter("heure"), formatterHeure);
    	
    	try {
    		validationCin(cin);
    	}catch (Exception e) {
    		erreurs.put(CHAMP_CIN, e.getMessage());
	    }
    	reservation.setCin(cin);
    	
    	try {
    		validationDateHeure(date, heure);
    	}catch (Exception e) {
    		erreurs.put(CHAMP_DATE, e.getMessage());
	    }
    	reservation.setDate(date);
    	reservation.setHeure(heure);
    	reservation.setStatut("validee");
    	reservation.setIdReservation("13");

    	return reservation;
    }

    public void validationCin(String cin) throws Exception
	{
		if(cin.length()!=7) {
			throw new Exception("Merci de saisir un CIN qui contient 7 caracteres");
		}
	}
    
    public void validationDateHeure(LocalDate date, LocalTime heure) throws Exception
	{
		if(false) {
			throw new Exception("Merci de saisir une date disponible");
		}
	}
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
}
