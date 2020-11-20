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

import bean.Commande;
import bean.DemandeAdaptee;
import dao.CommandeDAO;
import dao.DemandeAdapteeDAO;
import dao.DemandeMaintenanceDAO;

/**
 * Servlet implementation class LivrerProduit
 */
@WebServlet("/LivrerProduit")
public class LivrerProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LivrerProduit() {
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
	        	   CommandeDAO.updateEtat(id);
	        	   message = "La commande a été livrer. Cliquer ici pour revenir à la liste des commandes";
	        	   request.setAttribute("message", message);
	        	   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/commandeLivrer.jsp");
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
