using ConsoleApp.ADStack.Models;

namespace ConsoleApp.ADStack.Components
{
    /// <summary>
    /// Detect pedestrian with our amazing clustering algo
    /// </summary>
    internal class LidarClusteringForPedestrian : IComponent
    {
        public void Start()
        {
            Console.WriteLine("[LidarClusteringForPedestrian] Starting.");
        }

        public void Stop()
        {
            Console.WriteLine("[LidarClusteringForPedestrian] Stopping.");
        }
    }
}
