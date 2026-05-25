using Iterator.Iterators;

namespace Iterator.DataStructure
{
    /// <summary>
    /// Retrieve the supported traversing algos
    /// </summary>
    internal interface IIterableCollection
    {
        public IIterator GetBreadthIterator();
        public IIterator GetDepthIterator();
    }
}
