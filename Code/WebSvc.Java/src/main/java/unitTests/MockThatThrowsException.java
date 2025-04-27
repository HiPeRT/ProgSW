package unitTests;

import repositories.IDb;

public class MockThatThrowsException implements IDb {

	@Override
	public void updateBirth(int key, int age) throws Exception {
		throw new Exception("User with " + key + " does not exist!");

	}

}
