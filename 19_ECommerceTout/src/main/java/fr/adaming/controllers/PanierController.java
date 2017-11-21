package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("panier")
public class PanierController {
	private List<Produit> listeProduit;

	@Autowired
	private IClientService clientService;

	@Autowired
	private IProduitService produitService;
	
	@Autowired
	private ILigneCommandeService lComService;
	
	@Autowired
	private ICommandeService commandeService;
	
	
	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

	@RequestMapping(value = "accueil", method = RequestMethod.GET)
	public String afficheAccueil(ModelMap modele, HttpServletRequest requete) {
		listeProduit = produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		modele.addAttribute("ligne", new LigneCommande());
		HttpSession session=requete.getSession(true);
		Panier panier=(Panier) session.getAttribute("panier");
		if(panier==null){
			panier=new Panier();
			panier.setListeLignesCommande(new ArrayList<LigneCommande>());
			session.setAttribute("panier",panier );
		}
		return "accueil";
	}

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
			BindingResult br, RedirectAttributes redirectAttributes,  HttpServletRequest requete) {

		if (br.hasErrors()) {
			return "panier";
		}

		Client clOut = clientService.addClient(client);

		if (clOut == null) {
			redirectAttributes.addFlashAttribute("message", "Problème lors de l'inscription du client.");
			return "redirect:affiche";
		} else {
			Commande commande=new Commande(new Date());
			commande.setClient(clOut);
			HttpSession session=requete.getSession(false);
			Panier panier=(Panier) session.getAttribute("panier");
			commande.setListeLigneCommande(panier.getListeLignesCommande());
			Commande coOut=commandeService.addCommande(commande, clOut);
			if(coOut==null){
				redirectAttributes.addFlashAttribute("message", "Problème lors de l'enregistrement de la commande.");
				return "redirect:affiche";
			} else {
				for(LigneCommande l : panier.getListeLignesCommande()){
					Produit produit=l.getProduit();
					lComService.addLigneCommande(l, coOut, produit);
					System.out.println(produit);
					System.out.println(l);
					produit.setQuantite(produit.getQuantite()-l.getQuantite());
					produitService.updateProduit(produit);
				}
				List<Produit> listeProduit = produitService.getAllProduits();
				modele.addAttribute("listeProduits", listeProduit);
				modele.addAttribute("ligne", new LigneCommande());
				modele.addAttribute("panier", new Panier());
				session.setAttribute("totalPanier", 0);
				return "accueil";
			}
			
			
		}

	}
	
	@RequestMapping(value="/ajoutPanier", method=RequestMethod.POST)
	public String ajouterPanier(Model modele, @ModelAttribute("ligne") LigneCommande ligneCommande, @RequestParam long idProduit, HttpServletRequest requete){
		Produit produit=produitService.getProduitById(idProduit);
		ligneCommande.setProduit(produit);
		ligneCommande.setPrix(produit.getPrix());
		ligneCommande.setTotal(ligneCommande.getQuantite()*produit.getPrix());
		System.out.println(ligneCommande);
		HttpSession session=requete.getSession(false);
		Panier panier=(Panier) session.getAttribute("panier");
		if(panier==null){
			System.out.println("NOOOOOOOOOOO !!!!!!!!");
		}
		panier.getListeLignesCommande().add(ligneCommande);
		session.setAttribute("panier", panier);
		double total=0;
		for(LigneCommande l:panier.getListeLignesCommande()){
			total+=l.getTotal();
		}
		session.setAttribute("totalPanier", total);
		listeProduit = produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		return "accueil";
	}
	
	@RequestMapping("/vider")
	public String viderPanier(Model modele, HttpServletRequest requete){
		HttpSession session=requete.getSession(false);
		Panier panier=new Panier();
		panier.setListeLignesCommande(new ArrayList<LigneCommande>());
		session.setAttribute("panier",panier );
		listeProduit = produitService.getAllProduits();
		modele.addAttribute("listeProduits", listeProduit);
		modele.addAttribute("ligne", new LigneCommande());
		return "accueil";
	}
	
	@RequestMapping(value="/photo")
	@ResponseBody
	public byte[] affichePhoto(long id) throws IOException {
		Produit p=produitService.getProduitById(id);
		if(p.getImage()!=null){
			return IOUtils.toByteArray(new ByteArrayInputStream(p.getImage()));
		} else{
			return new byte[0];
		}
	}
	


}
