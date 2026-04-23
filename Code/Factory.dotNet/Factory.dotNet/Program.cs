using Factory.Basic;
using Factory.Interfaces;
using Factory.Models;
using Factory.SecondVersion;
using Factory.WithGenerics;

namespace Factory
{
    public class Program
    {
        private static void Main(string[] args)
        {
            // Create the factories
            IFactory factory = new ConcreteFactory();
            IFactory factory2 = new ConcreteFactory2();

            // Create your objects
            IThing t = factory.CreateThing();
            IThing t2 = factory2.CreateThing();

            // Use them
            t.Foo();
            t2.Foo();

            Console.WriteLine("----------------");

            // ------------------------------------------
            // Factories that use inheritance
            // (note that they are still declared as Ifs)
            // ------------------------------------------

            IFactory factory3 = new BaseFactory();
            IFactory factory4 = new TheFactory();

            IThing t3 = factory3.CreateThing();
            IThing t4 = factory4.CreateThing();

            t3.Foo();
            t4.Foo();


            Console.WriteLine("----------------");

            // ------------------------------------------
            // Factories that use generics (in c# they
            // are easier to implement than in Java)
            // (note that they are still declared as Ifs)
            // ------------------------------------------

            IFactory factory5 = new FactoryWithGenerics<ConcreteThing>();
            IFactory factory6 = new FactoryWithDefault();

            IThing t5 = factory5.CreateThing();
            IThing t6 = factory6.CreateThing();

            t5.Foo();
            t6.Foo();
        }
    }
}