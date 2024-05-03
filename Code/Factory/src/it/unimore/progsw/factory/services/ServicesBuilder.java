package it.unimore.progsw.factory.services;

import it.unimore.progsw.factory.testing.InMemoryDb;

/**
 * FACTORY for services
 */
public class ServicesBuilder implements ISvcBuilder {
	
	private IEnv _environment = null;

	public ServicesBuilder(IEnv environment){
		this._environment = environment;
	}
	
	@Override
	public IDb createDb() {
		if(this._environment.IsLocal())
		    return new InMemoryDb();
		  else
		    return new MongoDb();

	}

}
