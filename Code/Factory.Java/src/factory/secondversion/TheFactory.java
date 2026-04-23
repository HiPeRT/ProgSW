package factory.secondversion;

import factory.entities.ConcreteThing2;
import factory.interfaces.IThing;

/**
 * Factory that creates objects of the ConcreteThing2 class
 */
public class TheFactory extends BaseFactory {

	@Override
	public IThing createThing() {
		return new ConcreteThing2();
	}
}
