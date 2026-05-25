using Iterator.DataStructure;
using Iterator.Model;

namespace Iterator.Iterators
{
    /// <summary>
    /// Iterate over a IIterableCollection with BreadhFirst
    /// </summary>
    internal class BreadthFirstIterator : IIterator
    {
        private Queue<TreeNode> _curr = null;

        public BreadthFirstIterator(TreeCollection treeCollection)
        {
            this._curr = new Queue<TreeNode>();
            this._curr.Enqueue(treeCollection.GetRoot());

        }

        /* As IIterator */

        public Item GetNext()
        {
            var n = this._curr.Dequeue();

            // Add its two children as the last elements to be extracted
            if (n.Left != null) this._curr.Enqueue(n.Left);
            if (n.Right != null) this._curr.Enqueue(n.Right);

            return n.Item;
        }

        public bool HasMore() => this._curr.Count > 0;
    }
}
