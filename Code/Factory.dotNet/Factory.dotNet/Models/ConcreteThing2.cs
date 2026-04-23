using Factory.Interfaces;

namespace Factory.Models
{
    /// <summary>
    /// ConcreteThing2 entity
    /// </summary>
    public class ConcreteThing2 : IThing
    {
        public void Foo()
        {
            Console.WriteLine("Hello World 2!");
        }
    }
}
