package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ChefDeProjet;
import bean.Client;


public class ChefDeProjetDAO {
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

	public ChefDeProjet authentification(String email, String password) throws SQLException,
			   ClassNotFoundException {
				Connection conn = ChefDeProjetDAO.getConnection();
				String sql = "select * from chef_de_projet where EMAIL = ? and PASSWORD = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, email);
				statement.setString(2, password);
				System.out.println(statement);
				ResultSet result = statement.executeQuery();
					
				ChefDeProjet chefDeProjet = null;
					
				if (result.next()) {
						chefDeProjet = new ChefDeProjet();
						chefDeProjet.setId_chef_projet(result.getLong(1));
						chefDeProjet.setNomCP(result.getString(2));
						chefDeProjet.setPrenomCP(result.getString(3));
						chefDeProjet.setEmailCP(result.getString(4));
						chefDeProjet.setPasswordCP(result.getString(5));	
						chefDeProjet.setGithubCP(result.getString(6));
					    chefDeProjet.setAdresseCP(result.getString(7));
					    chefDeProjet.setNum_telephoneCP(result.getString(8));
				}	
				conn.close();	
			return chefDeProjet;
			}
	
	public static long getId(String nom){
        long a = 0;
        try {
        	Connection conn = ChefDeProjetDAO.getConnection();
        	String sql = "select ID_CHEF_PROJET from chef_de_projet where NOM=? ";
        	PreparedStatement statement = conn.prepareStatement(sql);
        	statement.setString(1, nom);
            ResultSet res = statement.executeQuery(sql);
            if(res.next()){
                a = res.getLong(1);
            }
        }catch (Exception e){

        }

        return a ;
    }
	
	public boolean validate(ChefDeProjet chef_de_projet) throws ClassNotFoundException {
		boolean status = false;
		try{
			Connection conn = ChefDeProjetDAO.getConnection();
			String sql = "INSERT INTO chef_de_projet (NOM, PRENOM, EMAIL, PASSWORD, GITHUB, ADRESSE, NUM_TELEPHONE) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, chef_de_projet.getNomCP());
	        statement.setString(2, chef_de_projet.getPrenomCP());
	        statement.setString(3, chef_de_projet.getEmailCP());
	        statement.setString(4, chef_de_projet.getPasswordCP());
	        statement.setString(5, chef_de_projet.getGithubCP());
	        statement.setString(6, chef_de_projet.getAdresseCP());
	        statement.setString(7, chef_de_projet.getNum_telephoneCP());
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;		
    }
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
	
	public static int update(ChefDeProjet cp){
        int status=0;
        try{
            Connection conn = ChefDeProjetDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement("update chef_de_projet set NOM=?, PRENOM=?, EMAIL=?, PASSWORD=?, GITHUB=?, ADRESSE=?, NUM_TELEPHONE=? where ID_CHEF_PROJET= ?");
            ps.setString(1, cp.getNomCP());
            ps.setString(2, cp.getPrenomCP());
            ps.setString(3, cp.getEmailCP());
            ps.setString(4, cp.getPasswordCP());
            ps.setString(5, cp.getGithubCP());
            ps.setString(6, cp.getAdresseCP());
            ps.setString(7, cp.getNum_telephoneCP());
            ps.setLong(8, cp.getId_chef_projet());
            status = ps.executeUpdate();
            conn.close();}
            catch(Exception e){System.out.println(e);}
            return status;
    }
	
	public static List<ChefDeProjet> getAll(){
        List<ChefDeProjet> chefsDeProjet = new ArrayList<ChefDeProjet>();
        try{
            Connection conn = ChefDeProjetDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT *FROM chef_de_projet");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	ChefDeProjet cp = new ChefDeProjet();
            	cp.setId_chef_projet(rs.getLong(1));
            	cp.setNomCP(rs.getString(2));
            	cp.setPrenomCP(rs.getString(3));
            	cp.setEmailCP(rs.getString(4));
            	cp.setPasswordCP(rs.getString(5));
            	cp.setGithubCP(rs.getString(6));
            	cp.setAdresseCP(rs.getString(7));
            	cp.setNum_telephoneCP(rs.getString(8));
            	chefsDeProjet.add(cp);
            }
        return chefsDeProjet;
        } catch(Exception e){}
        return null;
}
	public static List<ChefDeProjet> getAll2(Long id){
		List<ChefDeProjet> chefsDeProjet = new ArrayList<ChefDeProjet>();
        try{
            Connection conn = ChefDeProjetDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT *FROM chef_de_projet where chef_de_projet.ID_CHEF_PROJET= ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	ChefDeProjet cp = new ChefDeProjet();
            	cp.setId_chef_projet((rs.getLong(1)));
            	cp.setNomCP(rs.getString(2));
            	cp.setPrenomCP(rs.getString(3));
            	cp.setEmailCP(rs.getString(4));
            	cp.setPasswordCP(rs.getString(5));
            	cp.setGithubCP(rs.getString(6));
            	cp.setAdresseCP(rs.getString(7));
            	cp.setNum_telephoneCP(rs.getString(8));
            	chefsDeProjet.add(cp);
            }
        return chefsDeProjet;
        } catch(Exception e){}
        return null;
}
}
