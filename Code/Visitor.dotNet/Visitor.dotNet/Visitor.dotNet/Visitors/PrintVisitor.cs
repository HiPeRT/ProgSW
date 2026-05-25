
using Visitor.Models;

namespace Visitor.Visitors
{
    internal class PrintVisitor : IVisitor
    {
        public void Visit(VisitableSquare s)
        {
            Console.WriteLine($"This square has side {s.Side}");
        }

        public void Visit(Rectangle r)
        {
            Console.WriteLine($"This rectangle has width {r.Width} amd height {r.Height}");
        }
    }
}