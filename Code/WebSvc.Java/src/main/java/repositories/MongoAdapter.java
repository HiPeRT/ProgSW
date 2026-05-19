package repositories;

import models.Person;
import thirdparty.MongoDb;

/**
 * Adapter pattern to wrap 3rd party MongoDb
 */
public class MongoAdapter implements IDb {
	
	private MongoDb _db = new MongoDb();

	@Override
	public void updateBirth(int key, int age) throws Exception {
		this._db.externalUpdateBirth(key, age);
	}

	@Override
	public void updateBirth(Person p) throws Exception {
		this._db.externalUpdateBirth(p.getId(), p.getAge());
	}

}
