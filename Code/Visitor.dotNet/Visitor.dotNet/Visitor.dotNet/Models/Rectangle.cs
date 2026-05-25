using Visitor.Visitors;

namespace Visitor.Models
{
    /// <summary>
    /// This class handles the status of a Rectangle.
    /// In this version, I directly modify the Rectangle class.
    /// </summary>
    internal class Rectangle : IVisitableObject
    {
        private double _height;
        private double _width;

        public double Height
        {
            get { return _height; }
            set { _height = value; }
        }

        public double Width
        {
            get { return _width; }
            set { _width = value; } 
        }

        public Rectangle(double height, double width)
        {
            _height = height;
            _width = width;
        }

        /* As IVisitableObject */
        public void Accept(IVisitor v)
        {
            v.Visit(this);
        }

    }
}
