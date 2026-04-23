package OfRectanglesAndSquaresNoSolid;

public class App {
	/**
	 * Test to check that doubling width doubles area
	 * @param rectangle
	 * @throws Exception
	 */
	 public static void TestDoubleArea(Rectangle rectangle) throws Exception {
	        double area1, area2;
	        area1 = rectangle.calcArea();

	        rectangle.setWidth(rectangle.getWidth() * 2);
	        area2 = rectangle.calcArea();
	        
	        // Test ok
	        if (area2 == area1 * 2)
	            return;

	        // If test fails, throw exception
	        throw new Exception("Test failed! Expected " + area1 + ", got " + area2);
	    }

	    public static void main(String[] args) throws Exception {

	        // Test Rectangle #1
	        Rectangle r = new Rectangle(4, 5);
	        TestDoubleArea(r);
	        
	        // Test Rectangle with round capabilities
	        // TODO you do this...

	        // Test Square #1
	        r = new Square(4);
	        TestDoubleArea(r);

	        // Test Square #2
	        r = new Square(2);
	        TestDoubleArea(r);

	        System.out.println("ALL TESTS RUN SUCCESFULLY.");
	    }
}
