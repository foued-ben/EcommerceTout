package fr.adaming.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
@RequestMapping("accueil")
public class ProduitController {

	@RequestMapping(value="produits", method=RequestMethod.GET)
	public String afficheAccueil(){
		return "accueil";
	}
}
