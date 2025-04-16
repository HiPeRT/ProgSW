using OfRectanglesAndSquares;

/// <summary>
/// This is our main test class. 
/// TODO is this really single responsibility?
/// </summary>
public class Program
{
    /// <summary>
    /// Test for area doubled upon doubling the width
    /// TODO Interface segregation
    /// </summary>
    /// <param name="rectangle"></param>
    /// <exception cref="Exception"></exception>
    public static void TestDoubleArea(Rectangle rectangle, Calculator calculator)
    {
        double area1, area2;
        area1 = calculator.CalcArea(rectangle);

        rectangle.SetWidth(rectangle.GetWidth() * 2);
        area2 = calculator.CalcArea(rectangle);
        
        // Test ok
        if (area2 == area1 * 2)
            return;

        // If test fails, throw exception
        throw new Exception("Test failed! Expected " + area1 + ", got " + area2);
    }

    private static void Main(string[] args)
    {
        Calculator c = new Calculator();
        // Test Rectangle #1
        Rectangle r = new Rectangle(4, 5);
        TestDoubleArea(r, c);

        // Test Rectangle #2
        r = new Rectangle(2, 8);
        TestDoubleArea(r, c);

        // Test Square #1
        r = new Square(4);
        TestDoubleArea(r, c);

        // Test Square #2
        r = new Square(2);
        TestDoubleArea(r, c);
    }
}