namespace ConsoleApp
{
    internal interface IMyList
    {
        IMyList Add(int i);

        IMyList Reorder();

        IMyList Persist();
    }
}
