using Iterator.DataStructure;
using Iterator.Iterators;
using Iterator.Model;

internal class Program
{
    private static void Main(string[] args)
    {
        IIterableCollection collection = TreeCollection.CreateSample();

        IIterator iter = collection.GetDepthIterator();
        //IIterator iter = collection.GetBreadthIterator();

        while (iter.HasMore())
        {
            Item i = iter.GetNext();
            Console.WriteLine(i);
        }
    }
}