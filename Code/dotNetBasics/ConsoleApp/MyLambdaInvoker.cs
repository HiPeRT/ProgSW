namespace ConsoleApp
{
    /// <summary>
    /// This class invokes a lambda expression, and the int value is increased at every invocation.
    /// </summary>
    internal class MyLambdaInvoker
    {
        private int _a;

        public MyLambdaInvoker(int a)
            => _a = a;

        public void Invoke(Action<int> action)
            // Let's assume that for some business logics, a shall be incremented at every invocation.
            => action(_a++);
    }
}
