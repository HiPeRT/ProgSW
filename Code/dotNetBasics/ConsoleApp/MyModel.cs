namespace ConsoleApp
{
    internal class MyModel
    {
        int mydata = 4;
        public void Invoke(Action<int> fn)
        {
            fn(mydata);
        }
    }
}
