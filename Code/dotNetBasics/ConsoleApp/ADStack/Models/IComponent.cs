namespace ConsoleApp.ADStack.Models
{
    internal interface IComponent
    {
        /// <summary>
        /// Each component has its own internal thread. We start it.
        /// </summary>
        void Start();

        /// <summary>
        /// Stop and dispose.
        /// </summary>
        void Stop();
    }
}
