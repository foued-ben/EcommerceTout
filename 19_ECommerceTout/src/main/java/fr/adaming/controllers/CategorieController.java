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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("categorie")
public class CategorieController {
	@Autowired
	private ICategorieService categorieService;
	@Autowired
	private IProduitService produitService;

	/**
	 * Displays the page which adds categories.
	 * 
	 * @param modele
	 * 			A Model object containing the category to be added. 
	 * @return A String with the name of the page to display, ajoutCategorie.jsp, without its extension
	 */
	@RequestMapping(value = "ajout", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {
		modele.addAttribute("categorieAjoutee", new Categorie());
		return "ajoutCategorie";
	}

	@RequestMapping(value = "ajouterCategorie", method = RequestMethod.POST)
	public String soumettreAjoutCategorie(Model modele,
			@ModelAttribute("categorieAjoutee") Categorie categorie,
			RedirectAttributes redirectAttributes) {
		Categorie caOut = categorieService.addCategorie(categorie);
		if (caOut != null) {
			// TODO : updater la liste de cat�gorie pour si on veut un menu
			// d�roulant ou un autre truc
			List<Produit> listeProduit = produitService.getAllProduits();
			modele.addAttribute("listeProduits", listeProduit);
			return "accueil";
		} else {
			redirectAttributes.addFlashAttribute("message",
					"Probl�me lors de l'ajout de la cat�gorie.");
			return "redirect:ajout";
		}

	}

	/**
	 * Displays the page which updates categories.
	 * 			 
	 * @return A ModelAndView object containing the category to be updated and the name of the page to display, modifCategorie.jsp, without its extension
	 */
	@RequestMapping(value = "modif", method = RequestMethod.GET)
	public ModelAndView afficheModif() {
		return new ModelAndView("modifCategorie", "categorieModifiee",
				new Categorie());
	}
	
	@RequestMapping(value="modifierCategorie", method=RequestMethod.POST)
	public String soumettreModifCategorie(Model modele,
			@ModelAttribute("categorieModifiee") Categorie categorie,
			RedirectAttributes redirectAttributes) {
		Categorie caOut = categorieService.updateCategorie(categorie);
		if (caOut != null) {
			// TODO : updater la liste de cat�gorie pour si on veut un menu
			// d�roulant ou un autre truc
			List<Produit> listeProduit = produitService.getAllProduits();
			modele.addAttribute("listeProduits", listeProduit);
			return "accueil";
		} else {
			redirectAttributes.addFlashAttribute("message",
					"Probl�me lors de la modification de la cat�gorie.");
			return "redirect:modif";
		}
	}

	@RequestMapping(value = "suppr", method = RequestMethod.GET)
	public String afficheSuppr(ModelMap modele) {
		modele.addAttribute("categorieSupprimee", new Categorie());
		return "supprCategorie";
	}
	
	@RequestMapping(value="supprimerCategorie", method=RequestMethod.POST)
	public String soumettreSupprCategorie(ModelMap modele, @ModelAttribute("categorieSupprimee") Categorie categorie, RedirectAttributes redirectAttributes){
		categorieService.deleteCategorie(categorie);
		List<Produit> listeProduit = produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		return "accueil";
	}
}
