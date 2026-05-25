using Visitor.Models;
using Visitor.Visitors;

internal class Program
{
    private static void Main(string[] args)
    {
        new Rectangle(4, 5).Accept(new PrintVisitor());

        new VisitableSquare(5).Accept(new DrawVisitor());
    }
}