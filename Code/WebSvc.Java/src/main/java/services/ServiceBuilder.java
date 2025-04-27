package services;

import repositories.IDb;
import repositories.InMemoryDb;
import repositories.MongoDB;

public class ServiceBuilder implements ISvcBuilder {
	
	private static ServiceBuilder _instance = null;
	private IEnvironment _env = null;
	
	private ServiceBuilder() {
		
		// TODO we will see how this is handled by a MW...
		this._env = new TheEnvironment();
	}
	
	public static ISvcBuilder GetInstance() {
		if(_instance == null)
			_instance = new ServiceBuilder();
		
		return _instance;
	}

	@Override
	public IDb createDb() {
		if(_env.IsLocal())
			return new InMemoryDb();
		return new MongoDB();
	}

}
