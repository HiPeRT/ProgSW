package iterators;

import java.util.LinkedList;
import java.util.Queue;

import datastructure.TreeNode;
import model.Item;
import datastructure.TreeCollection;

/**
 * Iterate over a IIterableCollection with DepthFirst
 */
public class DepthFirstIterator implements IIterator {

	private Queue<TreeNode> _curr = null;
	
	/**
	 * Insert elements in the right order
	 * @param e
	 */
	private void insertElementInQueue(TreeNode e) {
		if(e == null) return;
		
		this._curr.add(e);
		
		if(e.getLeft() != null) {
			insertElementInQueue(e.getLeft());
		}
		
		if(e.getRight() != null) { 
			insertElementInQueue(e.getRight());		
		}
	}
	
	/* Here, we don't care of passing a concrete object instead of its
	 * interface, i.e., IITerableCollection. Why?
	 */
	public DepthFirstIterator(TreeCollection treeCollection) {
		this._curr = new LinkedList<TreeNode>();
		insertElementInQueue(treeCollection.getRoot());
	}

	@Override
	public Item getNext() {
		TreeNode ret = this._curr.element();
		this._curr.remove(ret);
		return ret.getItem();
	}

	@Override
	public boolean hasMore() {
		return !this._curr.isEmpty();
	}

}
