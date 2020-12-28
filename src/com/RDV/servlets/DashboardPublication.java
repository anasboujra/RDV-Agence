package com.RDV.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class DashboardPublication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_PUBLICATION = "/WEB-INF/Dashboard/Publication/publication.jsp";
	private static final String VUE_AJOUTER = "/WEB-INF/Dashboard/Publication/ajouterpublication.jsp";
	private static final String VUE_MODIFIER = "/WEB-INF/Dashboard/Publication/modifierpublication.jsp";
       
     
    public DashboardPublication() {
        super();
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
        switch(action)
        {
            case "modifier": 
            	this.getServletContext().getRequestDispatcher( VUE_MODIFIER ).forward( request, response );
            	break;
            case "ajouter":
            	this.getServletContext().getRequestDispatcher( VUE_AJOUTER ).forward( request, response );
            	break;
             
            default:
            	this.getServletContext().getRequestDispatcher( VUE_PUBLICATION ).forward( request, response );
            	break;
        }
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
