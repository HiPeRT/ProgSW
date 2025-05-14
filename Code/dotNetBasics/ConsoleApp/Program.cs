using MySharedProject;

internal class Program
{
    private static void Main(string[] args)
    {
        // 1. Referencing a class from another project
        MySharedProject.MyClass myObj = new MySharedProject.MyClass();

        MyClassLibrary.MyClass myObj2 = new MyClassLibrary.MyClass();

        int multiplyRes = myObj.MultiplyByTwo(11);
        int divideRes = myObj2.DivideByTwo(4);


        Console.WriteLine($" Results are {multiplyRes} - {divideRes}" );
    }
}