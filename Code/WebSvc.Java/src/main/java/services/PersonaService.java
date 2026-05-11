package services;

import models.Person;
import repositories.IDb;

/**
 * Service that handles business logic
 */
public class PersonaService implements IPersonaService {

	private IDb _myDb = null;
	
	public PersonaService(IDb db) {
		this._myDb = db;
	}
	
	public void updateBirth(Person p) throws Exception {
		
		// Business logic: check if age format is legal (e.g., >0), etc
		if(p.getAge() <=0) throw new Exception("age");
		
		// Other checks
		
		this._myDb.updateBirth(p);
	}

}
