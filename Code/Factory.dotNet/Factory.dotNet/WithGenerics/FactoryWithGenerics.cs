using Factory.Interfaces;
using Factory.Models;

namespace Factory.WithGenerics
{
    /// <summary>
    /// Factory that uses generics (the default type shall be specified while creating the object)
    /// </summary>
    /// <typeparam name="T"></typeparam>
    public class FactoryWithGenerics<T> : IFactory where T : new()
    {
        public IThing CreateThing()
        {
            bool someCondition = true;

            // If condition is met, then use the ConcreteThing2 class,
            // else use the ConcreteClass

            if (someCondition)
                return new ConcreteThing2();

            return (IThing) new T();
        }
    }
}
