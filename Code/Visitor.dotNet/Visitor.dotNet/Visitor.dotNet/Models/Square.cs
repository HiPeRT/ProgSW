namespace Visitor.Models
{
    /// <summary>
    /// This class stores the status of a Square object.
    /// In this case, I prefer to create the VisitableSquare class.
    /// </summary>
    internal class Square
    {
        private double _side;

        public double Side
        {
            get { return _side; }
            set { _side = value; }
        }

        public Square(double side)
        {
            _side = side;
        }

    }
}
