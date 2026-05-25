package datastructure;

import model.Item;

/**
 * A node of our binary tree
 */
public class TreeNode {
	
	private Item _item = null;
	private TreeNode _left = null;
	private TreeNode _right = null;

	public Item getItem() {
		return _item;
	}

	public TreeNode getLeft() {
		return _left;
	}
	
	public TreeNode getRight() {
		return _right;
	}
	
	public TreeNode(Item item, TreeNode left, TreeNode right) {
		
		this._item = item;
		this._left = left;
		this._right = right;

	}

}
