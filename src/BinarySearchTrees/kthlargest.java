package BinarySearchTrees;

import javax.swing.tree.TreeNode;

/*public class kthlargest {
    public int kthLargest(TreeNode root, int k) {
        int[] count = new int[]{0};
        int[] kthLargest = new int[]{Integer.MIN_VALUE};
        reverseInorderHelper(root, count, k, kthLargest);
        return kthLargest[0];
    }

    public void reverseInorderHelper(TreeNode root, int[] count, int k, int[] kthLargest) {
        if (root == null || count[0] >= k) return;

        // Traverse right subtree first
        reverseInorderHelper(root.right, count, k, kthLargest);

        // Increment counter after visiting right subtree
        count[0]++;

        // Check if current node is the Kth largest
        if (count[0] == k) {
            kthLargest[0] = root.val;
            return;
        }

        // Traverse left subtree if Kth largest is not found yet
        reverseInorderHelper(root.left, count, k, kthLargest);
    }

}*/
