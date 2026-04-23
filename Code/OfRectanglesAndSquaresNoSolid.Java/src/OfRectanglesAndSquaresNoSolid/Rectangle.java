package OfRectanglesAndSquaresNoSolid;

/**
 * Rectangle class.
 * This class breaks the 'S' principle of SOLID. Why?
 */
public class Rectangle {
	
	private double _height;
    private double _width;

    public void setHeight(double height) {
        this._height = height;
    }

    public void setWidth(double width) {
        this._width = width;
    }

    public double getWidth() {
        return this._width;
    }

    public double getHeight() {
        return this._height;
    }

    public Rectangle(double height, double width) {
        this._height = height;
        this._width = width;
    }
    
    /**
     * Business functionality
     * @return
     */
    public double calcArea() {
        return this._height * this._width;
    }
}
