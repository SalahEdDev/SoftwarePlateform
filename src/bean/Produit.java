package bean;


import java.io.InputStream;
import java.sql.Blob;
import java.util.Set;

public class Produit {
	private Long id_produit;
	private String nom;
	private Double prix;
	private byte[] imageData;
	//private InputStream image;
    private String imageFileName;
    private String description;
	private Blob document;
	private Set<Commande> commandes;
	public Long getId_produit() {
		return id_produit;
	}
	public void setId_produit(Long id_produit) {
		this.id_produit = id_produit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public Blob getDocument() {
		return document;
	}
	public void setDocument(Blob document) {
		this.document = document;
	}
	
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Produit(Blob document) {
		this.document=document;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	public Produit() {
		
	}
	
	public Produit(String nom, Double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}
	public Produit(Long id_produit, String nom, Double prix,byte[] imageData, String imageFileName, Blob document) {
		super();
		this.id_produit = id_produit;
		this.nom = nom;
		this.prix = prix;
		this.imageData =imageData;
		this.imageFileName = imageFileName;
		this.document = document;
	}
	public Produit(Long id_produit, String nom, Double prix, String description) {
		super();
		this.id_produit = id_produit;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
	}
	public Produit(String nom, Double prix, String description) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.description = description;
	}
	public Produit(String nom, Double prix, byte[] imageData, String description) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.imageData = imageData;
		this.description = description;
	}
	
	/*public Produit(String nom, Double prix, InputStream image, String description) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.image = image;
		this.description = description;
	}*/
	public Produit(Long id_produit, String nom, Double prix, byte[] imageData, String description) {
		super();
		this.id_produit = id_produit;
		this.nom = nom;
		this.prix = prix;
		this.imageData = imageData;
		this.description = description;
	}
	
	
}