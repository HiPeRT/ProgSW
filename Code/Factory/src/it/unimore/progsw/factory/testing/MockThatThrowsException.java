package it.unimore.progsw.factory.testing;

import it.unimore.progsw.factory.services.IDb;

public class MockThatThrowsException implements IDb {

	@Override
	public void updateBirth(int key, int age) {
		throw new NullPointerException();
	}

	@Override
	public int getAge(int key) {
		throw new NullPointerException();
	}

}
