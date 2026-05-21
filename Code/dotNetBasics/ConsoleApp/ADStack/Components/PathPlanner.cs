using ConsoleApp.ADStack.Models;

namespace ConsoleApp.ADStack.Components
{
    internal class PathPlanner : IComponent
    {
        public void Start()
        {
            Console.WriteLine("[PathPlanner] Starting.");
        }

        public void Stop()
        {
            Console.WriteLine("[PathPlanner] Stopping.");
        }
    }
}
