package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Client;
import bean.DemandeMaintenance;
import bean.Produit;

public class ClientDAO {
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

	public Client authentification(String email, String password) throws SQLException,
			   ClassNotFoundException {
				Connection conn = ClientDAO.getConnection();
				String sql = "select * from client where EMAIL = ? and PASSWORD = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, email);
				statement.setString(2, password);
				System.out.println(statement);
				ResultSet result = statement.executeQuery();
					
				Client client = null;
					
				if (result.next()) {
					    client = new Client();
					    client.setId_client(result.getLong(1));
					    client.setNomCLT(result.getString(2));
					    client.setPrenomCLT(result.getString(3));
					    client.setEmailCLT(result.getString(4));
					    client.setPasswordCLT(result.getString(5));	
					    client.setCinCLT(result.getString(6));
					    client.setAdresseCLT(result.getString(7));
					    client.setNum_telephoneCLT(result.getString(8));
				}	
				conn.close();	
			return client;
			}
	
	
	public boolean validate(Client client) throws ClassNotFoundException {
		boolean status = false;
		try{
			Connection conn = ClientDAO.getConnection();
			String sql = "INSERT INTO client (NOM, PRENOM, EMAIL, PASSWORD, CIN, ADRESSE, NUM_TELEPHONE) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, client.getNomCLT());
	        statement.setString(2, client.getPrenomCLT());
	        statement.setString(3, client.getEmailCLT());
	        statement.setString(4, client.getPasswordCLT());
	        statement.setString(5, client.getCinCLT());
	        statement.setString(6, client.getAdresseCLT());
	        statement.setString(7, client.getNum_telephoneCLT());
	        
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
	
	
	public static List<Client> getAll(){
	    List<Client> clients = new ArrayList<Client>();
	    try{
	        Connection conn = ChefDeProjetDAO.getConnection();
	        PreparedStatement ps = conn.prepareStatement("SELECT *FROM client");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	        	Client cl = new Client();
	        	cl.setId_client(rs.getLong(1));
	        	cl.setNomCLT(rs.getString(2));
	        	cl.setPrenomCLT(rs.getString(3));
	        	cl.setEmailCLT(rs.getString(4));
	        	cl.setPasswordCLT(rs.getString(5));
	        	cl.setCinCLT(rs.getString(6));
	        	cl.setAdresseCLT(rs.getString(7));
	        	cl.setNum_telephoneCLT(rs.getString(8));
	        	clients.add(cl);
	        }
	    return clients;
	    } catch(Exception e){}
	    return null;
	}
	
	public static int update(Client c){
        int status=0;
        try{
            Connection conn = DemandeMaintenanceDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement("update client set NOM=?, PRENOM=?, EMAIL=?, PASSWORD=?, CIN=?, ADRESSE=?, NUM_TELEPHONE=? where client.ID_CLIENT = ?");
            ps.setString(1, c.getNomCLT());
            ps.setString(2, c.getPrenomCLT());
            ps.setString(3, c.getEmailCLT());
            ps.setString(4, c.getPasswordCLT());
            ps.setString(5, c.getCinCLT());
            ps.setString(6, c.getAdresseCLT());
            ps.setString(7, c.getNum_telephoneCLT());
            ps.setLong(8, c.getId_client());
            status = ps.executeUpdate();
            conn.close();}
            catch(Exception e){System.out.println(e);}
            return status;
    }
	
	public static List<Client> getAll2(Long id){
        List<Client> clients = new ArrayList<Client>();
        try{
            Connection conn = ClientDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT *FROM client where client.ID_CLIENT = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	Client c = new Client();
            	c.setId_client((rs.getLong(1)));
            	c.setNomCLT(rs.getString(2));
            	c.setPrenomCLT(rs.getString(3));
            	c.setEmailCLT(rs.getString(4));
            	c.setPasswordCLT(rs.getString(5));
            	c.setCinCLT(rs.getString(6));
            	c.setAdresseCLT(rs.getString(7));
            	c.setNum_telephoneCLT(rs.getString(8));
            	clients.add(c);
            }
        return clients;
        } catch(Exception e){}
        return null;
}
}
