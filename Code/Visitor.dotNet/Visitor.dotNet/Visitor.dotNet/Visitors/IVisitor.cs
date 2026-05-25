using Visitor.Models;

namespace Visitor.Visitors
{
    /// <summary>
    /// Interface to visitors
    /// </summary>
    internal interface IVisitor
    {
        void Visit(VisitableSquare s);
        void Visit(Rectangle r);
    }
}
