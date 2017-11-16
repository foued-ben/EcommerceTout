package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

public interface IProduitDao {
	/**
	 * to get a product by id
	 * 
	 * @param id
	 * 			id of the product
	 * @return The product corresponding to the id 
	 */
	public Produit getProduitById(long id);
	/**
	 * to get all products
	 * 
	 * @return the list of all products
	 */
	public List<Produit> getAllProduits();
	/**
	 * to get all products in a category
	 * 
	 * @param c
	 * 		 	the category to display
	 * @return the list of all products in the category
	 */
	public List<Produit> getAllProduitsByCategorie(Categorie c);
	/**
	 * to add a product
	 * 
	 * @param p
	 * 			The product to add
	 * @return the product added
	 */
	public Produit addProduit(Produit p);
	/**
	 * to update a product
	 * 
	 * @param p
	 * 			The product to update
	 * @return the product updated
	 */
	public Produit updateProduit(Produit p);
	/**
	 * to delete a product
	 * 
	 * @param p
	 * 			The product to delete
	 */
	public void deleteProduit(Produit p);
	/**
	 * to search a product by a key word
	 * 
	 * @param mot
	 * 			the key word 
	 * @return The list of all products with the word "mot" in their name
	 */
	public List<Produit> getProduitsByMot(String mot) ; 
}
