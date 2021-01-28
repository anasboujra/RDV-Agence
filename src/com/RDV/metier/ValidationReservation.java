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
    	System.out.println("Etape 1");
    	Reservation reservation = new Reservation();
    	String cin = request.getParameter(CHAMP_CIN);
    	
    	DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	String datee = request.getParameter("date");
    	LocalDate date = LocalDate.parse(datee, formatterDate);
    	datee = date.toString();
    	DateTimeFormatter formatterHeure = DateTimeFormatter.ofPattern("HH:mm");
    	String heuree = request.getParameter("heure");
    	LocalTime heure = LocalTime.parse(heuree, formatterHeure);
    	heuree = heure.toString();
    	
    	System.out.println("Request bslama "+heuree+"      "+datee);
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
    	reservation.setDate(datee);
    	reservation.setHeure(heuree);
    	reservation.setStatut("validee");
    	reservation.setIdClient(1);
    	reservation.setIdReservation("13");
    	System.out.println("Salina L validation");
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
		 
	}
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
}
