package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {
	
	/**
	 * to get a category by id
	 * 
	 * @param id
	 * 			id of the category
	 * @return The category corresponding to the id 
	 */
	public Categorie getCategorieById(long id);
	
	/**
	 * to get all categories
	 * 
	 * @return the list of all categories
	 */
	public List<Categorie> getAllCategories();
	
	/**
	 * to add a category
	 * 
	 * @param c
	 * 			The category to add
	 * @return the category added
	 */
	public Categorie addCategorie(Categorie c);
	/**
	 * to update a category
	 * 
	 * @param c
	 * 			The category to update
	 * @return the category updated
	 */
	public Categorie updateCategorie(Categorie c);
	/**
	 * to delete a category
	 * 
	 * @param c
	 * 			The category to delete
	 */
	public void deleteCategorie(Categorie c);
}
