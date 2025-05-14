internal class Program
{
    /// <summary>
    /// Main entry point of application (class-based implementatin. Could also be "script-like", main free implementation
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


        //TODO the rest
    }
}