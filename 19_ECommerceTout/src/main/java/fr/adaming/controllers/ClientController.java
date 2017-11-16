package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("client")
public class ClientController {
	private List<Produit> listeProduit;

	private String mot ; 
	
	@Autowired
	private IProduitService produitService;

	@Autowired
	private ICategorieService categorieService;

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}
	
	
	
	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	@RequestMapping(value = "accueil", method = RequestMethod.GET)
	public String afficheAccueil(ModelMap modele) {
		listeProduit = produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		return "accueil";
	}
	
	/**
	 * Displays the page which search products.
	 * 
	 * @param modele
	 *            A Model object containing the category to be sought.
	 * @return A String with the name of the page to display, ajoutProduit.jsp,
	 *         without its extension
	 */
	@RequestMapping(value = "recherche", method = RequestMethod.GET)
	public String afficheProdByCat(Model model) {
		model.addAttribute("categorieDemande", new Categorie());
		List<Categorie> listeCategories = categorieService.getAllCategories();
		model.addAttribute("listeCategories", listeCategories);
		return "produitRech";
	}

	@RequestMapping(value = "rechercheProduit", method = RequestMethod.POST)
	public String soumettreAjoutProduit(Model model, @ModelAttribute("categorieDemande") Categorie categorie, RedirectAttributes ra) {
		List<Produit> listeProduits = produitService.getAllProduitsByCategorie(categorie);

		if (listeProduits != null) {
			model.addAttribute("listeProduits", listeProduits);
			return "produitByCat";
		} else {
			ra.addFlashAttribute("message", "Le contenu de la catégorie ne peut être affiché (elle est peut-être vide)");
			return "redirect:recherche";
		}
	}
	
	@RequestMapping(value = "rechercheProduitMot", method = RequestMethod.POST)
	public String soumettreRechProduit(Model model, @RequestParam("motRech") String motRech, RedirectAttributes ra) {
		List<Produit> listeProduits = produitService.getProduitsByMot(motRech);

		if (listeProduits != null) {
			model.addAttribute("listeProduits", listeProduits);
			return "produitByMot";
		} else {
			ra.addFlashAttribute("message", "La recherche n'a pas abouti");
			return "redirect:recherche";
		}
	}
	
}
