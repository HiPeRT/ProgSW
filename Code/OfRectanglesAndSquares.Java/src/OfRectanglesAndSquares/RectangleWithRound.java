package OfRectanglesAndSquares;

/**
 * This class rounds Rectangle height and width on sets to the ceiling integer
 */
public class RectangleWithRound extends Rectangle {
    
    public RectangleWithRound(double height, double width) {
        super(height, width);
    }

    public void setHeight(double height) {
        super.setHeight(Math.ceil(height));
    }

    public void setWidth(double width) {
        super.setWidth(Math.ceil(width));
    }
}
