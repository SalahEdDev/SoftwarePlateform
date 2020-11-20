package bean;

import java.util.Set;

public class Client {
	private Long id_client;
    private String nomCLT;
	private String prenomCLT;
    private String emailCLT;
    private String passwordCLT;
    private String cinCLT;
    private String githubCLT;
    private String adresseCLT;
    private String num_telephoneCLT;
    private Set<DemandeAdaptee> demande_adapteeCLT;
    private Set<DemandeMaintenance> demande_maintenanceCLT;
    
	public Long getId_client() {
		return id_client;
	}
	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}
	public String getNomCLT() {
		return nomCLT;
	}
	public void setNomCLT(String nomCLT) {
		this.nomCLT = nomCLT;
	}
	public String getPrenomCLT() {
		return prenomCLT;
	}
	public void setPrenomCLT(String prenomCLT) {
		this.prenomCLT = prenomCLT;
	}
	public String getEmailCLT() {
		return emailCLT;
	}
	public void setEmailCLT(String emailCLT) {
		this.emailCLT = emailCLT;
	}
	public String getPasswordCLT() {
		return passwordCLT;
	}
	public void setPasswordCLT(String passwordCLT) {
		this.passwordCLT = passwordCLT;
	}
	public String getCinCLT() {
		return cinCLT;
	}
	public void setCinCLT(String cinCLT) {
		this.cinCLT = cinCLT;
	}
	public String getGithubCLT() {
		return githubCLT;
	}
	public void setGithubCLT(String githubCLT) {
		this.githubCLT = githubCLT;
	}
	public String getAdresseCLT() {
		return adresseCLT;
	}
	public void setAdresseCLT(String adresseCLT) {
		this.adresseCLT = adresseCLT;
	}
	public String getNum_telephoneCLT() {
		return num_telephoneCLT;
	}
	public void setNum_telephoneCLT(String num_telephoneCLT) {
		this.num_telephoneCLT = num_telephoneCLT;
	}
	
	
	
	public Set<DemandeAdaptee> getDemande_adapteeCLT() {
		return demande_adapteeCLT;
	}
	public void setDemande_adapteeCLT(Set<DemandeAdaptee> demande_adapteeCLT) {
		this.demande_adapteeCLT = demande_adapteeCLT;
	}
	public Set<DemandeMaintenance> getDemande_maintenanceCLT() {
		return demande_maintenanceCLT;
	}
	public void setDemande_maintenanceCLT(Set<DemandeMaintenance> demande_maintenanceCLT) {
		this.demande_maintenanceCLT = demande_maintenanceCLT;
	}
	public Client() {
		
	}
	public Client(String nomCLT, String prenomCLT, String emailCLT, String passwordCLT, String cinCLT,
			String adresseCLT, String num_telephoneCLT) {
		super();
		this.nomCLT = nomCLT;
		this.prenomCLT = prenomCLT;
		this.emailCLT = emailCLT;
		this.passwordCLT = passwordCLT;
		this.cinCLT = cinCLT;
		this.adresseCLT = adresseCLT;
		this.num_telephoneCLT = num_telephoneCLT;
	}
}
