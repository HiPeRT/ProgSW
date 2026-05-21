using ConsoleApp.ADStack.Models;

/// <summary>
/// MPC
/// </summary>
internal class ModelPredictiveControl : IComponent
{
    public void Start()
    {
        Console.WriteLine("[ModelPredictiveControl] Starting.");
    }

    public void Stop()
    {
        Console.WriteLine("[ModelPredictiveControl] Stopping.");
    }
}