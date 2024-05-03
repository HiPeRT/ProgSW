package it.unimore.progsw.factory.web;

import it.unimore.progsw.factory.services.IEnv;
import it.unimore.progsw.factory.services.ISvcBuilder;
import it.unimore.progsw.factory.services.ProductionEnvironment;
import it.unimore.progsw.factory.services.ServicesBuilder;

/**
 * Main class (no web framework for simplicity)
 */
public class MainClass {
	
	public static void main(String[] args) {
		// The environment is typically loaded by the FWK, reading
		// appropriate OS "ENV" vars, or by a config file
		IEnv environment = new ProductionEnvironment();
		//IEnv environment = new LocalEnvironment();
		
		// Create the builder to set up the system
		ISvcBuilder builder = new ServicesBuilder(environment);
		
		// Finally, start the web server, and service
		new WebSvc(builder).start();
	}

}
