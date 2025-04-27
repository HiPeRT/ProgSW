package unitTests;

import repositories.IDb;
import services.ISvcBuilder;

public class ServicesBuilderForMocks implements ISvcBuilder {

	@Override
	public IDb createDb() {
		return new MockThatThrowsException();
	}

}
