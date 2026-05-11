package services;

import repositories.IDb;
import repositories.InMemoryDb;
import repositories.MongoAdapter;

/**
 * Implementation for Local and PROD env (Factory pattern)
 */
public class ServiceBuilder implements ISvcBuilder {
	
	private static ServiceBuilder _instance = null;
	
	// Runtime env
	private IEnvironment _env = TheEnvironment.GetInstance();
	
	private ServiceBuilder() {
	}
	
	public static ISvcBuilder GetInstance() {
		if(_instance == null) _instance = new ServiceBuilder();		
		return _instance;
	}

	@Override
	public IDb createDb() {
		if(_env.IsLocal())
			return new InMemoryDb();
		return new MongoAdapter();
	}

	@Override
	public IPersonaService createPersonaService() {
		// We don't need to mock this in Local env. Always return the real one.
		return new PersonaService(createDb());
	}

}
