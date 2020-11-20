package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.ChefDeProjet;
import bean.DemandeMaintenance;
import dao.ChefDeProjetDAO;
import dao.DemandeMaintenanceDAO;


/**
 * Servlet implementation class EnvoyerDemandeMaintenance
 */
@WebServlet("/EnvoyerDemandeMaintenance")
public class EnvoyerDemandeMaintenance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvoyerDemandeMaintenance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*List<DemandeMaintenance> demandesMaintenance = DemandeMaintenanceDAO.getAll();
        request.setAttribute("demandesMaintenance", demandesMaintenance);*/

		/*int demandeMaintenanceID = Integer.parseInt(request.getParameter("id_dm"));
		DemandeMaintenance demandesM = DemandeMaintenanceDAO.getDemandeMaintenanceById(demandeMaintenanceID);
	    request.setAttribute("demandesM", demandesM);

        
		
        List<ChefDeProjet> chefsDeProjet = ChefDeProjetDAO.getAll();
        request.setAttribute("chefsDeProjet", chefsDeProjet);
        //request.getRequestDispatcher("traiterDemande.jsp").include(request,response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/envoyerChefProjet.jsp");
        dispatcher.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id3 = request.getParameter("id3");
		String id2 = request.getParameter("id2");
		String message = new String();

        if (id2 != null && !id2.isEmpty()) {
        	DemandeMaintenance demandeMaintenance = new DemandeMaintenance();
            
            demandeMaintenance.setId_demande_maintenance(Long.parseLong(id3));
            DemandeMaintenanceDAO.update(demandeMaintenance, Long.parseLong(id2));
          
        }
        message ="La demande a été envoyée au CdP selectionné. Cliquer ici pour revenir à : ";
 	    request.setAttribute("message", message);
        request.getRequestDispatcher("envoyerMaintenanceCdP.jsp").include(request,response);
       
    }
	}
