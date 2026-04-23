using Factory.Interfaces;
using Factory.Models;

namespace Factory.SecondVersion
{
    /// <summary>
    /// Factory that creates objects of the ConcreteThing class
    /// </summary>
    public class BaseFactory : IFactory
    {
        public virtual IThing CreateThing()
        {
            return new ConcreteThing();
        }
    }
}
