package OfRectanglesAndSquares;

/**
 * This class stores the status of a Square object
 */
public class Square extends Rectangle {

    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    public void setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    public Square(double side) {
        super(side, side);
    }
}
