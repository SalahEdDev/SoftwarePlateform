package dao;

import bean.DemandeMaintenance;

public class Test {

	public static void main(String[] args) {
		DemandeMaintenance dm = new DemandeMaintenance();
		dm.setId_demande_maintenance((long) 8);
		DemandeMaintenanceDAO.update(dm, 1);

	}

}
