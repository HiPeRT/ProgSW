package datastructure;

import iterators.DepthFirstIterator;
import iterators.IIterator;
import iterators.solution.BreadthFirstIterator;
import model.Item;

/**
 * My implementation of a tree with iterators
 */
public class TreeCollection implements IIterableCollection {

	private TreeNode _root = null;
	
	public TreeNode getRoot() {
		return this._root;
	}
	
	/* As IIterableCollection */
	@Override
	public IIterator getBreadthIterator() {
		return new BreadthFirstIterator(this);
	}

	@Override
	public IIterator getDepthIterator() {
		return new DepthFirstIterator(this);
	}
		
	/**
	 * This is a factory for tests.
	 */
	public static TreeCollection createSample() {
		TreeCollection ret = new TreeCollection();

		ret._root = new TreeNode(
				new Item(0),
				new TreeNode(new Item(1),
						new TreeNode(new Item(3),
								new TreeNode(new Item(7), null, null),
								new TreeNode(new Item(8), null, null)
								),
						new TreeNode(new Item(4),
								new TreeNode(new Item(9), null, null),
								new TreeNode(new Item(10), null, null)
								)
						),
				new TreeNode(new Item(2),
						new TreeNode(new Item(5),
								new TreeNode(new Item(11), null, null),
								new TreeNode(new Item(12), null, null)
								),
						new TreeNode(new Item(6),
								new TreeNode(new Item(13), null, null),
								new TreeNode(new Item(14), null, null)
								)
						)
					);
		
		return ret;
		
	}

}
