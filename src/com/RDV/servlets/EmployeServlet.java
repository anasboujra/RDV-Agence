package com.RDV.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeServlet extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String VUE              = "/WEB-INF/Dashboard/Employe/employe.jsp";
    private static final String VUE_1              = "/WEB-INF/Dashboard/Employe/ajouterEmploye.jsp";
    private static final String VUE_2              = "/WEB-INF/Dashboard/Employe/modifierEmploye.jsp";

    public EmployeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    	String action = request.getParameter("do");
    	if(action == null) {
    		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	}else {
    		switch(action) {
	    		case "ajouter" :
	    			this.getServletContext().getRequestDispatcher( VUE_1 ).forward( request, response );
	    		break;
	    		case "modifier" :
	    			this.getServletContext().getRequestDispatcher( VUE_2 ).forward( request, response );
	    		break;
	    		default :
	    			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    	}
    	}
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

}
