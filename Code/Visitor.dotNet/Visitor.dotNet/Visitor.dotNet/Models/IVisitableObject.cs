using Visitor.Visitors;

namespace Visitor.Models
{
    /// <summary>
    /// Interface that every visitable object shall implement
    /// </summary>
    internal interface IVisitableObject
    {
        void Accept(IVisitor v);
    }
}
