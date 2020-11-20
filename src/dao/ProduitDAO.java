package dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.Blob;
import java.util.Base64;

import bean.Commande;
import bean.Produit;

public class ProduitDAO {
public static Connection getConnection(){
	    
	    Connection conn = null;
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/esoft?useSSL=false", "root", "");
	    
	    }catch(Exception e){
	            System.out.println(e);
	    }
	        return conn;
	    }

	    public static int save(Produit p, InputStream file, InputStream inputStream){
	        int status=0;
	        try{
	            Connection conn = ProduitDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("insert into produit(NOM, PRIX, DOCUMENT, IMAGE)  values(?,?,?,?)");
	            ps.setString(1, p.getNom());
	            ps.setDouble(2, p.getPrix());
	            if (file != null) {
	                ps.setBlob(3, file);
	            }
	            if (inputStream != null) {
	                ps.setBlob(4, inputStream);
	            }

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	    public static List<Produit> getAll(){
	        List<Produit> produits = new ArrayList<Produit>();
	        try{
	            Connection conn = ProduitDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT *FROM produit");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	            	Produit p = new Produit();
	            	p.setId_produit(rs.getLong(1));
	            	p.setNom(rs.getString(2));
	            	p.setDescription(rs.getString(3));
	            	p.setPrix(rs.getDouble(4));
	            	p.setDocument(rs.getBlob(5));
	            	produits.add(p);
	            }
	        return produits;
	        } catch(Exception e){}
	        return null;
	}
	    
	    
}
