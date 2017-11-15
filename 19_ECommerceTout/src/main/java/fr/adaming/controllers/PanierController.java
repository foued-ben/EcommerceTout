package fr.adaming.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
@RequestMapping("panier")
public class PanierController {
	
	@RequestMapping(value="affiche", method=RequestMethod.GET)
	public String affichePanier(){
		return "panier";
	}
}
