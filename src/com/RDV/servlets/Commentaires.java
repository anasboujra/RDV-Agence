package com.RDV.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RDV.dao.CommentaireDao;




/**
 * Servlet implementation class Commentaires
 */
@WebServlet("/Commentaires")
public class Commentaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  CommentaireDao commentaireDao;
	
	 public Commentaires() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	 public void init() {
			commentaireDao = new CommentaireDao();
		}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/delete":
				deleteCommentaires(request, response);
				break;
			default:
				listCommentaires(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listCommentaires(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<com.RDV.beans.Commentaires> listCommentaires = commentaireDao.getAllCommentaires();
		request.setAttribute("listCommentaires", listCommentaires);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Commentaires.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteCommentaires(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		commentaireDao.deleteCommentaires(id);
		response.sendRedirect(request.getContextPath()+"Commentaires");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

    

}
