namespace OfRectanglesAndSquares
{
    /// <summary>
    /// This class has an optimized calculus algorithm
    /// </summary>
    public class CalculatorWithOptimization : Calculator
    {
        public override double CalcArea(Rectangle r)
        {
            if (r.GetWidth() == 0.0) return 0.0;
            if (r.GetHeight() == 0.0) return 0.0;

            return base.CalcArea(r);
        }
    }
}
