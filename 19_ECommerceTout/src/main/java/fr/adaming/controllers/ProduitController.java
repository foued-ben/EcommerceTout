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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("produit")
public class ProduitController {
	private List<Produit> listeProduit;

	@Autowired
	private IProduitService produitService;

	@Autowired
	private ICategorieService categorieService;

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	@RequestMapping(value = "accueil", method = RequestMethod.GET)
	public String afficheAccueil(ModelMap modele) {
		listeProduit = produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		return "accueil";
	}

	/**
	 * Displays the page which adds products.
	 * 
	 * @param modele
	 *            A Model object containing the product to be added.
	 * @return A String with the name of the page to display, ajoutProduit.jsp,
	 *         without its extension
	 */
	@RequestMapping(value = "ajout", method = RequestMethod.GET)
	public String afficheAjout(Model model) {
		model.addAttribute("produitAjoute", new Produit());
		List<Categorie> listeCategories = categorieService.getAllCategories();
		model.addAttribute("listeCategories", listeCategories);
		model.addAttribute("categorieProd", new Categorie());
		return "ajoutProduit";
	}

	@RequestMapping(value = "ajouterProduit", method = RequestMethod.POST)
	public String soumettreAjoutProduit(Model model, @ModelAttribute("produitAjoute") Produit produit,
			@ModelAttribute("categorieProd") Categorie categorie, RedirectAttributes ra) {
		Produit p_out = produitService.addProduit(produit);
		System.out.println(p_out);

		if (p_out != null) {
			List<Produit> listeProduits = produitService.getAllProduits();
			model.addAttribute("listeProduits", listeProduits);
			return "accueil";
		} else {
			ra.addFlashAttribute("message", "Le produit n'a pas pu être ajouté");
			return "redirect:ajout";
		}
	}

	/**
	 * Displays the page which updates products.
	 * 
	 * @param modele
	 *            A Model object containing the product to be updated.
	 * @return A String with the name of the page to display, modifProduit.jsp,
	 *         without its extension
	 */
	@RequestMapping(value = "modif", method = RequestMethod.GET)
	public String afficheModif(Model model) {
		model.addAttribute("produitModif", new Produit());
		List<Categorie> listeCategories = categorieService.getAllCategories();
		model.addAttribute("listeCategories", listeCategories);
		return "modifProduit";
	}

	@RequestMapping(value = "modifierProduit", method = RequestMethod.POST)
	public String soumettreModifProduit(Model model, @ModelAttribute("produitModif") Produit produit,
			RedirectAttributes ra) {
		Produit p_out = produitService.updateProduit(produit);
		System.out.println(p_out);

		if (p_out != null) {
			List<Produit> listeProduits = produitService.getAllProduits();
			model.addAttribute("listeProduits", listeProduits);
			return "accueil";
		} else {
			ra.addFlashAttribute("message", "Le produit n'a pas pu être modifé");
			return "redirect:modif";
		}
	}

	@RequestMapping(value = "suppr", method = RequestMethod.GET)
	public String afficheSuppr(Model model) {
		model.addAttribute("produitSuppr", new Produit());
		return "supprProduit";
	}

	@RequestMapping(value = "supprimerProduit", method = RequestMethod.POST)
	public String soumettreSupprProduit(Model model, @ModelAttribute("produitModif") Produit produit,
			RedirectAttributes ra) {
		produitService.deleteProduit(produit);

		List<Produit> listeProduits = produitService.getAllProduits();
		model.addAttribute("listeProduits", listeProduits);
		return "accueil";

	}
}
