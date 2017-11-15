package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("produit")
public class ProduitController {
	private List<Produit> listeProduit;
	
	@Autowired
	private IProduitService produitService;
	

	@RequestMapping(value="accueil", method=RequestMethod.GET)
	public String afficheAccueil(ModelMap modele){
		listeProduit=produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		return "accueil";
	}
	
	@RequestMapping(value="ajout", method=RequestMethod.GET)
	public String afficheAjout(){
		return "ajoutProduit";
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
