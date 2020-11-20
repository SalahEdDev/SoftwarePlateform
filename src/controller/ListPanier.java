package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import dao.CommandeDAO;
import dao.ProduitDAO;

/**
 * Servlet implementation class DemandeMaintenanceServlet
 */
@WebServlet("/ListPanier")
@MultipartConfig(maxFileSize = 16177215)
public class ListPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private DemandeMaintenanceDAO demandeMaintenanceDAO;

    
    ProduitDAO produitDAO = new ProduitDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List<Produit> produits = ProduitDAO.getAll();
        request.setAttribute("produits", produits);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/afficherPanier.jsp");
        dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

        String nom = request.getParameter("nom");
        String prix = request.getParameter("prix");
        String desc = request.getParameter("desc");
        //byte[] imageData = request.getParameter("photo").getBytes();

        
 
        List<Produit> produits= (List<Produit>) session.getAttribute("list");

        if(produits==null){
          produits =new ArrayList<>();
        }

        produits.add(new Produit(nom, Double.parseDouble(prix), desc));
        
       
        session.setAttribute("list",produits);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listePanier.jsp");
        dispatcher.forward(request, response);*/
	}

}
