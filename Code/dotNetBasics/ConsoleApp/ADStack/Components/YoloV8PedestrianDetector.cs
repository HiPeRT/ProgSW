using ConsoleApp.ADStack.Models;

namespace ConsoleApp.ADStack.Components
{
    /// <summary>
    /// Use Yolo v8 for pedestrian detection
    /// </summary>
    internal class YoloV8PedestrianDetector : IComponent
    {
        public void Start()
        {
            Console.WriteLine("[YoloV8PedestrianDetector] Starting.");
        }

        public void Stop()
        {
            Console.WriteLine("[YoloV8PedestrianDetector] Stopping.");
        }
    }
}
