package fr.adaming.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	 *            A Model object meant to contain the category to be added.
	 * 
	 * @return A String with the name of the page to display,
	 *         ajoutCategorie.jsp, without its extension
	 */
	@RequestMapping(value = "ajout", method = RequestMethod.GET)
	public String afficheAjout(Model modele) {
		modele.addAttribute("categorieAjoutee", new Categorie());
		return "ajoutCategorie";
	}

	/**
	 * Adds a category before redirecting to the home page. If an error occurs,
	 * the page stays the same and an error message is displayed.
	 * 
	 * @param modele
	 *            A Model object containing the category to be added.
	 * @param categorie
	 *            The Categorie object with the values to be added, obtained
	 *            through a form.
	 * @param redirectAttributes
	 *            A RedirectAttributes object meant to contain a message error.
	 * 
	 * @return A String with the name of the page to display, accueil.jsp,
	 *         without its extension.
	 */
	@RequestMapping(value = "ajouterCategorie", method = RequestMethod.POST)
	public String soumettreAjoutCategorie(Model modele,
			@Valid @ModelAttribute("categorieAjoutee") Categorie categorie,
			BindingResult br, RedirectAttributes redirectAttributes) {
		if (br.hasErrors()) {
			return "ajoutCategorie";
		}
		Categorie caOut = categorieService.addCategorie(categorie);
		if (caOut != null) {
			// TODO : updater la liste de catégorie pour si on veut un menu
			// déroulant ou un autre truc
			List<Produit> listeProduit = produitService.getAllProduits();
			modele.addAttribute("listeProduits", listeProduit);
			return "accueil";
		} else {
			redirectAttributes.addFlashAttribute("message",
					"Problème lors de l'ajout de la catégorie.");
			return "redirect:ajout";
		}

	}

	/**
	 * Displays the page which updates categories.
	 * 
	 * @return A ModelAndView object containing the category to be updated and
	 *         the name of the page to display, modifCategorie.jsp, without its
	 *         extension
	 */
	@RequestMapping(value = "modif", method = RequestMethod.GET)
	public ModelAndView afficheModif() {
		ModelAndView modele = new ModelAndView("modifCategorie",
				"categorieModifiee", new Categorie());
		List<Categorie> listeCategorie=categorieService.getAllCategories();
		modele.addObject("listeCategories", listeCategorie);
		return modele;
	}

	/**
	 * Updates a category before redirecting to the home page. If an error
	 * occurs, the page stays the same and an error message is displayed.
	 * 
	 * @param modele
	 *            A Model object containing the category to be updated.
	 * @param categorie
	 *            The Categorie object with the updated values, obtained through
	 *            a form.
	 * @param redirectAttributes
	 *            A RedirectAttributes object.
	 * 
	 * @return A String with the name of the page to display.
	 */
	@RequestMapping(value = "modifierCategorie", method = RequestMethod.POST)
	public String soumettreModifCategorie(Model modele,
			@Valid @ModelAttribute("categorieModifiee") Categorie categorie,
			BindingResult br, RedirectAttributes redirectAttributes) {
		if (br.hasErrors()) {
			return "ajoutCategorie";
		}
		
		Categorie caOut = categorieService.updateCategorie(categorie);
		if (caOut != null) {
			// TODO : updater la liste de catégorie pour si on veut un menu
			// déroulant ou un autre truc
			List<Produit> listeProduit = produitService.getAllProduits();
			modele.addAttribute("listeProduits", listeProduit);
			return "accueil";
		} else {
			redirectAttributes.addFlashAttribute("message",
					"Problème lors de la modification de la catégorie.");
			return "redirect:modif";
		}
	}

	/**
	 * Displays the page which deletes categories.
	 * 
	 * @param modele
	 *            A Model object containing the category to be deleted.
	 * @return A String with the name of the page to display,
	 *         supprCategorie.jsp, without its extension
	 */
	@RequestMapping(value = "suppr", method = RequestMethod.GET)
	public String afficheSuppr(ModelMap modele) {
		List<Categorie> listeCategorie=categorieService.getAllCategories();
		modele.addAttribute("listeCategories", listeCategorie);
		modele.addAttribute("categorieSupprimee", new Categorie());
		return "supprCategorie";
	}

	/**
	 * Deletes a category before redirecting to the home page.
	 * 
	 * @param modele
	 *            A ModelMap object containing the category to be updated.
	 * @param categorie
	 *            The Categorie object with the id of the categorie to delete,
	 *            obtained through a form. s *
	 * @return A String with the name of the page to display.
	 */
	@RequestMapping(value = "supprimerCategorie", method = RequestMethod.POST)
	public String soumettreSupprCategorie(ModelMap modele,
			@ModelAttribute("categorieSupprimee") Categorie categorie) {
		categorieService.deleteCategorie(categorie);
		List<Produit> listeProduit = produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		return "accueil";
	}
}
