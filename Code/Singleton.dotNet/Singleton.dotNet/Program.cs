using Singleton;

internal class Program
{
    private static void Main(string[] args)
    {
        SingletonClass obj0 = SingletonClass.GetInstance();
        SingletonClass obj1 = SingletonClass.GetInstance();
        SingletonClass obj2 = SingletonClass.GetInstance();
        SingletonClass obj3 = SingletonClass.GetInstance();
        SingletonClass obj4 = SingletonClass.GetInstance();

        obj0.PrintValAndInc(); // This should print 'Val is 0'
        obj1.PrintValAndInc(); // This should print 'Val is 1'
        obj2.PrintValAndInc(); // This should print 'Val is 2'
        obj3.PrintValAndInc(); // This should print 'Val is 3'
        obj4.PrintValAndInc(); // This should print 'Val is 4'
    }
}