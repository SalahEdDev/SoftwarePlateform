package bean;

public class AdministrateurTechnique {
	private Long id_admin_technique;
    private String nomAT;
	private String prenomAT;
    private String emailAT;
    private String passwordAT;
    private String cinAT;
    private String githubAT;
    private String adresseAT;
    private String num_telephoneAT;
    
    
    
	public Long getId_admin_technique() {
		return id_admin_technique;
	}
	public void setId_admin_technique(Long id_admin_technique) {
		this.id_admin_technique = id_admin_technique;
	}
	public String getNomAT() {
		return nomAT;
	}
	public void setNomAT(String nomAT) {
		this.nomAT = nomAT;
	}
	public String getPrenomAT() {
		return prenomAT;
	}
	public void setPrenomAT(String prenomAT) {
		this.prenomAT = prenomAT;
		
	}
	public String getEmailAT() {
		return emailAT;
	}
	public void setEmailAT(String emailAT) {
		this.emailAT = emailAT;
	}
	public String getPasswordAT() {
		return passwordAT;
	}
	public void setPasswordAT(String passwordAT) {
		this.passwordAT = passwordAT;
	}
	public String getCinAT() {
		return cinAT;
	}
	
	public String getGithubAT() {
		return githubAT;
	}
	public void setGithubAT(String githubAT) {
		this.githubAT = githubAT;
	}
	public void setCinAT(String cinAT) {
		this.cinAT = cinAT;
	}
	public String getAdresseAT() {
		return adresseAT;
	}
	public void setAdresseAT(String adresseAT) {
		this.adresseAT = adresseAT;
	}
	public String getNum_telephoneAT() {
		return num_telephoneAT;
	}
	public void setNum_telephoneAT(String num_telephoneAT) {
		this.num_telephoneAT = num_telephoneAT;
	}
	public AdministrateurTechnique() {
		
	}
	public AdministrateurTechnique(String nomAT, String prenomAT, String emailAT, String passwordAT, String cinAT,
			String adresseAT, String num_telephoneAT) {
		super();
		this.nomAT = nomAT;
		this.prenomAT = prenomAT;
		this.emailAT = emailAT;
		this.passwordAT = passwordAT;
		this.cinAT = cinAT;
		this.adresseAT = adresseAT;
		this.num_telephoneAT = num_telephoneAT;
	}
	
}
