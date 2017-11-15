package fr.adaming.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
@RequestMapping("categorie")
public class CategorieController {
	@RequestMapping(value="ajout", method=RequestMethod.GET)
	public String afficheAjout(){
		return "ajoutCategorie";
	}
	
	@RequestMapping(value="modif", method=RequestMethod.GET)
	public String afficheModif(){
		return "modifCategorie";
	}
	
	@RequestMapping(value="suppr", method=RequestMethod.GET)
	public String afficheSuppr(){
		return "supprCategorie";
	}
}
