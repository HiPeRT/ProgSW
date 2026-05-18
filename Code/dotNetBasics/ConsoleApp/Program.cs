using ConsoleApp;


internal class Program
{
    /// <summary>
    /// Main entry point of application (class-based implementation). Could also be "script-like", main free implementation.
    /// </summary>
    /// <param name="args"></param>
    private static void Main(string[] args)
    {
        //
        // 1. Referencing classes from other projects, even in different (managed) language such as VB.
        //
        MyClassLibrary.MyClass myObj = new MyClassLibrary.MyClass();
        MySharedProject.MyClass myObj2 = new MySharedProject.MyClass();
        MyVbLibrary.MyClass myVbObj = new MyVbLibrary.MyClass();

        int multiplyRes = myObj.MutliplyByTwo(11);
        int divideRes = myObj2.DivideByTwo(4);
        int multiplyVbRes = myVbObj.MultiplyByTwo(6);

        Console.WriteLine($"Results are {multiplyRes} - {divideRes} - {multiplyVbRes}");


        //
        // 2. Vars in nested context are not legal.
        //
        int b;
        for (int i = 0; i < 10; i++)
        {
            //int b; // This won't compile!
        }


        //
        // 3. Checked/unchecked
        //
        uint a = uint.MaxValue;

        unchecked
        {
            Console.WriteLine(a + 3);  // Expected output: 2
        }

        try
        {
            checked
            {
                Console.WriteLine(a + 3);
            }
        }
        catch (OverflowException ex)
        {
            Console.WriteLine($"Overflow exception caught: {ex.Message}");
        }


        //
        // 4. Lambda fns
        //
        Action<int> myLambda = (int a) =>
        {
            Console.WriteLine($"Lambda called with {a}");
        };

        // Call it directly...
        myLambda(4);

        // ..or implement a Visitor pattern....
        var myvisitor = new MyLambdaInvoker(6);

        myvisitor.Invoke(myLambda);

        // ..even with an inline lambda
        myvisitor.Invoke(
            a => Console.WriteLine($"new Lambda called with {a}")
            );

        //
        // 5. Fluent interface
        //

        // TODO MyList


        //
        // 6. Use of list and LinQ to SQL
        //

        var mylist = new List<MyDataType>()
        {
            new MyDataType() { Id = 0, Payload = "Paolo" },
            new MyDataType() { Id = 1, Payload = "Cristina" },
            new MyDataType() { Id = 2, Payload = "Andrea" },
            new MyDataType() { Id = 3, Payload = "Benedetta" },
            new MyDataType() { Id = 5, Payload = "Angelo" },
        };

        // SQL syntax
        var result = from i in mylist
                     where i.Payload.StartsWith("A")
                     select i.Id == 3 ? i.Id * 2 : i.Id * 6;

        // Fluent interface
        var result2 = mylist
                       .Where(i => i.Payload.StartsWith("A"))
                       .Select(j => j.Id == 3 ? j.Id * 2 : j.Id * 6)
                       .OrderBy(k => k);
        Console.WriteLine($"Found object at Id {result.FirstOrDefault()}");
    }
}