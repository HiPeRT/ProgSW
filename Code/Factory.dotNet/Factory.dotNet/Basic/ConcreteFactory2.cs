using Factory.Interfaces;
using Factory.Models;

namespace Factory.Basic
{
    /// <summary>
    /// Factory that creates objects of the ConcreteThing2 class
    /// </summary>
    public class ConcreteFactory2 : IFactory
    {
        public IThing CreateThing()
        {
            return new ConcreteThing2();
        }
    }
}
