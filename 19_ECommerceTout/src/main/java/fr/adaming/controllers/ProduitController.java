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
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("produit")
public class ProduitController {
	private List<Produit> listeProduit;
	
	@Autowired
	private IProduitService produitService;
	
	
	
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	@RequestMapping(value="accueil", method=RequestMethod.GET)
	public String afficheAccueil(ModelMap modele){
		listeProduit=produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		return "accueil";
	}
	
	/**
	 * Displays the page which adds categories.
	 * 
	 * @param modele
	 * 			A Model object containing the product to be added. 
	 * @return A String with the name of the page to display, ajoutProduit.jsp, without its extension
	 */
	@RequestMapping(value="ajout", method=RequestMethod.GET)
	public String afficheAjout(Model model){
		model.addAttribute("produitAjoute", new Produit());
		model.addAttribute("categorieProd", new Categorie()); 
		return "ajoutProduit";
	}
	
	@RequestMapping(value = "ajouterProduit", method = RequestMethod.POST)
	public String soumettreAjoutProduit (Model model, @ModelAttribute("produitAjoute") Produit produit, @ModelAttribute("categorieProd") Categorie categorie, RedirectAttributes ra){
		Produit p_out = produitService.addProduit(produit, categorie); 
		System.out.println(p_out);
		if (p_out != null) {
			List<Produit> listeProduits = produitService.getAllProduits() ; 
			model.addAttribute("listeProduits", listeProduits);
			return "accueil";
		}else{
			ra.addFlashAttribute("message", "Le produit n'a pas pu être ajouté"); 
			return "redirect:ajout";
		}
	}
	
	
	
	@RequestMapping(value="modif", method=RequestMethod.GET)
	public String afficheModif(){
		return "modifProduit";
	}
	
	@RequestMapping(value="suppr", method=RequestMethod.GET)
	public String afficheSuppr(){
		return "supprProduit";
	}
	
	
}
