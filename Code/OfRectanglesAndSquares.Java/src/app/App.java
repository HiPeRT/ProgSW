package app;

import calculators.Calculator;
import interfaces.ICalculator;
import interfaces.IRectangle;
import interfaces.ISquare;
import shapes.Rectangle;
import shapes.RectangleWithRound;
import shapes.Square;

public class App {
    

    public static void main(String[] args) throws Exception {

        ICalculator c = new Calculator();

        // Test Rectangle #1
        IRectangle r = new Rectangle(4, 5);
        double x = c.calcArea(r);
        System.out.print(x);
        System.exit(0);
    }
}