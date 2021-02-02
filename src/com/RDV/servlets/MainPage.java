package com.RDV.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RDV.Dao.PublicationDao;
import com.RDV.beans.Publication;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/acceuil")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE_MAIN="/WEB-INF/Front/mainpage.jsp";
    private PublicationDao publicationDao;
    private static final String ATT_PUBLICATIONS = "publications";
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public void init() {
    	publicationDao = new PublicationDao(Publication.class);
    }
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList < Publication > publications = (ArrayList<Publication>) publicationDao.getAll("from Publication");
		request.setAttribute(ATT_PUBLICATIONS, publications);
		this.getServletContext().getRequestDispatcher( VUE_MAIN ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
