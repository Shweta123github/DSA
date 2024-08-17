package BinaryTrees;

import java.util.ArrayList;

//anticlockwise rotate kr
//left boundry excluding leaf
//leaf nodes-->inorder ni
//right boundary in reverse excluding leaf

/*public class BoundaryTraversal {
        int data;
    BoundaryTraversal left, right;

    BoundaryTraversal(int data) {
            this.data = data;
            left = right = null;
        }
    }

    class Solution {

        // Method to add left boundary nodes (excluding leaf nodes)
        void addLeftBoundary(BoundaryTraversal root, ArrayList<Integer> res) {
            BoundaryTraversal cur = root.left;
            while (cur != null) {
                if (!isLeaf(cur)) res.add(cur.data);
                if (cur.left != null) cur = cur.left;
                else cur = cur.right;
            }
        }

        // Method to add right boundary nodes (excluding leaf nodes)
        void addRightBoundary(BoundaryTraversal root, ArrayList<Integer> res) {
            BoundaryTraversal cur = root.right;
            ArrayList<Integer> tmp = new ArrayList<>();
            while (cur != null) {
                if (!isLeaf(cur)) tmp.add(cur.data);
                if (cur.right != null) cur = cur.right;
                else cur = cur.left;
            }
            // Add right boundary in reverse order
            for (int i = tmp.size() - 1; i >= 0; --i) {
                res.add(tmp.get(i));
            }
        }

        // Method to add all leaf nodes
        void addLeaves(BoundaryTraversal root, ArrayList<Integer> res) {
            if (isLeaf(root)) {
                res.add(root.data);
                return;
            }
            if (root.left != null) addLeaves(root.left, res);
            if (root.right != null) addLeaves(root.right, res);
        }

        // Method to check if a node is a leaf node
        boolean isLeaf(BoundaryTraversal node) {
            return node.left == null && node.right == null;
        }

        // Method to print the boundary nodes
        ArrayList<Integer> printBoundary(BoundaryTraversal node) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (!isLeaf(node)) ans.add(node.data);  // Add root if it's not a leaf node
            addLeftBoundary(node, ans);             // Add left boundary excluding leaf nodes
            addLeaves(node, ans);                   // Add all leaf nodes
            addRightBoundary(node, ans);            // Add right boundary excluding leaf nodes
            return ans;
        }

        public static void main(String[] args) {
            BoundaryTraversal root = new BoundaryTraversal(1);
            root.left = new BoundaryTraversal(2);
            root.right = new BoundaryTraversal(3);
            root.left.left = new BoundaryTraversal(4);
            root.left.right = new BoundaryTraversal(5);
            root.right.left = new BoundaryTraversal(6);
            root.right.right = new BoundaryTraversal(7);

            Solution sol = new Solution();
            ArrayList<Integer> boundaryNodes = sol.printBoundary(root);

            System.out.println(boundaryNodes);  // Output: [1, 2, 4, 5, 6, 7, 3]
        }
    }

*/