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
    

    public static void TestQuadrupleArea(ISquare rectangle, ICalculator calculator) throws Exception {
        double area1, area2;
        area1 = calculator.calcArea(rectangle);

        rectangle.setSide(rectangle.getSide() * 2);
        area2 = calculator.calcArea(rectangle);
        
        // Test ok
        if (area2 == area1 * 4)
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
        r = new RectangleWithRound(2, 8);
        TestDoubleArea(r, c);

        // Test Square #1
        ISquare s = new Square(4);
        // This would be a more suitable test...
        TestQuadrupleArea(s, c);

        // Test Square #2
        s = new Square(2);
        TestQuadrupleArea(s, c);
        
        System.out.println("ALL TESTS RUN SUCCESFULLY.");
    }
}
