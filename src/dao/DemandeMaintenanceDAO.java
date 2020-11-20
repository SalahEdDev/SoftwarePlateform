package dao;


import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.ChefDeProjet;
import bean.Client;
import bean.DemandeAdaptee;
import bean.DemandeMaintenance;

public class DemandeMaintenanceDAO {
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

	    public static int save(DemandeMaintenance dm, InputStream file, long id){
	        int status=0;
	        try{
	            Connection conn = DemandeMaintenanceDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("insert into demandemaintenance(ID_CLIENT, SUJET, DESCRIPTION, DOCUMENT_JOINDRE, OBSERVATION_COMPLEMENTAIRE)  values(?,?,?,?,?)");
	            ps.setLong(1, id);
	            ps.setString(2, dm.getSujet());
	            ps.setString(3, dm.getDescription());
	            if (file != null) {
	                ps.setBlob(4, file);
	            }
	            ps.setString(5, dm.getObservation_complementaire());

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	    
	    public static int update(DemandeMaintenance dm, long l){
	        int status=0;
	        try{
	            Connection conn = DemandeMaintenanceDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("update demandemaintenance set ID_CHEF_PROJET = ? where demandemaintenance.ID_DEMANDE_MAINTENANCE = ?");
	            ps.setLong(1, l);
	            ps.setLong(2, dm.getId_demande_maintenance());

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	    
	    public static int updateEtat(DemandeMaintenance dm){
	        int status=0;
	        try{
	            Connection conn = DemandeMaintenanceDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("update demandemaintenance set etat = 1 where demandemaintenance.ID_DEMANDE_MAINTENANCE = ?");
	            ps.setLong(1, dm.getId_demande_maintenance());

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	    
	    public static int updateEtat2(Long id, int etat){
	        int status=0;
	        try{
	            Connection conn = DemandeMaintenanceDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("update demandemaintenance set etat = ? where demandemaintenance.ID_DEMANDE_MAINTENANCE = ?");
	            ps.setInt(1, etat);
	            ps.setLong(2, id);

	            status = ps.executeUpdate();
	            conn.close();}
	            catch(Exception e){System.out.println(e);}
	            return status;
	    }
	   
	    
	    public static List<DemandeMaintenance> getAll(){
	        List<DemandeMaintenance> demandesMaintenance = new ArrayList<DemandeMaintenance>();
	        try{
	            Connection conn = DemandeMaintenanceDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT *FROM demandemaintenance INNER JOIN client ON demandemaintenance.ID_CLIENT = client.ID_CLIENT");
	            ResultSet rs = ps.executeQuery();
	            
	            while(rs.next()){
	            	DemandeMaintenance dm = new DemandeMaintenance();
	            	Client client = new Client();
	            	ChefDeProjet cp = new ChefDeProjet();
	            	dm.setId_demande_maintenance(rs.getLong(1));
	            	dm.setSujet(rs.getString(4));
	            	dm.setDescription(rs.getString(5));
	            	dm.setDocument_joindre(rs.getBlob(6));
	            	dm.setObservation_complementaire(rs.getString(7));
	            	dm.setEtat(rs.getInt(8));
	            	demandesMaintenance.add(dm);
	            	client.setNomCLT(rs.getString("NOM"));
	            	client.setId_client(rs.getLong("ID_CLIENT"));
	            	client.setPrenomCLT(rs.getString("PRENOM"));
	            	client.setEmailCLT(rs.getString("EMAIL"));
	            	client.setPasswordCLT(rs.getString("PASSWORD"));
	            	client.setCinCLT(rs.getString("CIN"));
	            	client.setAdresseCLT(rs.getString("ADRESSE"));
	            	client.setNum_telephoneCLT(rs.getString("NUM_TELEPHONE"));
	            	
	            	/*cp.setNomCP(rs.getString("NOM"));
	            	cp.setId_chef_projet(rs.getLong("ID_CHEF_PROJET"));
	            	cp.setPrenomCP(rs.getString("PRENOM"));
	            	cp.setEmailCP(rs.getString("EMAIL"));
	            	cp.setPasswordCP(rs.getString("PASSWORD"));
	            	cp.setCinCP(rs.getString("CIN"));
	            	cp.setAdresseCP(rs.getString("ADRESSE"));
	            	cp.setNum_telephoneCP(rs.getString("NUM_TELEPHONE"));*/
	
	            	dm.setClient(client);
	            	dm.setChefDeProjet(cp);
	            }
	        return demandesMaintenance;
	        } catch(Exception e){}
	        return null;
	}
	    
	    public static List<DemandeMaintenance> getAll2(Long id){
	    	System.out.println("*******************1");
	        List<DemandeMaintenance> demandesMaintenance = new ArrayList<DemandeMaintenance>();
	        try{
	            Connection conn = DemandeMaintenanceDAO.getConnection();
	            PreparedStatement ps = conn.prepareStatement("SELECT *FROM demandemaintenance where demandemaintenance.ID_CLIENT = ?");
	            ps.setLong(1, id);
	            ResultSet rs = ps.executeQuery();
	            System.out.println("*******************2");
	            while(rs.next()){
	            	DemandeMaintenance dm = new DemandeMaintenance();
	            	//Client client = new Client();
	            	System.out.println("id demande ="+rs.getLong(1));
	            	dm.setId_demande_maintenance(rs.getLong(1));
	            	dm.setSujet(rs.getString(4));
	            	dm.setDescription(rs.getString(5));
	            	dm.setDocument_joindre(rs.getBlob(6));
	            	dm.setObservation_complementaire(rs.getString(7));
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
	            	demandesMaintenance.add(dm);
	            	
	            }
	        return demandesMaintenance;
	        } catch(Exception e){}
	        return null;
	}
	    
	    public static DemandeMaintenance getDemandeMaintenanceById(int demandeMaintenanceID) {
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
		}
}
