package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DemandeMaintenanceDAO;

/**
 * Servlet implementation class AccepterRefuserDemande
 */
@WebServlet("/AccepterRefuserDemande")
public class AccepterRefuserDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccepterRefuserDemande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
	       try {
	           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esoft?useSSL=false", "root", "");
	           String message = new String();
	           Long id = Long.parseLong(request.getParameter("id"));
	           String type = request.getParameter("type");
	           if(type.equals("a")) {
	        	   DemandeMaintenanceDAO.updateEtat2(id, 1);
	        	   message = "La demande a été acceptée. Cliquer ici pour revenir à la liste des demandes";
	        	   request.setAttribute("message", message);
	        	   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/demandeAccepter.jsp");
	               dispatcher.forward(request, response);
	           }
	           if(type.contentEquals("r")) {
	        	   DemandeMaintenanceDAO.updateEtat2(id, 3);
	        	   message ="La demande a été refusée. Cliquer ici pour revenir à la liste des demandes";
	        	   request.setAttribute("message", message);
	        	   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/demandeRefuser.jsp");
	               dispatcher.forward(request, response);
	           }
	           
	       }catch (Exception e) {
           }
	       
	}
	           
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
