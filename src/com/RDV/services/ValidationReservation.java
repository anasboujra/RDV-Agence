package com.RDV.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.RDV.beans.Reservation;

public class ValidationReservation {
    private static final String CHAMP_CIN = "cin";
    
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Reservation creerReservation( HttpServletRequest request ) throws IOException, ServletException {
    	Reservation reservation = new Reservation();
    	String cin = request.getParameter( CHAMP_CIN );
    	
    	 try {
         	validationCin(cin);
         } catch (Exception e) {
         erreurs.put( CHAMP_CIN, e.getMessage() );
         }
         reservation.setCin(cin);
         return reservation;
    }

    public void validationCin(String cin) throws Exception
	{
		if(cin.length()!=7) {
			throw new Exception("Merci de saisir un CIN qui contient 7 caracteres");
		}
	}
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
}
