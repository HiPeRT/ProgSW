package factory.entities;

import factory.interfaces.IThing;

/**
 * ConcreteThing entity
 */
public class ConcreteThing implements IThing {

	@Override
	public void foo() {
		
		System.out.println("Hello World!");
		
	}

}
