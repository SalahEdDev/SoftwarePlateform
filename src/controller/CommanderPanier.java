package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import bean.Produit;


import dao.ProduitDAO;

/**
 * Servlet implementation class DemandeMaintenanceServlet
 */
@WebServlet("/CommanderPanier")
@MultipartConfig(maxFileSize = 16177215)
public class CommanderPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private DemandeMaintenanceDAO demandeMaintenanceDAO;

    
    ProduitDAO produitDAO = new ProduitDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommanderPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        List<Produit> produits = ProduitDAO.getAll();
        request.setAttribute("produits", produits);
        
        /*List<ChefDeProjet> chefsDeProjet = ChefDeProjetDAO.getAll();
        request.setAttribute("chefsDeProjet", chefsDeProjet);*/
        //request.getRequestDispatcher("traiterDemande.jsp").include(request,response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listePanier.jsp");
        dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
