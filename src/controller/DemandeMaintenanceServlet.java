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

import bean.ChefDeProjet;
import bean.DemandeMaintenance;

import dao.ChefDeProjetDAO;
import dao.DemandeMaintenanceDAO;

/**
 * Servlet implementation class DemandeMaintenanceServlet
 */
@WebServlet("/DemandeMaintenanceServlet")
@MultipartConfig(maxFileSize = 16177215)
public class DemandeMaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private DemandeMaintenanceDAO demandeMaintenanceDAO;

    
    DemandeMaintenanceDAO demandeMaintenanceDAO = new DemandeMaintenanceDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeMaintenanceServlet() {
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/traiterDemande.jsp");
        dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

		long id = (long) session.getAttribute("id");

        String sujet = request.getParameter("sujet");
        String description = request.getParameter("description");
        String message = new String();
        
        InputStream inputStream = null;
        Part filePart = request.getPart("file");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        
        String observation_complementaire = request.getParameter("observation_complementaire");
        
        DemandeMaintenance demandeMaintenance = new DemandeMaintenance();
        demandeMaintenance.setSujet(sujet);
        demandeMaintenance.setDescription(description);
        demandeMaintenance.setObservation_complementaire(observation_complementaire);
        
        DemandeMaintenanceDAO.save(demandeMaintenance, inputStream, id);
        message ="La demande a été envoyée avec succès. Cliquer ici pour revenir à la liste des demandes : ";
 	    request.setAttribute("message", message);
        request.getRequestDispatcher("demandeMaintenanceSuccess.jsp").include(request,response);
	}

}
