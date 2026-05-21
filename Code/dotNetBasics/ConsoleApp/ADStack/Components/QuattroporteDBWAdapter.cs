using ConsoleApp.ADStack.Models;

namespace ConsoleApp.ADStack.Components
{
    /// <summary>
    /// Maserati 4porte Drive-by-Wire system.
    /// Do you remember the Adapter and Singleton Patterns?
    /// </summary>
    internal class QuattroporteDBWAdapter : IComponent
    {
        private static QuattroporteDBWAdapter _Instance = null;
        private QuattroporteDBWAdapter()
        {
        }

        public static QuattroporteDBWAdapter GetInstance()
        {
            if (_Instance == null) _Instance = new QuattroporteDBWAdapter();
            return _Instance;
        }

        public void Start()
        {
            Console.WriteLine("[QuattroporteDBWAdapter] Starting.");
        }

        public void Stop()
        {
            Console.WriteLine("[QuattroporteDBWAdapter] Stopping.");
        }
    }
 }
