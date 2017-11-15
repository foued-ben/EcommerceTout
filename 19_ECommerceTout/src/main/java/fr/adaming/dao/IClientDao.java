package fr.adaming.dao;

import java.util.List;
import fr.adaming.model.Client;

public interface IClientDao {
	
	/**
	 * to get a client by id
	 * 
	 * @param id
	 * 			id of the client
	 * @return The client corresponding to the id 
	 */
	public Client getClientById(long id);
	/**
	 * to get all clients
	 * 
	 * @return the list of all clients
	 */
	public List<Client> getAllClients();
	/**
	 * to add a client
	 * 
	 * @param c
	 * 			The client to add
	 * @return the client added
	 */
	public Client addClient(Client c);
}
