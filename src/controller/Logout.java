package controller;
 
import java.io.IOException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/Logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public Logout() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            /*session.removeAttribute("user");
            session.removeAttribute("administrateurTechnique");
            session.removeAttribute("chefDeProjet");*/
            session.invalidate();  
        	
        	//request.getSession().invalidate();
            response.getWriter().println("Session : " + session);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("acceuilClient.jsp");
            dispatcher.forward(request, response);
    	
        
    }
    }
}