using Visitor.Models;

namespace Visitor.Visitors
{
    /// <summary>
    /// A class that draws Rectangles and Squares.
    /// </summary>
    internal class DrawVisitor : IVisitor
    {
        private void NotImplemented()
        {
            Console.WriteLine("I'M SORRY GUYS BUT I'M NOT GOOD AT DRAWING!");
        }

        public void Visit(VisitableSquare s)
        {
            NotImplemented();
        }

        public void Visit(Rectangle s)
        {
            NotImplemented();
        }
    }
}