package OfRectanglesAndSquares;

/**
 * This class adds a zero check for Rectangle height and width
 */
public class RectangleWithCheck extends Rectangle {
    
    public RectangleWithCheck(double height, double width) {
        super(height, width);
    }

    public void setHeight(double height) throws Exception {
        if (height < 0) throw new Exception("Wrong value for height " + height);
        super.setHeight(height);
    }

    public void setWidth(double width) throws Exception {
        if (width < 0) throw new Exception("Wrong value for height " + width);
        super.setWidth(width);
    }
}
