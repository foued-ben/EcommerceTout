package fr.adaming.dao;

import fr.adaming.model.Admin;

public interface IAdminDao {
	
	/**
	 * to check if an administrator exists
	 *
	 * @param a
	 * 			The administrator to check
	 * @return the administrator if he is exist
	 */
	public Admin exists(Admin a);
	
	/**
	 * 
	 * to add an administrator
	 * 
	 * @param a
	 * 			The administrator to add
	 * @return the administrator added
	 */
	public Admin addAdmin(Admin a);
}
