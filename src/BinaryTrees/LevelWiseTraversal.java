package BinaryTrees;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//tc,sc-->n queue
/*public class LevelWiseTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if (root == null) {
            return wrapList;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
                subList.add(currentNode.val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
*/