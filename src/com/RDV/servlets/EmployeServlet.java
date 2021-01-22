package com.RDV.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RDV.Dao.EmployeDAO;
import com.RDV.beans.Employe;
import com.RDV.metier.FormulaireEmploye;
import com.ibm.icu.text.SimpleDateFormat;

@MultipartConfig
public class EmployeServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String VUE              = "/WEB-INF/Dashboard/Employe/employe.jsp";
    private static final String VUE_1            = "/WEB-INF/Dashboard/Employe/ajouterEmploye.jsp";
    private static final String VUE_2            = "/WEB-INF/Dashboard/Employe/modifierEmploye.jsp";
    private static final String VUE_3            = "/WEB-INF/Dashboard/Employe/modifierPhotoProfil.jsp";
    private static final String FORMULAIRE       = "formulaire";
    private static final String EMPLOYE          = "employe";
    private static final String EMPLOYES         = "employes";
    private static final String PERIODES         = "periodes";
    private static final String SUSPEND_EMPLOYES = "suspendEmployes";

    private EmployeDAO          employeDao;

    public EmployeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
        employeDao = new EmployeDAO(Employe.class);
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String action = request.getParameter( "do" );
        String todayDate = getDate();
        request.setAttribute( "todayDate", todayDate );
        if ( action == null ) {

            try {
                listEmployes( request, response );
            } catch ( ServletException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch ( IOException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch ( ParseException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            switch ( action ) {
            case "ajouter":
                this.getServletContext().getRequestDispatcher( VUE_1 ).forward( request, response );
                break;
            case "modifier":
                listEmploye( request, response, VUE_2 );
                break;
            case "supprimer":
                deleteEmploye( request, response );
                break;
            case "suspendre":
                suspendEmploye( request, response );
                break;
            case "activer":
                activateEmploye( request, response );
                break;
            case "modifierPhotoProfil":
                listEmploye( request, response, VUE_3 );
            default:
                try {
                    listEmployes( request, response );
                } catch ( ServletException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch ( IOException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch ( ParseException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String action = request.getParameter( "action" );

        // String action = request.getRequestURL().substring(
        // request.getRequestURL().length() - field.length() - 1,
        // request.getRequestURL().length() );

        System.out.println( action );

        switch ( action ) {

        case "ajouter":
            insertEmploye( request, response );
            break;
        case "modifier":
            updateEmploye( request, response );
            break;
        case "modifierPhotoProfil":
            updatePhotoProfil( request, response );
            break;
        }

    }

    private String getDate() {
        Date aujourdhui = new Date();

        SimpleDateFormat formater = new SimpleDateFormat( "dd-MM-yyyy" );
        System.out.println( formater.format( aujourdhui ) );
        return formater.format( aujourdhui );
    }

    @SuppressWarnings("unchecked")
	private void insertEmploye( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        FormulaireEmploye formulaire = new FormulaireEmploye();

        Employe employe = formulaire.validerEmploye( request );

        if ( formulaire.getErreurs().isEmpty() ) {
            employeDao.save(employe);
        }
        System.out.println( employe.getNom() + " " + employe.getPhotoProfile() );

        request.setAttribute( FORMULAIRE, formulaire );
        request.setAttribute( EMPLOYE, employe );

        this.getServletContext().getRequestDispatcher( VUE_1 ).forward( request, response );
    }

    @SuppressWarnings("unchecked")
	private void updateEmploye( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

        FormulaireEmploye formulaire = new FormulaireEmploye();

        Employe employe = formulaire.modifierEmploye( request );

        System.out.println( employe.getNom() + " " + employe.getPhotoProfile() );

        System.out.println( employe.getPassword() + " " + employe.getOldPassword() );

        if ( formulaire.getErreurs().isEmpty() ) {
            employeDao.update(employe);
            System.out.println( "test" );
        }

        request.setAttribute( FORMULAIRE, formulaire );
        request.setAttribute( EMPLOYE, employe );

        this.getServletContext().getRequestDispatcher( VUE_2 ).forward( request, response );
    }

    @SuppressWarnings("unchecked")
	private void updatePhotoProfil( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

        FormulaireEmploye formulaire = new FormulaireEmploye();

        Employe employe = formulaire.modifierPhotoProfil( request );

        System.out.println( employe.getNom() + " " + employe.getPhotoProfile() );

        System.out.println( employe.getPassword() + " " + employe.getOldPassword() );

        if ( formulaire.getErreurs().isEmpty() ) {
            employeDao.update(employe);
            System.out.println( "test" );
        }

        request.setAttribute( FORMULAIRE, formulaire );
        request.setAttribute( EMPLOYE, employe );

        this.getServletContext().getRequestDispatcher( VUE_3 ).forward( request, response );
    }

    @SuppressWarnings("unchecked")
	private void listEmployes( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException, ParseException {
        ArrayList<Employe> allEmployes = (ArrayList<Employe>) employeDao.getAll("from Employe");

        ArrayList<Employe> employes = new ArrayList<Employe>();
        ArrayList<Employe> suspendEmployes = new ArrayList<Employe>();

        Map<Integer, String> periodes = new HashMap<Integer, String>();
        System.out.println( employes.size() );

        for ( Employe employe : allEmployes ) {
            String todayDate = getDate();
            String period = compareDates( employe.getDate_debut(), todayDate );
            System.out.println( period );

            if ( employe.getIsConge() == 0 ) {
                employes.add( employe );
            } else {
                suspendEmployes.add( employe );
            }
            periodes.put( employe.getId(), period );
        }

        request.setAttribute( PERIODES, periodes );
        request.setAttribute( SUSPEND_EMPLOYES, suspendEmployes );
        request.setAttribute( EMPLOYES, employes );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    private void listEmploye( HttpServletRequest request, HttpServletResponse response, String pageJsp )
            throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        Employe employe = (Employe) employeDao.getById(id);

        request.setAttribute( EMPLOYE, employe );

        this.getServletContext().getRequestDispatcher( pageJsp ).forward( request, response );
    }

    private void deleteEmploye( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        employeDao.delete(id);
        response.sendRedirect( request.getContextPath() + "/" + EMPLOYE );
    }

    @SuppressWarnings("unchecked")
	private void suspendEmploye( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        Employe employe = (Employe) employeDao.getById(id);
        employe.setIsConge( 1 );
        employeDao.update(employe);
        response.sendRedirect( request.getContextPath() + "/" + EMPLOYE );
    }

    @SuppressWarnings("unchecked")
	private void activateEmploye( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        Employe employe = (Employe) employeDao.getById(id);
        employe.setIsConge( 0 );
        employeDao.update(employe);
        response.sendRedirect( request.getContextPath() + "/" + EMPLOYE );
    }

    private String compareDates( String Date1, String Date2 )
            throws ParseException {

        String[] parts = Date1.split( "-" );
        int part1 = Integer.parseInt( parts[0] ); // days
        int part2 = Integer.parseInt( parts[1] ); // months
        int part3 = Integer.parseInt( parts[2] ); // years

        LocalDate firstDate = LocalDate.of( part3, part2, part1 );

        parts = Date2.split( "-" );
        part1 = Integer.parseInt( parts[0] ); // days
        part2 = Integer.parseInt( parts[1] ); // months
        part3 = Integer.parseInt( parts[2] ); // years

        LocalDate secondDate = LocalDate.of( part3, part2, part1 );

        Period age = Period.between( firstDate, secondDate );

        int years = age.getYears();
        int months = age.getMonths();

        String period = years + " years " + months + " months";

        return period;

    }

}
