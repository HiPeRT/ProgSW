package services;

public class TheEnvironment implements IEnvironment{

	@Override
	public Boolean IsLocal() {
		// TODO Read this by configuration file...
		return true;
	}

}
