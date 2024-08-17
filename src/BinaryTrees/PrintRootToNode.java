package BinaryTrees;
//inorder
//on both left and right we don;t have node return false and return yetana node kadhun yaych
/*public class PrintRootToNode {

        // This method gets the path from the root to the node with value 'x'
        private boolean getPath(TreeNode root, ArrayList<Integer> arr, int x) {
            if (root == null) {
                return false; // Base case: if root is null, return false
            }

            arr.add(root.val); // Add the current node's value to the path

            // If the current node's value is equal to 'x', return true
            if (root.val == x) {
                return true;
            }

            // Recursively check left and right subtrees
            if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
                return true;
            }

            // If 'x' is not found, remove the current node's value from the path
            arr.remove(arr.size() - 1);
            return false;
        }

        // This method solves the problem by returning the path to the node with value 'B'
        public ArrayList<Integer> solve(TreeNode A, int B) {
            ArrayList<Integer> arr = new ArrayList<>();
            if (A == null) return arr; // If the root is null, return an empty list

            getPath(A, arr, B); // Get the path to the node with value 'B'
            return arr; // Return the path
        }
    }*/
