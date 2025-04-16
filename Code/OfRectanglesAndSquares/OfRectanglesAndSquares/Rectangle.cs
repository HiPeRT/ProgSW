namespace OfRectanglesAndSquares
{
    /// <summary>
    /// This class handles the status of a Rectangle
    /// </summary>
    public class Rectangle
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

        /// <summary>
        /// Returns the width of a Rectangle
        /// </summary>
        /// <returns></returns>
        public virtual double GetWidth()
        {
            return this._width;
        }

        /// <summary>
        /// Returns the height of a Rectangle
        /// </summary>
        /// <returns></returns>
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
