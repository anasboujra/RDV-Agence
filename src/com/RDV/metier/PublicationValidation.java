package com.RDV.metier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.RDV.beans.Publication;
 

public final class PublicationValidation {
    private static final String CHAMP_TITRE     = "titre";
    private static final String CHAMP_CONTENU   = "contenu";
    private static final String CHAMP_IMAGE     = "image";
    private static final int TAILLE_TAMPON = 10240;
	private static final String CHEMIN_IMAGE = "/RDV-Agence/WebContent/inc/inc_Dashboard/assets/images/publication";
 

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Publication creerPublication( HttpServletRequest request ) throws IOException, ServletException {
    		
    	Publication publication = new Publication();
    	
    	String titre = request.getParameter( CHAMP_TITRE );
    	String contenu = request.getParameter( CHAMP_CONTENU);
    	Part part = request.getPart(CHAMP_IMAGE);
    	String image = part.getSubmittedFileName();
    	// Corrige un bug du fonctionnement d'Internet Explorer
        image = image.substring(image.lastIndexOf('/') + 1).substring(image.lastIndexOf('\\') + 1);
 
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
         
         try {
          	validationImage(image);
          } catch ( Exception e ) {
          setErreur( CHAMP_IMAGE, e.getMessage() );
          }
         publication.setImage(image);
         
         // On écrit définitivement le fichier sur le disque
        // ecrireFichier(part, image, CHEMIN_IMAGE);
 
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
 
    public void validationImage(String image) throws Exception
	{
		if(image.length() == 0) {
			throw new Exception("Merci de telecharger une image");
		}
	}
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

     
}