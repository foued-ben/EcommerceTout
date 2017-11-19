package fr.adaming.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("panier")
public class PanierController {

	@Autowired
	private IClientService clientService;

	@Autowired
	private IProduitService produitService;
	
	@Autowired
	private ILigneCommandeService lComService;

	/**
	 * Displays the page with the basket and the log in and sign in client forms.
	 * 
	 * @param modele
	 *            A Model object containing the category to be added.
	 * 
	 * @return A String with the name of the page to display, panier.jsp,
	 *         without its extension
	 */
	@RequestMapping(value = "affiche", method = RequestMethod.GET)
	public String afficheInscriptionForm(Model modele) {

		List<LigneCommande> listeCourses = lComService.getAllLigneCommandes();
		
		modele.addAttribute("nouveauClient", new Client());
		modele.addAttribute("recapPanier", listeCourses);

		return "panier";

	}

	/**
	 * Adds a client before redirecting to the home page. If an error occurs, the page stays the same and an error message is displayed.
	 * 
	 * @param modele
	 *            A Model object containing the category to be added.
	 * @param client
	 *            The client object, with the values to be added, obtained from
	 *            a form.
	 * @param br
	 *            A BindingResult object, meant to contain the mapping result in
	 *            order to validate the form.
	 * @param redirectAttributes
	 *            A RedirectAttributes object meant to contain a message error.
	 * @return A String with the name of the page to display, without its
	 *         extension.
	 */
	@RequestMapping(value = "inscrireClient", method = RequestMethod.POST)
	public String soumettreInscriptionForm(Model modele, @Valid @ModelAttribute("nouveauClient") Client client,
			BindingResult br, RedirectAttributes redirectAttributes) {

		if (br.hasErrors()) {
			return "panier";
		}

		Client clOut = clientService.addClient(client);

		if (clOut == null) {
			redirectAttributes.addFlashAttribute("message", "Problème lors de l'inscription du client.");
			return "redirect:affiche";
		} else {
			List<Produit> listeProduit = produitService.getAllProduits();
			modele.addAttribute("listeProduits", listeProduit);
			return "accueil";
		}

	}

}
