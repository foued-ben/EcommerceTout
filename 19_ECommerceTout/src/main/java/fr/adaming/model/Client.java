


package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 *
 * Class Client has the following attributes : 
 * <ul>
 * <li> id (int)
 * <li> nom (String)
 * <li> prenom (String)
 * <li> adresse (String)
 * <li> email (String)
 * <li> telephone(String),
 * <li> listeCommandes (List Commande)
 * </ul>
 * 
 * 
 *  
 * 
 */
 


@Entity
@Table(name="clients")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private long id;
	@Column(name="nom_cl")
	@NotEmpty(message="Veuillez entrer votre nom.")
	private String nom;
	@Column(name="prenom_cl")
	@NotEmpty(message="Veuillez entrer votre prenom")
	private String prenom;
	@Column(name="adresse_cl")
	@Length(min=1, max=200, message="Veuillez renseigner une adresse comprenant entre 1 et 200 caractères")
	private String adresse;
	@Column(name="email_cl")
	@Pattern(regexp="[a-zA-Z_0-9]+@[a-zA-Z_0-9]+", message="Votre adresse mail n'est pas valide")
	private String email;
	@Column(name="telephone_cl")
	@Pattern(regexp="[0-9]{10}", message="Votre numéro de téléphone doit contenir 10 chiffres")
	private String telephone;
	@OneToMany(mappedBy="client")
	private List<Commande> listeCommandes;
	
	// Constructeurs
	public Client() {
		super();
	}
	public Client(String nom, String prenom, String adresse, String email, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}
	public Client(int id, String nom, String prenom, String adresse, String email, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}

	// Getters / Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}
	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", telephone="
				+ telephone + "]";
	}
}
