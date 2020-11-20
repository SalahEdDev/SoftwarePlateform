package controller;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
import com.paypal.base.rest.PayPalRESTException;

import bean.Paiement;
import bean.Produit;
 
@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AuthorizePaymentServlet() {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom_produit = request.getParameter("nom_produit");
        String prix_produit = request.getParameter("prix_produit");
        
        Produit produit = new Produit(nom_produit, Double.parseDouble(prix_produit)); 
 
        try {
            Paiement paymentServices = new Paiement();
            String approvalLink = paymentServices.authorizePayment(produit);
 
            response.sendRedirect(approvalLink);
             
        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
 
}