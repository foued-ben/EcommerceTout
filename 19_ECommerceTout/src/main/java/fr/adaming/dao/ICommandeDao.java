package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public interface ICommandeDao {
	/**
	 * to get a order by id
	 * 
	 * @param id
	 * 			id of the order
	 * @return The order corresponding to the id 
	 */
	public Commande getCommandeById(long id);
	/**
	 * to get all orders
	 * 
	 * @return the list of all orders
	 */
	public List<Commande> getAllCommandes();
	/**
	 * to add a order
	 * 
	 * @param co
	 * 			The order to add
	 * @return the order added
	 */
	Commande addCommande(Commande co);
}
