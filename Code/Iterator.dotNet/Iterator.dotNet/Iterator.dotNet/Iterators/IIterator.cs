using Iterator.Model;

namespace Iterator.Iterators
{
    /// <summary>
    /// Interface for Iterators
    /// </summary>
    internal interface IIterator
    {
        Item GetNext();
        bool HasMore();
    }
}
