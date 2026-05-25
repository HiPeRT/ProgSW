package visitors;

import models.*;

/**
 * A class that draws Rectangles and Squares.
 */
public class DrawVisitor implements IVisitor {

	private void NotImplemented() {
		System.out.println("I'M SORRY GUYS BUT I'M NOT GOOD AT DRAWING!");
	}
	
	@Override
	public void visit(VisitableSquare s) {
		NotImplemented();		
	}

	@Override
	public void visit(Rectangle s) {
		NotImplemented();
	}


}
