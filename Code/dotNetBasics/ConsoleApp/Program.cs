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
        // 1. Referencing classes from another projects
        //
        
        MySharedProject.MyClass myObj = new MySharedProject.MyClass();
        MyClassLibrary.MyClass myObj2 = new MyClassLibrary.MyClass();

        int multiplyRes = myObj.MultiplyByTwo(11);
        int divideRes = myObj2.DivideByTwo(4);

        Console.WriteLine($" Results are {multiplyRes} - {divideRes}" );

        //
        // 2. Vars in nested context
        int b;
        for(int i = 0; i < 50; i++)
        {
            // This won't compile!
            //int a;
        }


        //
        // 3. Checked/unchecked
        //
        uint a = uint.MaxValue;

        unchecked
        {
            Console.WriteLine(a + 3);  // output: 2
        }

        try
        {
            checked
            {
                Console.WriteLine(a + 3);
            }
        }
        catch (OverflowException e)
        {
            Console.WriteLine(e.Message);  // output: Arithmetic operation resulted in an overflow.
        }


        //
        // 4. Lambda fns
        //
        Action<int> myLambda = (int a) =>
        {
            Console.WriteLine($"a is {a}");
        };

        // Call it directly...
        myLambda(4);

        // ...or implement a Visitor pattern
        var dataowner = new MyModel();
        dataowner.Invoke(myLambda);


        //
        // 5. Fluent interface
        //
        var myfluentlist = new MyList();
        myfluentlist.Add(5)
            .Add(1)
            .Add(5652)
            //.Reorder()
            .Persist();

        Console.WriteLine($"List is in state {myfluentlist.State}");

        //
        // 6. Use of list and linq-to-sql
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

        IEnumerable<int> result = from i in mylist
                     where i.Payload.StartsWith("A")
                     select i.Id;

        // Fluent interface
        var result2 = mylist.Where(i => i.Payload.StartsWith("A"))
                            .Select(j => j.Id);

        Console.WriteLine($"Found object at Id {result.FirstOrDefault()}");
    }
}