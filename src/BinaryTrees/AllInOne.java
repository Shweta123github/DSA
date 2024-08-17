package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

//tc--->3n  sc--->4n
/*import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class AllInOne {
    public void preInPostTraversal(TreeNode root) {
        if (root == null) return;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // Pre-order part
            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }
            // In-order part
            else if (it.num == 2) {
                in.add(it.node.val);
                it.num++;
                st.push(it);
                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            // Post-order part
            else {
                post.add(it.node.val);
            }
        }

        // You can print or return these lists as needed
        System.out.println("Pre-order: " + pre);
        System.out.println("In-order: " + in);
        System.out.println("Post-order: " + post);
    }
}
//Pre-order: [1, 2, 4, 5, 3, 6]
//In-order: [4, 2, 5, 1, 3, 6]
//Post-order: [4, 5, 2, 6, 3, 1]

*/