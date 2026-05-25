package datastructure;

import iterators.IIterator;

/**
 * Retrieve the supported traversing algos
 */
public interface IIterableCollection {

	public IIterator getBreadthIterator();
	public IIterator getDepthIterator();

}
