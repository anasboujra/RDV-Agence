package com.RDV.servlets;

import java.io.IOException;
import java.util.List;

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
			List<Reservation> listeReservations = reservationDAO.getReservations("acceptee");
			request.setAttribute("listeReservations", listeReservations);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/acceptee.jsp").forward(request, response);
		}
		else if(action.equals("enAttente")) {
			List<Reservation> listeReservations = reservationDAO.getReservations("enAttente");
			request.setAttribute("listeReservations", listeReservations);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/enAttente.jsp").forward(request, response);
		}
		else if(action.equals("refusee")) {
			List<Reservation> listeReservations = reservationDAO.getReservations("refusee");
			request.setAttribute("listeReservations", listeReservations);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/refusee.jsp").forward(request, response);
		}
		else if(action.equals("validee")) {
			List<Reservation> listeReservations = reservationDAO.getReservations("validee");
			request.setAttribute("listeReservations", listeReservations);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard/Reservation/validee.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null) {
			System.out.println("Marhba bikom f Servlet POST");
			ValidationReservation formulaire = new ValidationReservation();
			System.out.println("AAAAAAA1");
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
