namespace AdvancedConsoleApp
{
    internal class MyApi
    {
        /// <summary>
        /// Synchronous API
        /// </summary>
        /// <param name="param"></param>
        /// <param name="myCallback"></param>
        public void ServiceWithCallBack(int param, Action myCallback)
        {
            // Do something
            Console.WriteLine($"I am working (and blocking the main thread). param is {param}");
            Thread.Sleep(param * 1000);
            Console.WriteLine("I finished working");

            // Invoke the delegate
            myCallback();
        }

        public async Task<int> AsyncService()
        {
            // I am saying: the remainder of the function will run on a separate task, after 10000ms
            // This is the "PROMISE" PATTERN, also (possibly) seen in Mobile/Web programming
            await Task.Delay(10000);
            Console.WriteLine("I am doing some work, and producing an integer");
            return 11;
        }
    }
}
