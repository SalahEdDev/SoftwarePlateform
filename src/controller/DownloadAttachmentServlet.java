package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import bean.DemandeMaintenance;
 
@WebServlet("/downloadAttachment")
public class DownloadAttachmentServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = null;
       try {
           // Get Database Connection.
           // (See more in JDBC Tutorial).
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esoft?useSSL=false", "root", "");
           Long id = null;
           try {
               id = Long.parseLong(request.getParameter("id"));
           } catch (Exception e) {
 
           }
           DemandeMaintenance dm = getAttachmentFromDB(conn, id);
 
           if (dm == null) {
               // No record found.
               response.getWriter().write("No data found");
               return;
           }
 
           // file1.zip, file2.zip

           System.out.println("File Name: " + "demande" + id + ".pdf");
 
           // abc.txt => text/plain
           // abc.zip => application/zip
           // abc.pdf => application/pdf
           String contentType = this.getServletContext().getMimeType("demande" + id + ".pdf");
           System.out.println("Content Type: " + contentType);
 
           response.setHeader("Content-Type", contentType);
 
           response.setHeader("Content-Length", String.valueOf(dm.getDocument_joindre().length()));
 
           response.setHeader("Content-Disposition", "inline; filename=\"" + "demande" + id + ".pdf" + "\"");
 
           // For big BLOB data.
           Blob DOCUMENT_JOINDRE = dm.getDocument_joindre();
           InputStream is = DOCUMENT_JOINDRE.getBinaryStream();
 
           byte[] bytes = new byte[1024];
           int bytesRead;
 
           while ((bytesRead = is.read(bytes)) != -1) {
               // Write image data to Response.
               response.getOutputStream().write(bytes, 0, bytesRead);
           }
           is.close();
 
       } catch (Exception e) {
           throw new ServletException(e);
       } finally {
           this.closeQuietly(conn);
       }
   }
 
   private DemandeMaintenance getAttachmentFromDB(Connection conn, Long id) throws SQLException {
       String sql = "Select DOCUMENT_JOINDRE"//
               + " from demandemaintenance where ID_DEMANDE_MAINTENANCE = ?";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setLong(1, id);
       ResultSet rs = pstm.executeQuery();
       if (rs.next()) {
           Blob DOCUMENT_JOINDRE = rs.getBlob("DOCUMENT_JOINDRE");
           return new DemandeMaintenance(DOCUMENT_JOINDRE);
       }
       return null;
   }
 
   private void closeQuietly(Connection conn) {
       try {
           if (conn != null) {
               conn.close();
           }
       } catch (Exception e) {
       }
   }
 
}