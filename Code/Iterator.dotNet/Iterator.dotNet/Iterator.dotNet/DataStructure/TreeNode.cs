using Iterator.Model;

namespace Iterator.DataStructure
{
    /// <summary>
    ///  A node of our binary tree
    /// </summary>
    internal class TreeNode
    {
        private Item _item = null;
        private TreeNode _left = null;
        private TreeNode _right = null;

        public Item Item
        {
            get { return _item; }
        }

        public TreeNode Left
        {
            get { return _left; }
        }

        public TreeNode Right
        {
            get { return _right; }
        }

        public TreeNode(Item item, TreeNode left, TreeNode right)
        {
            _item = item;
            _left = left;
            _right = right;
        }
    }
}
