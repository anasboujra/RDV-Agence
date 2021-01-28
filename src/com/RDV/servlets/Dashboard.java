package com.RDV.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.RDV.Dao.StatistiqueDao;


/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_DASHBOARD = "/WEB-INF/Dashboard/index.jsp";
	private static final String STAT_CONGE = "conges";
	private static final String SOMME_CONGE  = "somme";
	private static final String PUB ="publications";
	private static final String PUB_SOMME ="pubSomme";

	//private static final String PUB_FEV ="pubFevrier";
	
	private StatistiqueDao statistiqueDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
        statistiqueDao = new StatistiqueDao();
        System.out.println("Statistique Publication ");
        statistiqueDao.publication();
        
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		/* Statistique Employe */
		ArrayList<Integer> isConge = statistiqueDao.employe();
 
		session.setAttribute(SOMME_CONGE, isConge.get(0) + isConge.get(1));
		
		session.setAttribute(STAT_CONGE, isConge);
		
		/* Statistique Publication */
		ArrayList<Integer> result = statistiqueDao.publication();
 
		session.setAttribute(PUB_SOMME, result.get(0) + result.get(1)+result.get(2)+result.get(3)+result.get(4)+result.get(5)+result.get(6)+result.get(7)+result.get(8)+result.get(9)+result.get(10)+result.get(11));
		session.setAttribute(PUB, result);
		this.getServletContext().getRequestDispatcher( VUE_DASHBOARD ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
