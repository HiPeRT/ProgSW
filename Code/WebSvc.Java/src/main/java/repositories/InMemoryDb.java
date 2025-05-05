package repositories;

import java.util.Dictionary;
import java.util.Hashtable;

import models.Person;

/**
 * For local testing. Does not persist.
 */
public class InMemoryDb implements IDb {

	private Dictionary<Integer, Integer> _db = new Hashtable<>();
	
	public InMemoryDb() {
		// Seeding for test...
		// TODO shall this stay here?
		_db.put(11, 25);
	}

	@Override
	public void updateBirth(int key, int age) throws Exception {
		if(_db.get(key) == null)
			throw new Exception("User with " + key + " does not exist!");
		
		_db.put(key, age);		
	}

	
	@Override
	public void updateBirth(Person p) throws Exception {
		if(_db.get(p.getId()) == null)
			throw new Exception("User with " + p.getId() + " does not exist!");
		
		_db.put(p.getId(), p.getAge());
	}
}
