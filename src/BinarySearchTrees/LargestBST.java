package BinarySearchTrees;

//left side mdhun largest of all nodes  kdh mhnje bakiche sagle small asnar
//right side mdhun smallest of all node kdh--->largest<node<smallest
//no of elements =size =1+left+right
//postorder traversal

//tc--n sc--->1
/*public class LargestBST {
    class NodeValue {
        public int minNode, maxNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    class Solution {
        private NodeValue largestBSTSubtreeHelper(TreeNode root) {
            // An empty tree is a BST of size 0.

            if (root == null) {
                return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }

            // Get values from left and right subtree of the current tree.
            NodeValue left = largestBSTSubtreeHelper(root.left);
            NodeValue right = largestBSTSubtreeHelper(root.right);

            // Current node is greater than max in left AND smaller than min in right, it is a BST.
            if (left.maxNode < root.val && root.val < right.minNode) {
                // It is a BST.
                return new NodeValue(
                        Math.min(root.val, left.minNode),
                        Math.max(root.val, right.maxNode),
                        left.maxSize + right.maxSize + 1
                );
            } else {
                // Otherwise, return [-inf, inf] so that parent can't be a valid BST
                return new NodeValue(
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE,
                        Math.max(left.maxSize, right.maxSize)
                );
            }
        }

        public int largestBSTSubtree(TreeNode root) {
            return largestBSTSubtreeHelper(root).maxSize;
        }
    }

}
*/