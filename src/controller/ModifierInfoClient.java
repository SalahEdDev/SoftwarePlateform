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

import bean.Client;
import dao.ClientDAO;


/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ModifierInfoClient")
public class ModifierInfoClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierInfoClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("id");
		List<Client> clients = ClientDAO.getAll2(id);
        request.setAttribute("clients", clients);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/modifierInfoClient.jsp");
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
		String cin = request.getParameter("cin");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String message= new String();

        if (id != null && !id.isEmpty()) {
        	Client client = new Client();
        	
        	client.setId_client(Long.parseLong(id));
        	client.setNomCLT(nom);
            client.setPrenomCLT(prenom);
            client.setEmailCLT(email);
            client.setPasswordCLT(password);
            client.setCinCLT(cin);
            client.setAdresseCLT(adresse);
            client.setNum_telephoneCLT(tel);
	
            ClientDAO.update(client);  
            message ="Your details have been successfully updated. Return to : ";
     	    request.setAttribute("message", message);
            
        }
        request.getRequestDispatcher("/modifierInfoClientSuccess.jsp").include(request,response);
	}

}
