package OfRectanglesAndSquaresNoSolid;

/**
 * Generic square. This class breaks the 'L' principle of SOLID. Why?
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
