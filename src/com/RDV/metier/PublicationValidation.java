package com.RDV.metier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.RDV.beans.Publication;
 

public final class PublicationValidation {
    private static final String CHAMP_TITRE     = "titre";
    private static final String CHAMP_CONTENU   = "contenu";
    private static final String CHAMP_IMAGE     = "image";
 
 

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Publication creerPublication( HttpServletRequest request ) {
    		
    	Publication publication = new Publication();
    	
    	String titre = request.getParameter( CHAMP_TITRE );
    	String contenu = request.getParameter( CHAMP_CONTENU);
 
    	 try {
         	validationTitre(titre);
         } catch ( Exception e ) {
         setErreur( CHAMP_TITRE, e.getMessage() );
         }
         publication.setTitre(titre);
         

    	 try {
         	validationContenu(contenu);
         } catch ( Exception e ) {
         setErreur( CHAMP_CONTENU, e.getMessage() );
         }
         publication.setContenu(contenu);
 
        return publication;
    }

 
    public void validationTitre(String titre) throws Exception
	{
		if(titre.length()<10) {
			throw new Exception("Merci de saisir un titre contiant au moins 10 lettre");
		}
	}
    
    public void validationContenu(String contenu) throws Exception
   	{
   		if(contenu.length()<100) {
   			throw new Exception("Merci de saisir un contenu contiant au moins 100 lettre");
   		}
   	}
 

    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

     
}