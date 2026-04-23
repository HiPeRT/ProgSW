package factory;

import factory.basic.ConcreteFactory;
import factory.basic.ConcreteFactory2;
import factory.interfaces.IFactory;
import factory.interfaces.IThing;
import factory.secondversion.BaseFactory;
import factory.secondversion.TheFactory;

public class App {

	public static void main(String[] args) {

		// Create the factories
		IFactory factory = new ConcreteFactory();
		IFactory factory2 = new ConcreteFactory2();
		
		// Create your objects
		IThing t = factory.createThing();
		IThing t2 = factory2.createThing();

		// Use them
		t.foo();
		t2.foo();
		
		System.out.println("----------------");
		
		// ------------------------------------------
		// Factories that use inheritance
		// (note that they are still declared as Ifs)
		// ------------------------------------------
		
		IFactory factory3 = new BaseFactory();
		IFactory factory4 = new TheFactory();
		
		IThing t3 = factory3.createThing();
		IThing t4 = factory4.createThing();

		t3.foo();
		t4.foo();

	}

}
