package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeDao {
	/**
	 * to get a command line by id
	 * 
	 * @param id
	 * 			id of the command line
	 * @return The command line corresponding to the id 
	 */
	public LigneCommande getLigneCommandeById(long id);
	/**
	 * to get all command lines
	 * 
	 * @return the list of all command lines
	 */
	public List<LigneCommande> getAllLigneCommandes();
	/**
	 * to add a command line
	 * 
	 * @param lc
	 * 			The command line to add
	 * @return the order command line
	 */
	public LigneCommande addLigneCommande(LigneCommande lc);
}
