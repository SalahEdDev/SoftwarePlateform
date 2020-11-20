package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChefDeProjet;
import bean.DemandeAdaptee;

import dao.ChefDeProjetDAO;
import dao.DemandeAdapteeDAO;


/**
 * Servlet implementation class TraiterDemandeAdaptee
 */
@WebServlet("/TraiterDemandeAdaptee")
public class TraiterDemandeAdaptee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiterDemandeAdaptee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DemandeAdaptee> demandesAdaptee = DemandeAdapteeDAO.getAll();
        request.setAttribute("demandesAdaptee", demandesAdaptee);
        List<ChefDeProjet> chefsDeProjet = ChefDeProjetDAO.getAll();
        request.setAttribute("chefsDeProjet", chefsDeProjet);
        //request.getRequestDispatcher("traiterDemande.jsp").include(request,response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/traiterDemandeAdapteeCP.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id3 = request.getParameter("id3");


        if (id3 != null && !id3.isEmpty()) {
        	DemandeAdaptee demandeAdaptee = new DemandeAdaptee();
            
        	demandeAdaptee.setId_demande_adaptee(Long.parseLong(id3));
            DemandeAdapteeDAO.updateEtat(demandeAdaptee);
          
        }
        request.getRequestDispatcher("acceuilChefProjet.jsp").include(request,response);
	}

}
