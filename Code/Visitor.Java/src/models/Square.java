package models;

/**
 * This class stores the status of a Square object.
 * In this case, I prefer to create the VisitableSquare class.
 */
public class Square {

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
