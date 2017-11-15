package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * 
 * Class Categorie has the following attributes : 
 * <ul>
 * <li> id (int)
 * <li> nomCategorie (String)
 * <li> description (String)
 * <li> listeProduits (List Produit)
 * </ul>
 * 
 * 
 *
 * 
 */

@Entity
@Table(name="categories")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ca")
	@Range(min=0, message="Veuillez entrer un ID positif.")
	private long id;
	@NotEmpty(message="Veuillez entrer le nom de la catégorie.")
	@Column(name="nomCategorie_ca")
	private String nomCategorie;
	@Length(min=1, max=50, message="Veuillez entrer une description de catégorie d'une longueur entre 1 et 50.")
	@Column(name="description_ca")
	private String description;
	@OneToMany(mappedBy="categorie", cascade=CascadeType.REMOVE)
	private List<Produit> listeProduits;
	
	//Constructeurs
	public Categorie() {
		super();
	}
	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	public Categorie(long id, String nomCategorie, String description) {
		super();
		this.id = id;
		this.nomCategorie = nomCategorie;
		this.description = description;
	}
	
	//Getters et setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	//Méthodes métier
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomCategorie=" + nomCategorie + ", description=" + description + "]";
	}
}
