package OfRectanglesAndSquares;

/**
 * This class stores the status of a Square object
 */
public class Square implements ISquare {

    private double _side;
    
    public void setSide(double side) {
        this._side = side;
    }
    
    public double getSide() {
		return _side;
	}

	public Square(double side) {
    	this._side = side;
    }
}
