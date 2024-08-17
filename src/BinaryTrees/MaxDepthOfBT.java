package BinaryTrees;
//output=4=height

//we can use recursion and level wise but the disadvantage of level wise is that in worst case it take sc-->n
//recursion not uses any sc but uses auxiliary space 0(height) worst case


public class MaxDepthOfBT {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        MaxDepthOfBT sol = new MaxDepthOfBT();
        int depth = sol.maxDepth(root);
        System.out.println("Maximum Depth: " + depth); // Output will be 3
    }
}
