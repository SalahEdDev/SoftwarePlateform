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
@WebServlet("/ListeProduitsClient")
@MultipartConfig(maxFileSize = 16177215)
public class ListeProduitsClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private DemandeMaintenanceDAO demandeMaintenanceDAO;

    
    ProduitDAO produitDAO = new ProduitDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeProduitsClient() {
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listeProduitsClients.jsp");
        dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html;charset=UTF-8");
		//HttpSession session = request.getSession();

		//long id = (long) session.getAttribute("id");

        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String prix = request.getParameter("prix");
        System.out.println(nom);
        
        InputStream inputStream = null;
        Part filePart = request.getPart("file");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setPrix(Double.parseDouble(prix));
        produit.setDescription(description);
        
        ProduitDAO.save(produit, inputStream);
        request.getRequestDispatcher("ajouterLogiciel.jsp").include(request,response);*/
	}

}
