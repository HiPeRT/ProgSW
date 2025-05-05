package repositories;

import models.Person;

/**
 * Interface to persistence layer
 */
public interface IDb {
	
	/**
	 * Old, non CLEAN
	 * @param key
	 * @param age
	 * @throws Exception
	 */
	void updateBirth(int key, int age) throws Exception;
	
	/**
	 * Update birth date of a person in DB
	 * @param p
	 * @throws Exception
	 */
	void updateBirth(Person p) throws Exception;
}
