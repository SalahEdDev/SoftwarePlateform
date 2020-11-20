package bean;


import java.sql.Blob;

public class DemandeMaintenance{
	private Long id_demande_maintenance;
	private String sujet;
	private String description;
	private Blob document_joindre;
	private String observation_complementaire;
	private int etat;
	private Client client;
	private ChefDeProjet chefDeProjet;
	
	public Long getId_demande_maintenance() {
		return id_demande_maintenance;
	}
	public void setId_demande_maintenance(Long id_demande_maintenance) {
		this.id_demande_maintenance = id_demande_maintenance;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getDocument_joindre() {
		return document_joindre;
	}
	public void setDocument_joindre(Blob document_joindre) {
		this.document_joindre = document_joindre;
	}
	
	public String getObservation_complementaire() {
		return observation_complementaire;
	}
	public void setObservation_complementaire(String observation_complementaire) {
		this.observation_complementaire = observation_complementaire;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public ChefDeProjet getChefDeProjet() {
		return chefDeProjet;
	}
	public void setChefDeProjet(ChefDeProjet chefDeProjet) {
		this.chefDeProjet = chefDeProjet;
	}

	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public DemandeMaintenance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DemandeMaintenance(Blob document_joindre) {
		this.document_joindre=document_joindre;
	}	
}
