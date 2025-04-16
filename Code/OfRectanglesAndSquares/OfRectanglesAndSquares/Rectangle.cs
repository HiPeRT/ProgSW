namespace OfRectanglesAndSquares
{
    /// <summary>
    /// This class handles the status of a Rectangle
    /// TODO add Interface
    /// </summary>
    public class Rectangle : IRectangle
    {
        private double _height;
        private double _width;

        public virtual void SetHeight(double height)
        {
            this._height = height;
        }

        public virtual void SetWidth(double width)
        {
            this._width = width;
        }

        public virtual double GetWidth()
        {
            return this._width;
        }

        public virtual double GetHeight()
        {
            return this._height;
        }

        public Rectangle(double height, double width)
        {
            this._height = height;
            this._width = width;
        }

    }
}
