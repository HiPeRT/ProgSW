using Factory.Models;

namespace Factory.WithGenerics
{
    /// <summary>
    /// Same as <see cref="FactoryWithGenerics{T}"></see> but without the need to specify it while creating/>
    /// </summary>
    public class FactoryWithDefault : FactoryWithGenerics<ConcreteThing>
    {
    }
}
