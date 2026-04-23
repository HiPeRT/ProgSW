using Factory.Interfaces;
using Factory.Models;

namespace Factory.SecondVersion
{
    /// <summary>
    /// Factory that creates objects of the ConcreteThing2 class if some condition is met
    /// </summary>
    public class TheFactory : BaseFactory
    {
        public override IThing CreateThing()
        {
            bool someCondition = true;

            // If condition is met, then use the ConcreteThing2 class,
            // else use the ConcreteClass

            if (someCondition)
                return new ConcreteThing2();

            return base.CreateThing();
        }
    }
}
