package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {
	/**
	 * to get a category by id by calling the dao method of the same name
	 * 
	 * @param id
	 * 			id of the category
	 * @return The category corresponding to the id 
	 */
	public Categorie getCategorieById(long id);
	/**
	 * to get all categories by calling the dao method of the same name
	 * 
	 * @return the list of all categories
	 */
	public List<Categorie> getAllCategories();
	/**
	 * to add a category by calling the dao method of the same name
	 * 
	 * @param c
	 * 			The category to add
	 * @return the category added
	 */
	public Categorie addCategorie(Categorie c);
	/**
	 * to update a category by calling the dao method of the same name
	 * 
	 * @param c
	 * 			The category to update
	 * @return the category updated
	 */
	public Categorie updateCategorie(Categorie c);
	/**
	 * to delete a category by calling the dao method of the same name
	 * 
	 * @param c
	 * 			The category to delete
	 */
	public void deleteCategorie(Categorie c);
}
