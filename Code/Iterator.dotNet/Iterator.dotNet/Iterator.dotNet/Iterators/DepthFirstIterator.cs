using Iterator.DataStructure;
using Iterator.Model;

namespace Iterator.Iterators
{
    /// <summary>
    /// Iterate over a IIterableCollection with DepthFirst
    /// </summary>
    internal class DepthFirstIterator : IIterator
    {
        private Queue<TreeNode> _curr = null;

        private void InsertElementInQueue(TreeNode e)
        {
            if (e == null) return;

            this._curr.Enqueue(e);

            if (e.Left != null) InsertElementInQueue(e.Left);

            if (e.Right != null) InsertElementInQueue(e.Right);
        }

        public DepthFirstIterator(TreeCollection treeCollection)
        {
            _curr = new Queue<TreeNode>();
            InsertElementInQueue(treeCollection.GetRoot());

        }

        /* As IIterator */

        public Item GetNext()
        {
            var ret = _curr.Dequeue();
            return ret.Item;
        }

        public bool HasMore() => this._curr.Count > 0;
    }
}
