using ConsoleApp.ADStack.Models;

/// <summary>
/// GNSS/GPS receiver
/// </summary>
internal class GNSSReceiver : IComponent
{
    public void Start()
    {
        Console.WriteLine("[GNSSReceiver] Starting.");
    }

    public void Stop()
    {
        Console.WriteLine("[GNSSReceiver] Stopping.");
    }
}