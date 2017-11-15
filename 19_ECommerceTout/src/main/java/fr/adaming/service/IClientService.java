package fr.adaming.service;

import java.util.List;
import fr.adaming.model.Client;

public interface IClientService {
	/**
	 * to get a client by id by calling the dao method of the same name
	 * 
	 * @param id
	 * 			id of the client
	 * @return The client corresponding to the id 
	 */
	public Client getClientById(long id);
	/**
	 * to get all clients by calling the dao method of the same name
	 * 
	 * @return the list of all clients
	 */
	public List<Client> getAllClients();
	/**
	 * to add a client by calling the dao method of the same name
	 * 
	 * @param c
	 * 			The client to add
	 * @return the client added
	 */
	public Client addClient(Client c);
}
