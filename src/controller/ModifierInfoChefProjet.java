package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChefDeProjet;
import dao.ChefDeProjetDAO;



/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ModifierInfoChefProjet")
public class ModifierInfoChefProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierInfoChefProjet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("id");
		List<ChefDeProjet> chefsDeProjet = ChefDeProjetDAO.getAll2(id);
        request.setAttribute("chefsDeProjet", chefsDeProjet);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/modifierInfoChefProjet.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String github = request.getParameter("github");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String message = new String();

        if (id != null && !id.isEmpty()) {
        	ChefDeProjet cp = new ChefDeProjet();
        	
        	cp.setId_chef_projet(Long.parseLong(id));
        	cp.setNomCP(nom);
            cp.setPrenomCP(prenom);
            cp.setEmailCP(email);
            cp.setPasswordCP(password);
            cp.setGithubCP(github);
            cp.setAdresseCP(adresse);
            cp.setNum_telephoneCP(tel);

            ChefDeProjetDAO.update(cp);  
            message ="Your details have been successfully updated. Return to : ";

     	    request.setAttribute("message", message);
            
            
        }
        request.getRequestDispatcher("/modifierInfoChefProjetSuccess.jsp").include(request,response);
	}

}
