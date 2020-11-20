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
import bean.DemandeAdaptee;
import dao.DemandeAdapteeDAO;



/**
 * Servlet implementation class EnvoyerDemandeMaintenance
 */
@WebServlet("/EnvoyerDemandeAdaptee")
public class EnvoyerDemandeAdaptee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvoyerDemandeAdaptee() {
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
		String message = new String();
		String id2 = request.getParameter("id2");
		if(id3 == null) {System.out.println("jad");}else {System.out.println("finish");}

        if (id2 != null && !id2.isEmpty()) {
        	DemandeAdaptee demandeAdaptee = new DemandeAdaptee();        
        	demandeAdaptee.setId_demande_adaptee(Long.parseLong(id3));
            DemandeAdapteeDAO.update(demandeAdaptee, Long.parseLong(id2));
          
        }
        message ="La demande a été envoyée au CdP selectionné. Cliquer ici pour revenir à : ";
 	    request.setAttribute("message", message);
        request.getRequestDispatcher("envoyerAdapteeCdP.jsp").include(request,response);
       
    }
	}
