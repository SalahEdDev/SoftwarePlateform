package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChefDeProjet;
import bean.Client;
import dao.ChefDeProjetDAO;
import dao.ClientDAO;

/**
 * Servlet implementation class ChefProjetRegisterServlet
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
   	    PrintWriter out = response.getWriter();
    	String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cin = request.getParameter("cin");
        String github = request.getParameter("github");
        String adresse = request.getParameter("adresse");
        String num_telephone = request.getParameter("num_telephone");
        
        //////////Chef de Projet
        
        
        ChefDeProjet cp = new ChefDeProjet();
        cp.setNomCP(nom);
        cp.setPrenomCP(prenom);
        cp.setEmailCP(email);
        cp.setPasswordCP(password);
        cp.setGithubCP(github);
        cp.setAdresseCP(adresse);
        cp.setNum_telephoneCP(num_telephone);        
        try {	
        	ChefDeProjetDAO chefProjetRegisterDao = new ChefDeProjetDAO();
	   		 out.println("<html>");
	   		 out.println("<head>");		
	   		 out.println("<title>Registration Successful</title>");		
	   		 out.println("</head>");
	   		 out.println("<body>");
	   		 out.println("<center>");
	   		 if(!chefProjetRegisterDao.validate(cp)){
	   			 out.println("<h1>Thanks for Registering with us :</h1>");
	   			 out.println("To login with your Email and Password<a href=login.jsp>Click here</a>");
	   		 }else{
	   			 out.println("<h1>Registration Failed</h1>");
	   			 out.println("To try again<a href=registerChefProjet.jsp>Click here</a>");
	   		 }
	   		 out.println("</center>");
	   		 out.println("</body>");
	   		 out.println("</html>");
   	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   } 
        
        //////////////////////////////
        /////Client
        
        Client client = new Client();
        client.setNomCLT(nom);
        client.setPrenomCLT(prenom);
        client.setEmailCLT(email);
        client.setPasswordCLT(password);
        client.setCinCLT(cin);
        client.setAdresseCLT(adresse);
        client.setNum_telephoneCLT(num_telephone);    
        try {	
        ClientDAO clientDAO = new ClientDAO();
  		 out.println("<html>");
  		 out.println("<head>");		
  		 out.println("<title>Registration Successful</title>");		
  		 out.println("</head>");
  		 out.println("<body>");
  		 out.println("<center>");
  		 if(!clientDAO.validate(client)){
  			 out.println("<h1>Thanks for Registering with us :</h1>");
  			 out.println("To login with your Email and Password<a href=login.jsp>Click here</a>");
  		 }else{
  			 out.println("<h1>Registration Failed</h1>");
  			 out.println("To try again<a href=registerClient.jsp>Click here</a>");
  		 }
  		 out.println("</center>");
  		 out.println("</body>");
  		 out.println("</html>");
	 } catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	 }       
        finally {		
   		 out.close();
   	 }
    }

}
