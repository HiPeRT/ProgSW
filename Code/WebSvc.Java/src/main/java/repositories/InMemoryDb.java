package repositories;

import java.util.Dictionary;
import java.util.Hashtable;

public class InMemoryDb implements IDb {

	private Dictionary<Integer, Integer> _db = new Hashtable<>();
	
	public InMemoryDb() {
		// Seeding for test...
		_db.put(11, 25);
	}
	
	@Override
	public void updateBirth(int key, int age) throws Exception {
		if(_db.get(key) == null)
			throw new Exception("User with " + key + " does not exist!");
		
		_db.put(key, age);
	}

}
