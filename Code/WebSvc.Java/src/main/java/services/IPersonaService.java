package services;

import models.Person;


/**
 * Wrapper for business logics
 */
public interface IPersonaService {
	/**
	 * Update age of a person in DB
	 * @param p
	 * @throws Exception
	 */
	void updateBirth(Person p) throws Exception;

}
