package OfRectanglesAndSquares;

public class App {

    public static void TestDoubleArea(IRectangle rectangle, ICalculator calculator) throws Exception {
        double area1, area2;
        area1 = calculator.calcArea(rectangle);

        rectangle.setWidth(rectangle.getWidth() * 2);
        area2 = calculator.calcArea(rectangle);
        
        // Test ok
        if (area2 == area1 * 2)
            return;

        // If test fails, throw exception
        throw new Exception("Test failed! Expected " + area1 + ", got " + area2);
    }

    public static void main(String[] args) throws Exception {
        ICalculator c = new Calculator();

        // Test Rectangle #1
        IRectangle r = new Rectangle(4, 5);
        TestDoubleArea(r, c);
        
        // Test Rectangle #2
        r = new RectangleWithCheck(2, 8);
        TestDoubleArea(r, c);

        // Test Square #1
        r = new Square(4);
        TestDoubleArea(r, c);

        // Test Square #2
        r = new Square(2);
        TestDoubleArea(r, c);
    }
}
