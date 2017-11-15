package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitService {
	/**
	 * to get a product by id by calling the dao method of the same name
	 * 
	 * @param id
	 * 			id of the product
	 * @return The product corresponding to the id 
	 */
	public Produit getProduitById(long id);
	/**
	 * to get all products by calling the dao method of the same name
	 * 
	 * @return the list of all products
	 */
	public List<Produit> getAllProduits();
	/**
	 * to get all products in a category by calling the dao method of the same name
	 * 
	 * @param c
	 * 		 	the category to display
	 * @return the list of all products in the category
	 */
	public List<Produit> getAllProduitsByCategorie(Categorie c);
	/**
	 * to add a product by calling the dao method of the same name
	 * 
	 * @param p
	 * 			The product to add
	 * @param c
	 * 			the category in which the product is added
	 * @return the product added
	 */
	public Produit addProduit(Produit p, Categorie c);
	/**
	 * to update a product by calling the dao method of the same name
	 * 
	 * @param p
	 * 			The product to update
	 * @param c
	 * 			the category in which the product is updated
	 * @return the product updated
	 */
	public Produit updateProduit(Produit p, Categorie c);
	/**
	 * to delete a product by calling the dao method of the same name
	 * 
	 * @param p
	 * 			The product to delete
	 */
	public void deleteProduit(Produit p);
}
