package it.unimore.progsw.factory.web;

import it.unimore.progsw.factory.services.IDb;
import it.unimore.progsw.factory.services.ISvcBuilder;

/**
 * My web service Endpoint controller.
 * NOTE. This should be injected in a framework API, but for brevity I use it as
 * a standalone class 
 */
public class WebSvc {
	
	private ISvcBuilder _builder = null;
	private IDb _db = null;
		
	public WebSvc(ISvcBuilder svcBuilder) {
		this._builder = svcBuilder;
		
		this._db = this._builder.createDb();
	}

	
	/**
	 * This is the method that responds to Web API REST call
	 */
	public void Endpoint_UpdateBirth(int id, int age) {
		this._db.updateBirth(id, age);
	}
		
	/**
	 * Emulate WebSvc start
	 * @return
	 */
	public WebSvc start() {
		// Starts the web server (of course it's fake, here)
		
		// Implement the Fluent pattern
		return this;
	}
	
	/**
	 * This method below, should not be here, as it's used only for testing.
	 * There are better ways to implement this, but for the sake of clarity
	 * I omit them here
	 */	
	public IDb getDb() {
		return this._db;
	}
}
