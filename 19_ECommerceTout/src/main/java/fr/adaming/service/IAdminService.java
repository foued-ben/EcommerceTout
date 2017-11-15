package fr.adaming.service;

import fr.adaming.model.Admin;

public interface IAdminService {
	/**
	 * to check if an administrator exists by calling the dao method of the same name
	 *
	 * @param a
	 * 			The administrator to check
	 * @return the administrator if he is exist
	 */
	public Admin exists(Admin a);
	/**
	 * 
	 * to add an administrator by calling the dao method of the same name
	 * 
	 * @param a
	 * 			The administrator to add
	 * @return the administrator added
	 */
	public Admin addAdmin(Admin a);
}
