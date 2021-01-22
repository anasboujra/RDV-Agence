package com.RDV.metier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.RDV.Dao.AnnonceDao;
import com.RDV.beans.Annonce;

public class AnnonceValidation {

	public AnnonceValidation() {
		// TODO Auto-generated constructor stub
	}
	
	private static final String CHAMP_ID        = "id";
	private static final String CHAMP_TITRE     = "titre";
    private static final String CHAMP_CONTENU   = "contenu";
    private static final String CHAMP_IMAGE     = "image";
    private static final int    TAILLE_TAMPON       = 10485760;
	private static final String CHEMIN_IMAGE = "/inc/inc_Dashboard/assets/images";
	
	private AnnonceDao annonceDao;
	private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
    
    public Annonce crrerAnnonce( HttpServletRequest request ) throws IOException, ServletException {
    	
    	Annonce annonce = new Annonce();
    	
    	String titre = request.getParameter( CHAMP_TITRE );
    	String contenu = request.getParameter( CHAMP_CONTENU);
    	ServletContext context = request.getServletContext();
        String uploadPath = context.getRealPath( CHEMIN_IMAGE );
        System.out.println( CHEMIN_IMAGE );
        System.out.println( uploadPath );
        String nomFichier = null;
        InputStream contenuFichier = null;
        
        try {
         	validationTitre(titre);
         } catch ( Exception e ) {
         setErreur( CHAMP_TITRE, e.getMessage() );
         }
        annonce.setTitre(titre);
        
        try {
         	validationContenu(contenu);
         } catch ( Exception e ) {
         setErreur( CHAMP_CONTENU, e.getMessage() );
         }
        annonce.setContenu(contenu);
        
        
        annonce.setIdEmploye(1);
        
        try {
       	 Part part = request.getPart(CHAMP_IMAGE);
            /*
             * Il faut d�terminer s'il s'agit bien d'un champ de type fichier :
             * on d�l�gue cette op�ration � la m�thode utilitaire
             * getNomFichier().
             */
            nomFichier = part.getSubmittedFileName();

            /*
             * Si la m�thode a renvoy� quelque chose, il s'agit donc d'un champ
             * de type fichier (input type="file").
             */
            if ( nomFichier != null && !nomFichier.isEmpty() ) {
                /*
                 * Antibug pour Internet Explorer, qui transmet pour une raison
                 * mystique le chemin du fichier local � la machine du client...
                 * 
                 * Ex : C:/dossier/sous-dossier/fichier.ext
                 * 
                 * On doit donc faire en sorte de ne s�lectionner que le nom et
                 * l'extension du fichier, et de se d�barrasser du superflu.
                 */
                nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 ).substring( nomFichier.lastIndexOf( '\\' ) + 1 );
                
                annonce.setImage(nomFichier);	
                /* R�cup�ration du contenu du fichier */
                contenuFichier = part.getInputStream();

            }
        } catch ( IllegalStateException e ) {
            /*
             * Exception retourn�e si la taille des donn�es d�passe les limites
             * d�finies dans la section <multipart-config> de la d�claration de
             * notre servlet d'upload dans le fichier web.xml
             */
            e.printStackTrace();
            setErreur( CHAMP_IMAGE, "Les donn�es envoy�es sont trop volumineuses." );
        } catch ( IOException e ) {
            /*
             * Exception retourn�e si une erreur au niveau des r�pertoires de
             * stockage survient (r�pertoire inexistant, droits d'acc�s
             * insuffisants, etc.)
             */
            e.printStackTrace();
            setErreur( CHAMP_IMAGE, "Erreur de configuration du serveur." );
        } catch ( ServletException e ) {
            /*
             * Exception retourn�e si la requ�te n'est pas de type
             * multipart/form-data. Cela ne peut arriver que si l'utilisateur
             * essaie de contacter la servlet d'upload par un formulaire
             * diff�rent de celui qu'on lui propose... pirate ! :|
             */
            e.printStackTrace();
            setErreur( CHAMP_IMAGE, "Ce type de requ�te n'est pas support�, merci d'utiliser le formulaire pr�vu pour envoyer votre fichier." );
        }
        ecrireFichier( contenuFichier, nomFichier, uploadPath );
       return annonce;
    }
    
    /* Cette fonction pour valider les champs lors du modification */

    public Annonce modifierAnnonce( HttpServletRequest request ) throws IOException, ServletException {
        /* R�cup�ration des champs du formulaire */
        int id = Integer.parseInt( request.getParameter(CHAMP_ID));
        String titre = request.getParameter( CHAMP_TITRE );
    	String contenu = request.getParameter( CHAMP_CONTENU);
    	ServletContext context = request.getServletContext();
        String uploadPath = context.getRealPath( CHEMIN_IMAGE );
        System.out.println( CHEMIN_IMAGE );
        System.out.println( uploadPath );
 
        // String photoProfil = getValeurChamp( request, CHAMP_PHOTO_PROFIL );

        Annonce annonce = new Annonce();
        annonceDao = new AnnonceDao(Annonce.class);
        annonce = (Annonce) annonceDao.getById(id);

        try {
         	validationTitre(titre);
         } catch ( Exception e ) {
         setErreur( CHAMP_TITRE, e.getMessage() );
         }
         annonce.setTitre(titre);
         

    	 try {
         	validationContenu(contenu);
         } catch ( Exception e ) {
         setErreur( CHAMP_CONTENU, e.getMessage() );
         }
         annonce.setContenu(contenu);
         
 
  
         
         annonce.setIdEmploye(1);

 
 
 

        /* Initialisation du r�sultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "l'employ� est modifi� avec succ�s";
        } else {
            resultat = "Echec lors de la modification de l'employ�";
        }

        return annonce;
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
       private void ecrireFichier( InputStream contenu, String nomFichier, String chemin ) throws IOException {
           BufferedInputStream entree = null;
           BufferedOutputStream sortie = null;
           try {
               entree = new BufferedInputStream(contenu, TAILLE_TAMPON);
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
