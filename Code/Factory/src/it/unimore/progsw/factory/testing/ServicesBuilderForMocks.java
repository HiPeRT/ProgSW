package it.unimore.progsw.factory.testing;

import it.unimore.progsw.factory.services.IDb;
import it.unimore.progsw.factory.services.ISvcBuilder;

/**
 * FACTORY. Services builder that creates mocked object for the testing.
 * Note that, unlike {@link ServicesBuilder}, here we don't require IEnv in ctor
 */
public class ServicesBuilderForMocks implements ISvcBuilder {

	@Override
	public IDb createDb() {
		return new MockThatThrowsException();
	}

}
