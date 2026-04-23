using Factory.Interfaces;

namespace Factory.Models
{
    /// <summary>
    /// ConcreteThing entity
    /// </summary>
    public class ConcreteThing : IThing
    {
        /// <summary>
        /// Business functionality of entity
        /// </summary>
        public void Foo()
        {
            Console.WriteLine("Hello World!");
        }
    }
}
