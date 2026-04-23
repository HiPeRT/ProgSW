package OfRectanglesAndSquares;

/**
 * This interface represents the (business) logic for computing the area of geometric shapes
 */
public interface ICalculator {
    
	double calcArea(IRectangle r);
    
    double calcArea(ISquare r);

}
