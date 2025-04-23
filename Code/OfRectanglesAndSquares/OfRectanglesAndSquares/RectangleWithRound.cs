namespace OfRectanglesAndSquares
{
    /// <summary>
    /// This class rounds Rectangle height and width on sets to the ceiling integer
    /// </summary>
    public class RectangleWithRound : Rectangle
    {
        public RectangleWithRound(double height, double width) : base(height, width)
        {
        }

        public override void SetHeight(double height)
        {
            base.SetHeight(Math.Ceiling(height));
        }

        public override void SetWidth(double width)
        {
            base.SetWidth(Math.Ceiling(width));
        }
    }
}
