package BinaryTrees;
//node=right value+left value
// while going down add values and coming back do addition
/*public class Childrensum {
        public static void changeTree(BinaryTreeNode<Integer> root) {
            if (root == null) return;

            // Step 1: Calculate the sum of the values of the left and right children
            int child = 0;
            if (root.left != null) {
                child += root.left.data;
            }
            if (root.right != null) {
                child += root.right.data;
            }

            // Step 2: If the sum of the children is greater than or equal to the root value, update the root value
            if (child >= root.data) {
                root.data = child;
            } else {
                // Otherwise, make the child values equal to the root value
                if (root.left != null) root.left.data = root.data;
                if (root.right != null) root.right.data = root.data;
            }

            // Step 3: Recursively call the function for the left and right children
            changeTree(root.left);
            changeTree(root.right);

            // Step 4: Update the root value to the sum of its children if it's not a leaf node
            int tot = 0;
            if (root.left != null) tot += root.left.data;
            if (root.right != null) tot += root.right.data;

            if (root.left != null || root.right != null) {
                root.data = tot;
            }
        }
    }

*/
