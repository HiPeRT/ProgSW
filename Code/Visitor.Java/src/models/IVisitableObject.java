package models;

import visitors.IVisitor;

/**
 * Interface that every visitable object shall implement
 */
public interface IVisitableObject {
	
	void accept(IVisitor v);

}
