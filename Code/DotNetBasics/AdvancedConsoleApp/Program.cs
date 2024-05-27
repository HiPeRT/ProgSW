using AdvancedConsoleApp;
using System.Xml;

namespace DotNetBasics.AdvancedConsoleApp
{
    /// <summary>
    /// This is the entry point of a console application
    /// </summary>
    public class Program
    {
        public static void NoLambda()
        {
            Console.WriteLine("I am no lambda func");
        }

        public static async Task Main(string[] args)
        {
            // Api proxy
            var apiProxy = new MyApi();

            //// 1. Invoke the service with lambda stored as variable
            //Action myLambda = () =>
            //{
            //    Console.WriteLine("I am a lambda function");
            //};

            //apiProxy.ServiceWithCallBack(1, myLambda);

            //// 2. Using another lambda (still, stored as variable)
            //var myLambda2 = () => Console.WriteLine("I am another lambda");

            //apiProxy.ServiceWithCallBack(2, myLambda2);

            //// 3. Using an inline lambda
            //apiProxy.ServiceWithCallBack(3, () =>
            //{
            //    Console.WriteLine("I am an inline lambda");
            //});

            //// 4. The "standard" way: using an explicitly declared function
            //apiProxy.ServiceWithCallBack(4, NoLambda);

            Task<int> t = apiProxy.AsyncService();

            Console.WriteLine("After invoking the ASYNC method");
            Console.WriteLine("I can do some other stuff");

            // Now, it's time to wait for the result
            int result = await t;
            // Or, as inline..
            //int result = await apiProxy.AsyncService();
            Console.WriteLine($"Result is {result}");

            /*
             * So, the parallel (async) thread who has to FULFILL the promise,
             * runs the following code (as modified/extracted by compiler)
              
                Task.Delay(10000);
                Console.WriteLine("I am doing some work, and producing an integer");

                int result = 11
                Console.WriteLine($"Result is {result}");

             */

        }
    }
}
