package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ChefDeProjet;
import bean.Client;
import bean.DemandeAdaptee;
import bean.DemandeMaintenance;

public class DemandeAdapteeDAO {
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

	    public static int save(DemandeAdaptee da, InputStream file, long id){
	        int status=0;
	        try{
	            Connection conn = DemandeAdapteeDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("insert into demandeadaptee(ID_CLIENT, SUJET, DESCRIPTION, DOCUMENT_JOINDRE, CAPACITE_FINANCEMENT)  values(?,?,?,?,?)");
	            ps.setLong(1, id);
	            ps.setString(2, da.getSujet());
	            ps.setString(3, da.getDescription());
	            if (file != null) {
	                ps.setBlob(4, file);
	            }
	            ps.setDouble(5, da.getCapaciteFinancement());

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	    public static int update(DemandeAdaptee da, long l){
	        int status=0;
	        try{
	            Connection conn = DemandeAdapteeDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("update demandeadaptee set ID_CHEF_PROJET = ? where demandeadaptee.ID_DEMANDE_ADAPTEE = ?");
	            ps.setLong(1, l);
	            ps.setLong(2, da.getId_demande_adaptee());

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	    
	    public static int updateEtat(DemandeAdaptee da){
	        int status=0;
	        try{
	            Connection conn = DemandeAdapteeDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("update demandeadaptee set etat = 1 WHERE demandeadaptee.ID_DEMANDE_ADAPTEE = ?");
	            ps.setLong(1, da.getId_demande_adaptee());

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	    
	    public static int updateEtat2(Long id, int etat){
	        int status=0;
	        try{
	            Connection conn = DemandeAdapteeDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("update demandeadaptee set etat = ? where demandeadaptee.ID_DEMANDE_ADAPTEE = ?");
	            ps.setInt(1, etat);
	            ps.setLong(2, id);

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	   
	    
	    public static List<DemandeAdaptee> getAll(){
	        List<DemandeAdaptee> demandesAdaptee = new ArrayList<DemandeAdaptee>();
	        try{
	            Connection conn = DemandeAdapteeDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT *FROM demandeadaptee INNER JOIN client ON demandeadaptee.ID_CLIENT = client.ID_CLIENT");
	            ResultSet rs = ps.executeQuery();
	            
	            while(rs.next()){
	            	DemandeAdaptee da = new DemandeAdaptee();
	            	Client client = new Client();
	            	ChefDeProjet cp = new ChefDeProjet();
	            	da.setId_demande_adaptee(rs.getLong(1));
	            	da.setSujet(rs.getString(4));
	            	da.setDescription(rs.getString(5));
	            	da.setDocument_joindre(rs.getBlob(6));
	            	da.setCapaciteFinancement(rs.getDouble(7));
	            	da.setEtat(rs.getInt(8));
	            	demandesAdaptee.add(da);
	            	
	            	client.setNomCLT(rs.getString("NOM"));
	            	client.setId_client(rs.getLong("ID_CLIENT"));
	            	client.setPrenomCLT(rs.getString("PRENOM"));
	            	client.setEmailCLT(rs.getString("EMAIL"));
	            	client.setPasswordCLT(rs.getString("PASSWORD"));
	            	client.setCinCLT(rs.getString("CIN"));
	            	client.setAdresseCLT(rs.getString("ADRESSE"));
	            	client.setNum_telephoneCLT(rs.getString("NUM_TELEPHONE"));
	
	            	da.setClient(client);
	            	da.setChefDeProjet(cp);
	            }
	        return demandesAdaptee;
	        } catch(Exception e){}
	        return null;
	}
	    
	    public static List<DemandeAdaptee> getAll2(Long id){
	    	System.out.println("*******************1");
	        List<DemandeAdaptee> demandesAdaptee = new ArrayList<DemandeAdaptee>();
	        try{
	            Connection conn = DemandeAdapteeDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT *FROM demandeadaptee where demandeadaptee.ID_CLIENT = ?");
	            ps.setLong(1, id);
	            ResultSet rs = ps.executeQuery();
	            System.out.println("*******************2");
	            while(rs.next()){
	            	DemandeAdaptee dm = new DemandeAdaptee();
	            	
	            	System.out.println("id demande ="+rs.getLong(1));
	            	dm.setId_demande_adaptee(rs.getLong(1));
	            	dm.setSujet(rs.getString(4));
	            	dm.setDescription(rs.getString(5));
	            	dm.setDocument_joindre(rs.getBlob(6));
	            	dm.setCapaciteFinancement(rs.getDouble(7));
	            	dm.setEtat(rs.getInt(8));
	            	/*client.setNomCLT(rs.getString("NOM"));
	            	client.setId_client(rs.getLong("ID_CLIENT"));
	            	client.setPrenomCLT(rs.getString("PRENOM"));
	            	client.setEmailCLT(rs.getString("EMAIL"));
	            	client.setPasswordCLT(rs.getString("PASSWORD"));
	            	client.setCinCLT(rs.getString("CIN"));
	            	client.setAdresseCLT(rs.getString("ADRESSE"));
	            	client.setNum_telephoneCLT(rs.getString("NUM_TELEPHONE"));
	            	dm.setClient(client);*/
	            	demandesAdaptee.add(dm);
	            	
	            }
	        return demandesAdaptee;
	        } catch(Exception e){}
	        return null;
	}
	    
	    /*public static DemandeMaintenance getDemandeMaintenanceById(int demandeMaintenanceID) {
	    	DemandeMaintenance dm = new DemandeMaintenance();
			try {
				Connection connection = DemandeMaintenanceDAO.getConnection();
				PreparedStatement preparedStatement = connection.
						prepareStatement("select * from demandemaintenance where ID_DEMANDE_MAINTENANCE= "+demandeMaintenanceID+"");
				preparedStatement.setInt(1, demandeMaintenanceID);
				ResultSet rs = preparedStatement.executeQuery();
				
				if (rs.next()) {
					dm.setId_demande_maintenance(rs.getLong(1));
					
	            	dm.setSujet(rs.getString(4));
	            	dm.setDescription(rs.getString(5));
	            	dm.setDocument_joindre(rs.getBlob(6));
	            	dm.setObservation_complementaire(rs.getString(7));
	            	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return dm;
		}*/


}
