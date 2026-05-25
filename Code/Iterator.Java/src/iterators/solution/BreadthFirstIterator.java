package iterators.solution;

import java.util.LinkedList;
import java.util.Queue;

import datastructure.TreeNode;
import datastructure.TreeCollection;
import iterators.IIterator;
import model.Item;

/**
 * Iterate over a IIterableCollection with BreadhFirst
 */
public class BreadthFirstIterator implements IIterator {

	private Queue<TreeNode> _curr = null;
	
	public BreadthFirstIterator(TreeCollection treeCollection) {
		this._curr = new LinkedList<TreeNode>();
		this._curr.add(treeCollection.getRoot());
	}

	@Override
	public Item getNext() {
		TreeNode n = this._curr.element();
		this._curr.remove(n);
		
		// Add its two children as the last elements to be extracted
		if(n.getLeft() != null) this._curr.add(n.getLeft());
		if(n.getRight() != null) this._curr.add(n.getRight());
		
		return n.getItem();
	}

	@Override
	public boolean hasMore() {
		return !this._curr.isEmpty();
	}
}
