package services;

/**
 *  This should be provided by the framework.
 */
public class TheEnvironment implements IEnvironment {
	
	private static IEnvironment _instance = null;
	
	private TheEnvironment() {
	}
	
	public static IEnvironment GetInstance() {
		if(_instance == null) _instance = new TheEnvironment();
		return _instance;
	}

	@Override
	public Boolean IsLocal() {
		// TODO Read this by configuration file...
		return true;
	}

}
