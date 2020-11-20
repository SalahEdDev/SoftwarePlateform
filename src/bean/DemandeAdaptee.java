package bean;

import java.sql.Blob;

public class DemandeAdaptee{
	private Long id_demande_adaptee;
	private String sujet;
	private String description;
	private Blob document_joindre;
	private double capaciteFinancement;
	private int etat;
	private Client client;
	private ChefDeProjet chefDeProjet;
	
	public Long getId_demande_adaptee() {
		return id_demande_adaptee;
	}
	public void setId_demande_adaptee(Long id_demande_adaptee) {
		this.id_demande_adaptee = id_demande_adaptee;
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
	public double getCapaciteFinancement() {
		return capaciteFinancement;
	}
	public void setCapaciteFinancement(double capaciteFinancement) {
		this.capaciteFinancement = capaciteFinancement;
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
	public DemandeAdaptee() {
	
	}
	
	public DemandeAdaptee(Blob document_joindre) {
		this.document_joindre=document_joindre;
	}
	
	
}