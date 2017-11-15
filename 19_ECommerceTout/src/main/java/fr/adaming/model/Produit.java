package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * 
 * Class Categorie has the following attributes : 
 * <ul>
 * <li> id (int)
 * <li> designation (String)
 * <li> description (String)
 * <li> prix (double)
 * <li> quantite (int)
 * <li> image (byte[])
 * <li> categorie (Categorie)
 * <li> listeLigneCommande (List LigneCommande)
 * </ul>
 * 
 * 
 *
 * 
 */


@Entity
@Table(name="produits")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pr")
	private long id;
	@NotEmpty(message="Veuillez entrer le nom du produit")
	@Column(name="designation_pr")
	private String designation;
	@NotEmpty(message="Veuillez entrer la description du produit")
	@Column(name="description_pr")
	private String description;
	@Column(name="prix_pr")
	private double prix;
	@Column(name="quantite_pr")
	private int quantite;
	@Lob
	private byte[] image;
	@ManyToOne
	@JoinColumn(name="id_ca", referencedColumnName="id_ca")
	private Categorie categorie;
	@OneToMany(mappedBy="produit")
	private List<LigneCommande> listeLigneCommande;
	
	
	//Constructeurs
	public Produit() {
		super();
	}
	public Produit(String designation, String description, double prix, int quantite) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit(long id, String designation, String description, double prix, int quantite) {
		super();
		this.id = id;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	//Getters et setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}
	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	//M�thodes propres
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", description=" + description
				+ ", prix=" + prix + ", quantite=" + quantite + "]";
	}
}
