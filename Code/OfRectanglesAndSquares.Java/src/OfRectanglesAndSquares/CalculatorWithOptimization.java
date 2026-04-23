package OfRectanglesAndSquares;

/**
 * This class has an optimized calculus algorithm only for rectangles
 */
public class CalculatorWithOptimization extends Calculator {
    
	@Override
    public double calcArea(IRectangle r) {
        if (r.getWidth() == 0.0) return 0.0;
        if (r.getHeight() == 0.0) return 0.0;

        return super.calcArea(r);
    }

}
