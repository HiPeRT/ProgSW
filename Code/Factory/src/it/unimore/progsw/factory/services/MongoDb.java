package it.unimore.progsw.factory.services;

/**
 * This class is an ADAPTER for MongoDb drivers: it wraps this dependency,
 * and provides "business-level" operations, such as updateBirth
 */
public class MongoDb implements IDb {

	@Override
	public void updateBirth(int id, int age) {
		// Perform the update using driver-specific API
		// this._usersCollectionBinding.get(id.toString()).updateField("age", age);
	}
	

	@Override
	public int getAge(int key) {
		// Perform the read using driver-specific API
		// this._usersCollectionBinding.get(id.toString()).getField("age", age);
		return -1;
	}

}
