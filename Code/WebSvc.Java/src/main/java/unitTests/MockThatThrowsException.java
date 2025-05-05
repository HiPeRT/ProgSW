package unitTests;

import models.Person;
import repositories.IDb;

/**
 * Testing for DB always throwing exception
 */
public class MockThatThrowsException implements IDb {

	@Override
	public void updateBirth(Person p) throws Exception {
		throw new Exception("User with " + p.getId() + " does not exist!");

	}

	@Override
	public void updateBirth(int key, int age) throws Exception {
		throw new Exception("User with " + key + " does not exist!");
	}

}
