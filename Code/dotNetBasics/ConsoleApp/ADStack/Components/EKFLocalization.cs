using ConsoleApp.ADStack.Models;

namespace ConsoleApp.ADStack.Components
{
    /// <summary>
    /// Loc with Extended Kalman filter
    /// </summary>
    internal class EKFLocalization : IFusion
    {
        public void Bind(IComponent component)
        {
            Console.WriteLine($"[EKFLocalization] Binding component: {component.GetType().Name}");
        }

        public void Start()
        {
            Console.WriteLine("[EKFLocalization] Starting.");
        }

        public void Stop()
        {
            Console.WriteLine("[EKFLocalization] Stopping.");
        }
    }
}
