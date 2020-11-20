package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Produit;
import dao.ProduitDAO;

/**
 * Servlet implementation class ViewImageSoft
 */
@WebServlet("/ViewImageSoft")
public class ViewImageSoft extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewImageSoft() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Produit getImageInTable(Connection conn, Long id) throws SQLException {
        String sql = "Select ID_PRODUIT, NOM ,PRIX , DOCUMENT, IMAGE,IMAGE_FILE_NAME "//
                + " from produit where ID_PRODUIT = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setLong(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            String nom = rs.getString("NOM");
            Double prix = rs.getDouble("PRIX");
            Blob document = rs.getBlob("DOCUMENT");
            byte[] imageData = rs.getBytes("IMAGE");
            String imageFileName = rs.getString("IMAGE_FILE_NAME");
            return new Produit(id, nom , prix, imageData,imageFileName  ,document);
        }
        return null;
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        try {
            // Get Database Connection.
           // (See more in JDBC Tutorial)
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esoft?useSSL=false", "root", "");
            Long id = null;
            try {
                id = Long.parseLong(request.getParameter("id"));
            } catch (Exception e) {
   
            }
            Produit produit = getImageInTable(conn, id);
   
            if (produit == null) {
                // No record found, redirect to default image.
            	response.sendRedirect(request.getContextPath() + "/images/noimage.png");
                return;
            }

          
            // trump.jpg, putin.png
            String imageFileName = produit.getImageFileName();
            System.out.println("File Name: "+ imageFileName);
          
            // image/jpg
            // image/png
            String contentType = this.getServletContext().getMimeType(imageFileName);
            System.out.println("Content Type: "+ contentType);
          
            response.setHeader("Content-Type", contentType);
          
            response.setHeader("Content-Length", String.valueOf(produit.getImageData().length));
          
            response.setHeader("Content-Disposition", "inline; filename=\"" + produit.getImageFileName() + "\"");
   
            // Write image data to Response.
            response.getOutputStream().write(produit.getImageData());
   
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
