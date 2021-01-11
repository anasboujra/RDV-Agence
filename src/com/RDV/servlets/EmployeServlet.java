package com.RDV.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RDV.beans.Employe;
import com.RDV.dao.EmployeDAO;
import com.RDV.metier.FormulaireEmploye;
import com.ibm.icu.text.SimpleDateFormat;

@MultipartConfig
public class EmployeServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String VUE              = "/WEB-INF/Dashboard/Employe/employe.jsp";
    private static final String VUE_1            = "/WEB-INF/Dashboard/Employe/ajouterEmploye.jsp";
    private static final String VUE_2            = "/WEB-INF/Dashboard/Employe/modifierEmploye.jsp";
    private static final String FORMULAIRE       = "formulaire";
    private static final String EMPLOYE          = "employe";
    private static final String EMPLOYES         = "employes";
    private EmployeDAO          employeDao;

    public EmployeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
        employeDao = new EmployeDAO();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String action = request.getParameter( "do" );
        String todayDate = getDate();
        request.setAttribute( "todayDate", todayDate );
        if ( action == null ) {

            listEmployes( request, response );

        } else {
            switch ( action ) {
            case "ajouter":
                this.getServletContext().getRequestDispatcher( VUE_1 ).forward( request, response );
                break;
            case "modifier":
                listEmploye( request, response );
                break;
            case "supprimer":
                deleteEmploye( request, response );
                break;
            default:
                listEmployes( request, response );
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
        }

    }

    private String getDate() {
        Date aujourdhui = new Date();

        SimpleDateFormat formater = new SimpleDateFormat( "dd-MM-yyyy" );
        System.out.println( formater.format( aujourdhui ) );
        return formater.format( aujourdhui );
    }

    private void insertEmploye( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        FormulaireEmploye formulaire = new FormulaireEmploye();

        Employe employe = formulaire.validerEmploye( request );

        if ( formulaire.getErreurs().isEmpty() ) {
            employeDao.saveEmploye( employe );
        }
        System.out.println( employe.getNom() + " " + employe.getPhotoProfile() );

        request.setAttribute( FORMULAIRE, formulaire );
        request.setAttribute( EMPLOYE, employe );

        this.getServletContext().getRequestDispatcher( VUE_1 ).forward( request, response );
    }

    private void updateEmploye( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        FormulaireEmploye formulaire = new FormulaireEmploye();

        Employe employe = formulaire.validerEmploye( request );

        if ( formulaire.getErreurs().isEmpty() ) {
            employeDao.updateEmploye( employe );
        }
        System.out.println( employe.getNom() + " " + employe.getPhotoProfile() );

        request.setAttribute( FORMULAIRE, formulaire );
        request.setAttribute( EMPLOYE, employe );

        this.getServletContext().getRequestDispatcher( VUE_2 ).forward( request, response );
    }

    private void listEmployes( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        ArrayList<Employe> employes = employeDao.getAllEmploye();

        System.out.println( employes.size() );

        for ( Employe employe : employes ) {
            System.out.println( employe.getCin() );
            System.out.println( employe.getNom() );
        }

        request.setAttribute( EMPLOYES, employes );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    private void listEmploye( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        Employe employe = employeDao.getEmploye( id );

        request.setAttribute( EMPLOYE, employe );

        this.getServletContext().getRequestDispatcher( VUE_2 ).forward( request, response );
    }

    private void deleteEmploye( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        int id = Integer.parseInt( request.getParameter( "id" ) );
        employeDao.deleteEmploye( id );
        response.sendRedirect( request.getContextPath() + "/" + EMPLOYE );
    }

}
