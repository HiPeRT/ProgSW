package it.unimore.progsw.factory.testing;

import java.util.Dictionary;
import java.util.Hashtable;

import it.unimore.progsw.factory.services.IDb;

/**
 * This class implements an in-memory Db to be used for integration tests
 */
public class InMemoryDb implements IDb {

	private Dictionary<Integer, Integer> _db = null;
	
	public InMemoryDb() {
		this._db = new Hashtable<Integer, Integer>();
	}
	
	@Override
	public void updateBirth(int key, int age) {
		
		// ADAPTER between the *contract* updateBirth, and the actual implementation,
		// which is based on Dictionary<Integer, Integer>
		this._db.remove(key);
		this._db.put(key, age);
		
	}

	@Override
	public int getAge(int key) {
		return this._db.get(key);
	}

}
