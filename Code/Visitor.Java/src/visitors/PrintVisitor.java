package visitors;

import models.*;
public class PrintVisitor implements IVisitor {

	@Override
	public void visit(VisitableSquare s) {
		System.out.println("This square has side " + s.getSide());
	}

	@Override
	public void visit(Rectangle r) {
		System.out.println("This rectangle has width " + r.getWidth() + " and height " + r.getHeight());
	}

}
