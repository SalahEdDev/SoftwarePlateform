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
import bean.DemandeAdaptee;

import dao.ChefDeProjetDAO;
import dao.DemandeAdapteeDAO;


/**
 * Servlet implementation class DemandeMaintenanceServlet
 */
@WebServlet("/DemandeAdapteeServlet")
@MultipartConfig(maxFileSize = 16177215)
public class DemandeAdapteeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private DemandeMaintenanceDAO demandeMaintenanceDAO;

    
    DemandeAdapteeDAO demandeAdapteeDAO = new DemandeAdapteeDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeAdapteeServlet() {
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/traiterDemandeAdaptee.jsp");
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
        
        InputStream inputStream = null;
        Part filePart = request.getPart("file");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        
        String capaciteFinancement = request.getParameter("capaciteFinancement");
        
        DemandeAdaptee demandeAdaptee = new DemandeAdaptee();
        demandeAdaptee.setSujet(sujet);
        demandeAdaptee.setDescription(description);
        demandeAdaptee.setCapaciteFinancement(Double.parseDouble(capaciteFinancement));
        
        DemandeAdapteeDAO.save(demandeAdaptee, inputStream, id);
        request.getRequestDispatcher("demandeAdaptee.jsp").include(request,response);
	}

}
