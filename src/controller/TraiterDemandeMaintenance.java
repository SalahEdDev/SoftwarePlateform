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
import bean.DemandeMaintenance;
import dao.ChefDeProjetDAO;
import dao.DemandeMaintenanceDAO;

/**
 * Servlet implementation class TraiterDemandeMaintenance
 */
@WebServlet("/TraiterDemandeMaintenance")
public class TraiterDemandeMaintenance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiterDemandeMaintenance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DemandeMaintenance> demandesMaintenance = DemandeMaintenanceDAO.getAll();
        request.setAttribute("demandesMaintenance", demandesMaintenance);
        List<ChefDeProjet> chefsDeProjet = ChefDeProjetDAO.getAll();
        request.setAttribute("chefsDeProjet", chefsDeProjet);
        //request.getRequestDispatcher("traiterDemande.jsp").include(request,response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/traiterDemandeCP.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id3 = request.getParameter("id3");


        if (id3 != null && !id3.isEmpty()) {
        	DemandeMaintenance demandeMaintenance = new DemandeMaintenance();
            
            demandeMaintenance.setId_demande_maintenance(Long.parseLong(id3));
            DemandeMaintenanceDAO.updateEtat(demandeMaintenance);
          
        }
        request.getRequestDispatcher("acceuilChefProjet.jsp").include(request,response);
	}

}
