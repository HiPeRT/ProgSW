package factory.secondversion;

import factory.entities.ConcreteThing;
import factory.interfaces.IFactory;
import factory.interfaces.IThing;

/**
 * Factory that creates objects of the ConcreteThing class
 */
public class BaseFactory implements IFactory {

	@Override
	public IThing createThing() {
		return new ConcreteThing();
	}

}
