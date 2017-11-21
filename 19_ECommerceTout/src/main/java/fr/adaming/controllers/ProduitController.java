package fr.adaming.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;



import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("/produit")
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

	
	
	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
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
		model.addAttribute("produit", new Produit());
		List<Categorie> listeCategories = categorieService.getAllCategories();
		model.addAttribute("listeCategories", listeCategories);
		model.addAttribute("categorieProd", new Categorie());
		return "ajoutProduit";
	}

	@RequestMapping(value = "/ajouterProduit", method = RequestMethod.POST)
	public String soumettreAjoutProduit(Model model,  Produit produit, @RequestParam("file") MultipartFile file, RedirectAttributes ra) {
		if(file!=null){
			try {
				produit.setImage(file.getBytes());
			} catch (IOException e) {
				System.out.println("Erreur lors de l'ajout d'image.");
				e.printStackTrace();
			}
		}
		Produit p_out = produitService.addProduit(produit);

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
	public String soumettreModifProduit(Model model, @Valid @ModelAttribute("produitModif") Produit produit, BindingResult br,
			RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "modifProduit";
		}
		
		
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
	
	@RequestMapping(value = "pdf", method = RequestMethod.GET)
	public void ecrirePDF(){
		//On récupère les informations sur les produits depuis la session.
		List<Produit> listeProduits = produitService.getAllProduits();
		Document document = new Document();
		try {
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\inti0241\\RécapitulatifInventaire.pdf"));
			document.open();

//Lister les produits dans le PDF
			Paragraph header = new Paragraph();
			header.add("Les produits proposés par le magasin sont : ");
			document.add(header);
			document.add(new Paragraph("\n"));

			// Entête du tableau
			String[] enteteTableau ={"Id","Produit","Description","Quantité","Prix","Catégorie"};
			PdfPTable table = new PdfPTable(enteteTableau.length);
			//Création de l'entete du tableau

			for(String caseEntete : enteteTableau){
				Paragraph celluleEnteteTemp = new Paragraph();
				celluleEnteteTemp.add(caseEntete);
				table.addCell(celluleEnteteTemp);
			}
			
			//On ajoute les produits dans la liste
			for(Produit prod :listeProduits){
				//Pour chaque produit on stocke les infos dans un tableau d'objet
				Object[] tableauAEntrer  ={prod.getId(),prod.getDesignation(),prod.getDescription(),prod.getQuantite(),prod.getPrix(),prod.getCategorie().getNomCategorie()};
				//On ajoute l'info de chaque objet du tableau dans la cellule après toString
				for(Object objet: tableauAEntrer){
					Paragraph paraTemp = new Paragraph();
					paraTemp.add(objet.toString());
					table.addCell(paraTemp);
				}
			}
			document.add(table);

			header.clear();

			document.close();
			
		} catch (FileNotFoundException | DocumentException e) {

			e.printStackTrace();
		}
	}
	
	
	
	
}
