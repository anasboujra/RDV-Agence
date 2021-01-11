package com.RDV.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DashboardReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/index.jsp").forward(request, response);
		}
		else if(action=="acceptee") {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/index.jsp").forward(request, response);
		}
		else if(action=="enAttente") {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/index.jsp").forward(request, response);
		}
		else if(action=="refusee") {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/index.jsp").forward(request, response);
		}
		else if(action=="valdee") {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/index.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
