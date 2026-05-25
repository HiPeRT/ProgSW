package iterators;

import model.Item;

/**
 * Interface for Iterators
 */
public interface IIterator {
	
	Item getNext();
	boolean hasMore();

}
