
namespace Singleton
{
    /// <summary>
    /// This class implements a singleton pattern.
    /// This class is not thread safe.
    /// </summary>
    internal class SingletonClass
    {
        // Used to check whether we are accessing the singleton object
        private int _val = 0;

        private static SingletonClass? _Instance;


        private SingletonClass()
        {
            
        }

        internal static SingletonClass GetInstance()
        {
            if(_Instance == null)
                _Instance = new SingletonClass();

            return _Instance;
        }

        internal void PrintValAndInc()
        {
            Console.WriteLine($"Val is {_val}");
            _val++;
        }
    }
}
