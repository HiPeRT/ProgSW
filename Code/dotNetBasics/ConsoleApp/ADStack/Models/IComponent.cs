namespace ConsoleApp.ADStack.Models
{
    /// <summary>
    /// Generic AD component
    /// </summary>
    internal interface IComponent
    {
        /// <summary>
        /// Each component has its own internal thread. We start it.
        /// </summary>
        void Start();

        /// <summary>
        /// 
        /// </summary>
        void Stop();
    }
}
