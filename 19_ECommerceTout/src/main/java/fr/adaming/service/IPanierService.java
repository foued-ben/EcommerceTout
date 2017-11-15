package fr.adaming.service;

import fr.adaming.model.Client;
import fr.adaming.model.Panier;

public interface IPanierService {
	/**
	 * send an email to a customer with his cart
	 * 
	 * @param panier
	 * 				the cart of the client 
	 * @param client
	 * 				the client who ordered
	 */
	public void envoyerMail(Panier panier, Client client);
	/**
	 * send write a pdf about a customer with his cart
	 * 
	 * @param panier
	 * 				the cart of the client 
	 * @param client
	 * 				the client who ordered
	 */
	public void exporterPdf(Panier panier, Client client);
}
