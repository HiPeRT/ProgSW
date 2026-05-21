using ConsoleApp;
using ConsoleApp.ADStack;
using ConsoleApp.ADStack.Components;
using System.Reflection.PortableExecutable;
using System.Text;

internal class Program
{
    private static void Header(string text)
    {
        Console.WriteLine();
        Console.WriteLine("===============================");
        Console.WriteLine($"      {text}");
        Console.WriteLine("===============================");

    }

    /// <summary>
    /// Main entry point of application (class-based implementation). Could also be "script-like", main free implementation.
    /// </summary>
    /// <param name="args"></param>
    private static void Main(string[] args)
    {
        //
        // 1. Referencing classes from other projects, even in different (managed) language such as VB.
        //
        Header("Basics");
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
        Header("Checked/unchecked");
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
        Header("Lambdas");
        Action<int> myLambda = (int a) =>
        {
            Console.WriteLine($"Lambda called with {a}");
        };

        // Call it directly...
        myLambda(4);

        // ..or combine it with a Visitor pattern.
        var myvisitor = new MyLambdaInvoker(6);
        myvisitor.Invoke(myLambda);

        // You can also use an inline lambda
        myvisitor.Invoke(
            a => Console.WriteLine($"new Lambda called with {a}")
            );


        //
        // 5. Fluent programming interface
        //
        Header("Fluent");

        // A number of classes from the .NET framework implement a fluent programming interface
        var str = new StringBuilder()
            .Append("Hello")
            .Append(" ")
            .Append("World")
            .AppendLine("!")
            .ToString();

        Console.WriteLine(str.ToString());

        // This is my own implementation of a possible Autonomous Driving stack builder,
        //  where you can add components to the stack and then run it.

        var mapsrepo = new FileMapRepository(@"\resources\maps\");

        new ADStackComposer()
            // Set up the perception stack
            .AddPerception(new YoloV8PedestrianDetector())
            .AddPerception(new LidarClusteringForPedestrian())
            .AddFusion(new PedestrianDetector())

            // Set up the loc
            .AddPerception(new GNSSReceiver())
            .AddFusion(new EKFLocalization())

            // Add maps
            .RegisterMap(mapsrepo.Get("Modena"))
            .RegisterMap(mapsrepo.Get("Reggio Emilia"))
            .RegisterMap(mapsrepo.Get("Mantova"))


            // Register planner, controller and vehicle backend
            .AddPlanner(new PathPlanner())
            .AddController(new ModelPredictiveControl())
            .AddActuation(QuattroporteDBWAdapter.GetInstance()) // Singleton. I think we only have a single access to car control, right?

            // Ok, we can go...and hopefylly don't crash. And If we crash, it's not Fluent's fault!!!
            .Run();


        //
        // 6. Usage of lists and Linq to traverse them
        //
        Header("Language integrated query (LINQ");

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

        // Fluent interface which widely uses also lambdas
        var result2 = mylist
                       .Where(i => i.Payload.StartsWith("A"))
                       .Select(j => j.Id == 3 ? j.Id * 2 : j.Id * 6)
                       .OrderBy(k => k);
        Console.WriteLine($"Found object at Id {result.FirstOrDefault()}");
    }
}