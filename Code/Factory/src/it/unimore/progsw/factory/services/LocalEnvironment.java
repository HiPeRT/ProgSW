package it.unimore.progsw.factory.services;

/*
 * Environment for local testing
 */
public class LocalEnvironment implements IEnv {

	@Override
	public boolean IsLocal() {
		return true;
	}

}
