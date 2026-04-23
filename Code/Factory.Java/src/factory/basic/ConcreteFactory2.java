package factory.basic;

import factory.entities.ConcreteThing2;
import factory.interfaces.IFactory;
import factory.interfaces.IThing;
/**
 * Factory that creates objects of the ConcreteThing2 class
 */
public class ConcreteFactory2 implements IFactory {

	@Override
	public IThing createThing() {
		return new ConcreteThing2();
	}

}
