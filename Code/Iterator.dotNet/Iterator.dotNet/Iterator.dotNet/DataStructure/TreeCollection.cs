using Iterator.Iterators;
using Iterator.Model;

namespace Iterator.DataStructure
{
    /// <summary>
    /// My implementation of a tree with iterators
    /// </summary>
    internal class TreeCollection : IIterableCollection
    {
        private TreeNode _root = null;

        public TreeNode GetRoot()
        {
            return _root;
        }

        /* As IIterableCollection */
        public IIterator GetBreadthIterator() => new BreadthFirstIterator(this);

        public IIterator GetDepthIterator() => new DepthFirstIterator(this);


        /// <summary>
        /// This is a factory for tests.
        /// </summary>
        /// <returns></returns>
        public static TreeCollection CreateSample()
        {
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
}
