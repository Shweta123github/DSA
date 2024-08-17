package BinaryTrees;
import javax.swing.tree.TreeNode;

/*import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class IterativePost {

//tc-->2n  sc-->n
    public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> postorder = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            TreeNode temp = null;

            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    temp = stack.peek().right;
                    if (temp == null) {
                        temp = stack.pop();
                        postorder.add(temp.val);
                        while (!stack.isEmpty() && temp == stack.peek().right) {
                            temp = stack.pop();
                            postorder.add(temp.val);
                        }
                    } else {
                        curr = temp;
                    }
                }
            }
            return postorder;
        }
    }

*/
