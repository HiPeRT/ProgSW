namespace ConsoleApp
{
    public enum MyListState
    {
        Draft = 0,
        Inserting,
        Ordered,
        Stored
    };

    internal class MyList : IMyList
    {
        private List<int> _thelist = new List<int>();
        private MyListState _state = MyListState.Draft;

        public MyListState State { get { return _state; } }

        public IMyList Add(int i)
        {
            _thelist.Add(i);
            _state = MyListState.Inserting;
            return this;
        }

        public IMyList Reorder()
        {
            _thelist.Sort();
            _state = MyListState.Ordered;
            return this;
        }

        public IMyList Persist()
        {
            // File.WriteAllLines requires a "IEnumerable<string>" param.
            //  We could do this using the "usual way"....

            //var listAsString = new List<string>();
            //foreach (int i in _thelist)
            //    listAsString.Add(i.ToString() + Environment.NewLine);

            //File.WriteAllLines("file.txt", listAsString);

            // ...but it's faster using fluent Linq API
            File.WriteAllLines("file.txt", _thelist.Select(x => x.ToString()));

            _state = MyListState.Stored;
            return this;
        }
    }
}
