package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

public interface ILigneCommandeService {
	/**
	 * to get a command line by id by calling the dao method of the same name
	 * 
	 * @param id
	 * 			id of the command line
	 * @return The command line corresponding to the id 
	 */
	public LigneCommande getLigneCommandeById(long id);
	/**
	 * to get all command lines by calling the dao method of the same name
	 * 
	 * @return the list of all command lines
	 */
	public List<LigneCommande> getAllLigneCommandes();
	/**
	 * to add a command line by calling the dao method of the same name
	 * 
	 * @param lc
	 * 			The command line to add
	 * @param co
	 * 			the command to which the command line is assigned
	 * @param pr
	 * 			the product concerned in this order line
	 * @return the order command line
	 */
	public LigneCommande addLigneCommande(LigneCommande lc, Commande co, Produit pr);
}
