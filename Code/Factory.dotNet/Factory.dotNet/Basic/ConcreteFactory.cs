using Factory.Interfaces;
using Factory.Models;

namespace Factory.Basic
{
    /// <summary>
    /// Factory that creates objects of the ConcreteThing class
    /// </summary>
    public class ConcreteFactory : IFactory
    {
        public IThing CreateThing()
        {
            return new ConcreteThing();
        }
    }
}
