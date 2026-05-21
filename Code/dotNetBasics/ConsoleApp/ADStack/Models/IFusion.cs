namespace ConsoleApp.ADStack.Models
{
    /// <summary>
    /// Interface to fusion components
    /// </summary>
    internal interface IFusion : IComponent
    {
        /// <summary>
        /// Register this component as a source
        /// </summary>
        /// <param name="component"></param>
        void Bind(IComponent component);
    }
}
