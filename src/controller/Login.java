package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdministrateurTechnique;
import bean.ChefDeProjet;
import bean.Client;
import bean.DemandeMaintenance;
import dao.AdministrateurTechniqueDAO;
import dao.ChefDeProjetDAO;
import dao.ClientDAO;
import dao.DemandeMaintenanceDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        ClientDAO clientDAO = new ClientDAO();
        ChefDeProjetDAO chefDeProjetDAO = new ChefDeProjetDAO();
        AdministrateurTechniqueDAO administrateurTechniqueDAO = new AdministrateurTechniqueDAO();
        //AdministrateurDAO administrateurDAO = new AdministrateurDAO();
        try {
            Client client = clientDAO.authentification(email, password);
            ChefDeProjet chefDeProjet = chefDeProjetDAO.authentification(email, password);
            AdministrateurTechnique administrateurTechnique = administrateurTechniqueDAO.authentification(email, password);
            String destPage = "login.jsp";
             
            if (client != null) {
                HttpSession session = request.getSession();
                session.setAttribute("client", client);
                session.setAttribute("id",client.getId_client());
                destPage = "acceuilClient1.jsp";
            } else if(chefDeProjet != null) {
            	HttpSession session = request.getSession();
                session.setAttribute("chefDeProjet", chefDeProjet);
                session.setAttribute("id",chefDeProjet.getId_chef_projet());
                destPage = "acceuilChefProjet.jsp";
            } else if(administrateurTechnique != null) {
            	HttpSession session = request.getSession();
                session.setAttribute("administrateurTechnique", administrateurTechnique);
                session.setAttribute("id",administrateurTechnique.getId_admin_technique());
                destPage = "acceuilAdminTechnique.jsp";
            }
            else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
	}

}
