using Visitor.Visitors;

namespace Visitor.Models
{
    /// <summary>
    /// This class extends a square so that it can be visited
    /// </summary>
    internal class VisitableSquare : Square, IVisitableObject
    {
        public VisitableSquare(double side) : base(side)
        {
        }

        public void Accept(IVisitor v)
        {
            v.Visit(this);
        }
    }
}
