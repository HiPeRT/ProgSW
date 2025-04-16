namespace OfRectanglesAndSquares
{
    /// <summary>
    /// This class stores the status of a Square object
    /// TODO breaks Liskov
    /// </summary>
    public class Square : Rectangle
    {
        public override void SetWidth(double width)
        {
            base.SetWidth(width);
            base.SetHeight(width);
        }

        public override void SetHeight(double height)
        {
            base.SetHeight(height);
            base.SetWidth(height);
        }

        public Square(double side) : base(side, side)
        {
        }
    }
}
