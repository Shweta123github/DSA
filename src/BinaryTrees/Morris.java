package BinaryTrees;
import java.util.*;

//morris by in and preorder
//before going last left go to first left and from that go to rightest guy  and from that create thread and then move from root
//to left(cur) and print 4 as it don 't have left/right then again go back to root print 2

public class Morris {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<Integer> getInorder(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            TreeNode cur = root;

            while (cur != null) {
                if (cur.left == null) {
                    inorder.add(cur.val);
                    cur = cur.right;
                } else {
                    TreeNode prev = cur.left;
                    while (prev.right != null && prev.right != cur) {
                        prev = prev.right;
                    }

                    if (prev.right == null) {
                        prev.right = cur;
                        cur = cur.left;
                    } else {
                        prev.right = null;
                        inorder.add(cur.val);
                        cur = cur.right;
                    }
                }
            }

            return inorder;
        }


    }}

/*
Initialize Variables:
java
Copy code
List<Integer> inorder = new ArrayList<>();
TreeNode cur = root;
inorder is an empty list: [].
cur starts at the root node (1).
While Loop (Main Loop)
First Iteration:

Current Node (cur): 1
java
Copy code
if (cur.left == null) { // Check if `cur.left` is null
cur.left is 2, which is not null, so we enter the else block.
Inner While Loop:

java
Copy code
TreeNode prev = cur.left; // `prev` is `2`
while (prev.right != null && prev.right != cur) {
    prev = prev.right;
}
Traversal to find prev:
prev starts at 2.
prev.right is 5 (not null and not cur), so move to prev.right.
prev becomes 5.
prev.right is null, so we exit the inner while loop.
java
Copy code
if (prev.right == null) {
    prev.right = cur; // Create temporary link: `5.right = 1`
    cur = cur.left;   // Move `cur` to `2`
}
Set prev.right (which is 5.right) to cur (which is 1), creating a temporary link.
Move cur to cur.left (which is 2).
Second Iteration:

Current Node (cur): 2
java
Copy code
if (cur.left == null) { // Check if `cur.left` is null
cur.left is 4, so we enter the else block.
Inner While Loop:

java
Copy code
TreeNode prev = cur.left; // `prev` is `4`
while (prev.right != null && prev.right != cur) {
    prev = prev.right;
}
Traversal to find prev:
prev starts at 4.
prev.right is null, so we exit the inner while loop.
java
Copy code
if (prev.right == null) {
    prev.right = cur; // Create temporary link: `4.right = 2`
    cur = cur.left;   // Move `cur` to `4`
}
Set prev.right (which is 4.right) to cur (which is 2), creating a temporary link.
Move cur to cur.left (which is 4).
Third Iteration:

Current Node (cur): 4
java
Copy code
if (cur.left == null) { // Check if `cur.left` is null
cur.left is null, so:
java
Copy code
inorder.add(cur.val); // Add `4` to `inorder`
cur = cur.right;      // Move `cur` to `2` (due to temporary link `4.right = 2`)
Add 4 to inorder: inorder = [4].
Move cur to cur.right, which is 2.
Fourth Iteration:

Current Node (cur): 2 (restored from temporary link)
java
Copy code
if (cur.left == null) { // Check if `cur.left` is null
cur.left is 4, so we enter the else block.
Inner While Loop:

java
Copy code
TreeNode prev = cur.left; // `prev` is `4`
while (prev.right != null && prev.right != cur) {
    prev = prev.right;
}
Traversal to find prev:
prev starts at 4.
prev.right points to 2 (which is cur), so we exit the inner while loop.
java
Copy code
if (prev.right == null) {
    prev.right = cur;
    cur = cur.left;
} else {
    prev.right = null;  // Remove temporary link: `4.right = null`
    inorder.add(cur.val); // Add `2` to `inorder`
    cur = cur.right;    // Move `cur` to `5`
}
prev.right is set to null, restoring the original tree structure.
Add 2 to inorder: inorder = [4, 2].
Move cur to cur.right (which is 5).
Fifth Iteration:

Current Node (cur): 5
java
Copy code
if (cur.left == null) { // Check if `cur.left` is null
cur.left is null, so:
java
Copy code
inorder.add(cur.val); // Add `5` to `inorder`
cur = cur.right;      // Move `cur` to `1` (due to temporary link `5.right = 1`)
Add 5 to inorder: inorder = [4, 2, 5].
Move cur to cur.right (which is 1).
Sixth Iteration:

Current Node (cur): 1 (restored from temporary link)
java
Copy code
if (cur.left == null) { // Check if `cur.left` is null
cur.left is 2, so we enter the else block.
Inner While Loop:

java
Copy code
TreeNode prev = cur.left; // `prev` is `2`
while (prev.right != null && prev.right != cur) {
    prev = prev.right;
}
Traversal to find prev:
prev starts at 2.
prev.right points to 1 (which is cur), so we exit the inner while loop.
java
Copy code
if (prev.right == null) {
    prev.right = cur;
    cur = cur.left;
} else {
    prev.right = null;  // Remove temporary link: `2.right = null`
    inorder.add(cur.val); // Add `1` to `inorder`
    cur = cur.right;    // Move `cur` to `3`
}
prev.right is set to null, restoring the original tree structure.
Add 1 to inorder: inorder = [4, 2, 5, 1].
Move cur to cur.right (which is 3).
Seventh Iteration:

Current Node (cur): 3
java
Copy code
if (cur.left == null) { // Check if `cur.left` is null
cur.left is null, so:
java
Copy code
inorder.add(cur.val); // Add `3` to `inorder`
cur = cur.right;      // Move `cur` to `null`
Add 3 to inorder: inorder = [4, 2, 5, 1, 3].
Move cur to cur.right (which is null).
Exit While Loop:
The while (cur != null) loop terminates because cur is null.
Return:
java
Copy code
return inorder; // Return the result list: [4, 2, 5, 1, 3]
Summary:
The Morris Traversal algorithm effectively performs an inorder traversal by temporarily modifying the tree structure and using a threaded link.
The algorithm ensures that the tree structure is restored to its original state after traversal.
The output list [4, 2, 5, 1, 3] represents the inorder traversal of the given binary tree.









ChatGPT can make mistakes. Check important info.
 */


//preorder
/*
public class Morris {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<Integer> getPreorderTreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            TreeNode cur = root;

            while (cur != null) {
                if (cur.left == null) {
                    inorder.add(cur.val);
                    cur = cur.right;
                } else {
                    TreeNode prev = cur.left;
                    while (prev.right != null && prev.right != cur) {
                        prev = prev.right;
                    }

                    if (prev.right == null) {
                        prev.right = cur;
                        preorder.add(cur.val);

                         cur = cur.left;
                    } else {
                        prev.right = null;
                        cur = cur.right;
                    }
                }
            }

            return inorder;
        }


    }}
*/