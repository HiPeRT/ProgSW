namespace Factory.Interfaces
{
    /// <summary>
    /// If to the factory of IThings
    /// </summary>
    public interface IFactory
    {
        IThing CreateThing();
    }
}
