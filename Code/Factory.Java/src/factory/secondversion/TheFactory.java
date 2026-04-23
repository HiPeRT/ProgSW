package factory.secondversion;

import factory.entities.ConcreteThing2;
import factory.interfaces.IThing;

/**
 * Factory that creates objects of the ConcreteThing2 class if some condition is met
 */
public class TheFactory extends BaseFactory {

	@Override
	public IThing createThing() {
		
		bool someCondition = true;
		
		// If condition is met, then use the ConcreteThing2 class,
		// else use the ConcreteClass
		
		if(someCondition)
			return new ConcreteThing2();
		
		return super.createThing();
	}
}
