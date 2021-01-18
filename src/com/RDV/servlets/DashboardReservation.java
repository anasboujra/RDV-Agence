package com.RDV.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RDV.Dao.ReservationDAO;
import com.RDV.beans.Reservation;
import com.RDV.metier.ValidationReservation;


public class DashboardReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDAO reservationDAO;
	
	public DashboardReservation() {
		super();
	}
	
	public void init() {
		reservationDAO = new ReservationDAO();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/reservation.jsp").forward(request, response);
		}
		else if(action.equals("acceptee")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/reservation.jsp").forward(request, response);
		}
		else if(action.equals("enAttente")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/enAttente.jsp").forward(request, response);
		}
		else if(action.equals("refusee")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/reservation.jsp").forward(request, response);
		}
		else if(action.equals("validee")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/reservation.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null) {
			ValidationReservation formulaire = new ValidationReservation();
			Reservation reservation = formulaire.creerReservation(request);
			if (formulaire.getErreurs().isEmpty()) {
				reservationDAO.saveReservation(reservation);
	        }
	        request.setAttribute("formulaire", formulaire);
	        request.setAttribute("reservation", reservation);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/reservation.jsp").forward(request, response);
		}
	}

}
