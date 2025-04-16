namespace OfRectanglesAndSquares
{
    /// <summary>
    /// This class adds a zero check for Rectangle height and width
    /// </summary>
    public class RectangleWithCheck : Rectangle
    {
        public RectangleWithCheck(double height, double width) : base(height, width)
        {
        }

        public override void SetHeight(double height)
        {
            if (height < 0) throw new Exception("Wrong value for height " + height);
            base.SetHeight(height);
        }

        public override void SetWidth(double width)
        {
            if (width < 0) throw new Exception("Wrong value for height " + width);
            base.SetWidth(width);
        }
    }
}
