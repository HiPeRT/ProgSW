using ConsoleApp.ADStack.Models;

namespace ConsoleApp.ADStack.Components
{
    /// <summary>
    /// Fusion module for pedestrian detector
    /// </summary>
    internal class PedestrianDetector : IFusion
    {
        public void Bind(IComponent component)
        {
            Console.WriteLine($"[PedestrianDetector] Binding component: {component.GetType().Name}");
        }

        public void Start()
        {
            Console.WriteLine("[PedestrianDetector] Starting.");
        }

        public void Stop()
        {
            Console.WriteLine("[PedestrianDetector] Stopping.");
        }
    }
}
