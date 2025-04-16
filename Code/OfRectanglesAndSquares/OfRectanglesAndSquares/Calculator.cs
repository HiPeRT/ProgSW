namespace OfRectanglesAndSquares
{
    /// <summary>
    /// This class performs che computation of an area
    /// TODO interface segregation
    /// </summary>
    public class Calculator : ICalculator
    {
        /// <summary>
        /// Compute the area of a Rectangle
        /// </summary>
        /// <param name="r"></param>
        /// <returns></returns>
        public virtual double CalcArea(IRectangle r)
        {
            return r.GetHeight() * r.GetWidth();
        }
    }
}
