package models;

import visitors.IVisitor;

/**
 * This class extends a square so that it can be visited
 */
public class VisitableSquare extends Square implements IVisitableObject {

	public VisitableSquare(double side) {
		super(side);
	}

	@Override
	public void accept(IVisitor v) {
		v.visit(this);		
	}

}
