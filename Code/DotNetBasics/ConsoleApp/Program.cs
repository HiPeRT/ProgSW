// Same as "import" in Java
using DotNetBasics.ConsoleApp.Model;
using DotNetBasics.MySharedProject;
using Microsoft.CSharp.RuntimeBinder;
using System.Dynamic;

// Same as "package" in Java
namespace DotNetBasics.ConsoleApp
{

    /// <summary>
    /// This is the entry point of a console application
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            // 1. Referencing a class from another (shared code) project

            NewClass myObj = new NewClass();

            int multiplyRes = myObj.MultiplyByTwo(11);
            int divideRes = myObj.DivideByTwo(10);

            Console.WriteLine($"Result is {multiplyRes} - {divideRes}");

            // 2. Boxing and Unboxing

            int a = 11;
            object obj = a;

            Console.WriteLine($"Obj is {obj}");

            // Unbox the value
            int b = (int)obj;

            object[] myArr = { "ciao", 2, 'c', 456.781 };
            foreach (object o in myArr)
                Console.WriteLine(o);

            // Print only integers
            foreach (object o in myArr)
                if (o is int myInt)
                    Console.WriteLine(myInt);

            // 3. Generics (compiler infers data type)

            var myVar = 5;
            Console.WriteLine($"myVar is {myVar}");

            // 4. Nullables
            MyClass?[] maybeObjects =
            {
                MyClass.MaybeReturnObject(0), // This is null
                MyClass.MaybeReturnObject(1), // This is not null
            };

            foreach (var o in maybeObjects)
                if (o is not null)
                    Console.WriteLine($"Result on non-null obj is {o.MultiplyByTwo(4)}");

            // 5. Anonymous and Dynamics

            var myAnonymous = new
            {
                intField = 4,
                doubleField = 4.527,
                quasiIntField = (int)4.6
            };

            // This won't work (as the object would be identified as "ExpandoObject")
            //var myDynamic = new ExpandoObject();

            // This works, because the "dynamic" keyword/datatype enables
            // lazy type check by the compiler
            dynamic myDynamic = new ExpandoObject();

            myDynamic.SomeField = 5;
            if (a < 10)
                myDynamic.SomeOtherField = "ciao";

            Console.WriteLine($"SomeField is {myDynamic.SomeField}");
            // Typecheck is not performed, so this causes a RUNTIME error

            try
            {
                Console.WriteLine($"SomeField is {myDynamic.NonExistentFiel}");
            }
            catch (RuntimeBinderException)
            //catch (RuntimeBinderException rbe)
            {
                // BTW: NEVER LEAVE A CATCH EXPRESSION EMPTY
            }
            catch
            {
                Console.WriteLine("A Generic Exception occurred");
            }

            // 6. Getters and setters
            //var p = new Person();
            //p.Age = -1;
            // The requested coding style for Model Classes, is to use
            // as much as possible the default ctor, and properties
            var p = new Person { Age = 11 };

            Console.WriteLine($"p.Age is {p.Age}");
        }
    }
}
