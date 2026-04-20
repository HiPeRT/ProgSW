package OfRectanglesAndSquares;

/**
 * This class performs che computation of an area
 */
public class Calculator implements ICalculator {

    /**
     * Compute the area of a Rectangle
     */
    public double calcArea(IRectangle r) {
        return r.getHeight() * r.getWidth();
    }

}
