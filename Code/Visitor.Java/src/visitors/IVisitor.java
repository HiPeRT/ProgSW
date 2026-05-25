package visitors;

import models.*;

/**
 * Interface to visitors
 */
public interface IVisitor {

	void visit(VisitableSquare s);
	void visit(Rectangle r);

}
