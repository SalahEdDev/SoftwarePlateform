package controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import bean.Produit;
import dao.ProduitDAO;

/**
 * Servlet implementation class AjouterPanier
 */
@WebServlet("/AjouterPanier")
public class AjouterPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

		long id = Long.parseLong(request.getParameter("id"));
		System.out.println(id);
        String nom = request.getParameter("nom");
        String prix = request.getParameter("prix");
        String desc = request.getParameter("desc");
        
        /*InputStream inputStream1 = null;
        Part picture = request.getPart("picture");
        if (picture != null) 
        {
            System.out.println(picture.getName());
            System.out.println(picture.getSize());
            System.out.println(picture.getContentType());
            inputStream1 = picture.getInputStream();
        }*/
        //IOUtils.toByteArray(inputStream1),
 
        List<Produit> produits= (List<Produit>) session.getAttribute("list");

        if(produits==null){
          produits =new ArrayList<>();
        }
        
        produits.add(new Produit(id, nom, Double.parseDouble(prix), desc));
        
        session.setAttribute("list",produits);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listePanier.jsp");
        dispatcher.forward(request, response);
	}

}
