namespace OfRectanglesAndSquares
{
    public interface IRectangle
    {
        void SetHeight(double height);

        void SetWidth(double width);

        /// <summary>
        /// Returns the width of a Rectangle
        /// </summary>
        /// <returns></returns>
        double GetWidth();

        /// <summary>
        /// Returns the height of a Rectangle
        /// </summary>
        /// <returns></returns>
        double GetHeight();
    }
}
