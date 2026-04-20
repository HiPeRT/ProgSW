package repositories;

import models.Person;

/**
 * Mongo adapter
 */
public class MongoDB implements IDb {

	@Override
	public void updateBirth(Person p) throws Exception {		
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	@Override
	public void updateBirth(int key, int age) throws Exception {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

}
