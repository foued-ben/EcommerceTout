package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

public interface ICommandeService {
	/**
	 * to get a order by id by calling the dao method of the same name
	 * 
	 * @param id
	 * 			id of the order
	 * @return The order corresponding to the id 
	 */
	public Commande getCommandeById(long id);
	/**
	 * to get all orders by calling the dao method of the same name
	 * 
	 * @return the list of all orders
	 */
	public List<Commande> getAllCommandes();
	/**
	 * to add a order by calling the dao method of the same name
	 * 
	 * @param co
	 * 			The order to add
	 * @param cl
	 * 			the client who ordered
	 * @return the order added
	 */
	Commande addCommande(Commande co, Client cl);
}
