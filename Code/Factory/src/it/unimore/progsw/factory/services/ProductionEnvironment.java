package it.unimore.progsw.factory.services;

/**
 * Final environment
 */
public class ProductionEnvironment implements IEnv {

	@Override
	public boolean IsLocal() {
		return false;
	}

}
