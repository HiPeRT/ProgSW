package factory.entities;

import factory.interfaces.IThing;

/**
 * ConcreteThing2 entity
 */
public class ConcreteThing2 implements IThing {

	@Override
	public void foo() {
		
		System.out.println("Hello World 2!");

	}

}
