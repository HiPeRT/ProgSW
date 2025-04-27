package OfRectanglesAndSquares;

/**
 * This class has an optimized calculus algorithm
 */
public class CalculatorWithOptimization extends Calculator {
    
    public double CalcArea(IRectangle r) {
        if (r.getWidth() == 0.0) return 0.0;
        if (r.getHeight() == 0.0) return 0.0;

        return super.calcArea(r);
    }
}
