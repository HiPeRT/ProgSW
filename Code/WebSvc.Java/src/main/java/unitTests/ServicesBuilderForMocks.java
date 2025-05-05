package unitTests;

import repositories.IDb;
import services.IPersonaService;
import services.ISvcBuilder;
import services.PersonaService;

/**
 * For mocking tests
 */
public class ServicesBuilderForMocks implements ISvcBuilder {

	@Override
	public IDb createDb() {
		return new MockThatThrowsException();
	}

	@Override
	public IPersonaService createPersonaService() {
		return new PersonaService(createDb());
	}

}
