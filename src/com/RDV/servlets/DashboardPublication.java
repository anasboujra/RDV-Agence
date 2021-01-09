package com.RDV.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
 
import java.util.List;

import com.RDV.Dao.PublicationDao;
import com.RDV.beans.Publication;
import com.RDV.metier.PublicationValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class DashboardPublication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_PUBLICATION = "/WEB-INF/Dashboard/Publication/publication.jsp";
	private static final String VUE_AJOUTER = "/WEB-INF/Dashboard/Publication/ajouterPublication.jsp";
	private static final String VUE_MODIFIER = "/WEB-INF/Dashboard/Publication/modifierPublication.jsp";
	public static final String ATT_FORM   = "form";
       
	 private PublicationDao publicationDao;

	    public void init() {
	        publicationDao = new PublicationDao();
	    }
    public DashboardPublication() {
        super();
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
    	if(action == null) {
    		this.getServletContext().getRequestDispatcher( VUE_PUBLICATION ).forward( request, response );
    	}else {
    		switch(action)
            {
            case "ajouter":
                showNewForm(request, response);
                break;
            case "enregistrer":
                try {
					insertPublication(request, response);
				} catch (SQLException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                break;
            case "supprimer":
                try {
					supprimerPublication(request, response);
				} catch (SQLException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                break;
            case "edit":
                try {
					showEditForm(request, response);
				} catch (SQLException | ServletException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                break;
            case "modifier":
                try {
					modifierPublication(request, response);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                break;
            default:
                try {
					listPublications(request, response);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                break;
            }
    	}
    	
	 
	
        
		 
	}
	
	private void listPublications(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		        
				List < Publication > publications = publicationDao.getAllPublications();
		        request.setAttribute("publications", publications);
		        RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_PUBLICATION);
		        dispatcher.forward(request, response);
		    }

		    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
		    	RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_AJOUTER);
		        dispatcher.forward(request, response);
		    }

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		        
		    	int id = Integer.parseInt(request.getParameter("id"));
		        Publication modifierPublication = publicationDao.getPublication(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_MODIFIER);
		        request.setAttribute("publication", modifierPublication);
		        dispatcher.forward(request, response);

		    }

		    private void insertPublication(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		    	PublicationValidation form = new PublicationValidation();
		    	Publication newPublication = form.creerPublication(request);
		    	request.setAttribute( ATT_FORM, form );
		        publicationDao.savePublication(newPublication);
		        //response.sendRedirect(VUE_PUBLICATION);
		        if ( form.getErreurs().isEmpty() ) {
	 					response.sendRedirect(VUE_PUBLICATION);
		        }
		        else
		        {
		        	 this.getServletContext().getRequestDispatcher( VUE_AJOUTER ).forward( request, response );
		        }
		    }

		    private void modifierPublication(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String titre = request.getParameter("titre");
		        String contenu = request.getParameter("contenu");
		        InputStream image = request.getInputStream();
		        Date date = new Date(0);
		        Publication publication = new Publication(id, titre, contenu, image,date);
		        publicationDao.updatePublication(publication);
		        response.sendRedirect(VUE_PUBLICATION);
		    }

		    private void supprimerPublication(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        publicationDao.deletePublication(id);
		        response.sendRedirect(VUE_PUBLICATION);
		    }

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
