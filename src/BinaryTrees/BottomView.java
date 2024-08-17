package BinaryTrees;
import java.util.*;

//right ghaych
//update with new
public class BottomView {


    // Definition for a binary tree node
        int data;
        BottomView left, right;
        int hd; // horizontal distance

    BottomView(int item) {
            data = item;
            left = right = null;
        }
    }

     class Solution1 {
        // Function to return a list containing the bottom view of the given tree
        public ArrayList<Integer> bottomView(BottomView root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) return ans;

            // Map to store the bottom view nodes, where key is horizontal distance and value is node data
            Map<Integer, Integer> map = new TreeMap<>();
            // Queue for level-order traversal, holding nodes and their horizontal distance
            Queue<BottomView> q = new LinkedList<>();
            root.hd = 0; // Initialize the root node's horizontal distance
            q.add(root);

            while (!q.isEmpty()) {
                BottomView temp = q.remove(); // Get the front node from the queue
                int hd = temp.hd; // Horizontal distance of the current node

                // Put the node in the map, this will overwrite any previous node at the same horizontal distance
                map.put(hd, temp.data);

                // Add left child to the queue with horizontal distance hd - 1
                if (temp.left != null) {
                    temp.left.hd = hd - 1;
                    q.add(temp.left);
                }

                // Add right child to the queue with horizontal distance hd + 1
                if (temp.right != null) {
                    temp.right.hd = hd + 1;
                    q.add(temp.right);
                }
            }

            // Add the nodes from the map to the result list
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }

            return ans;
        }

        public static void main(String[] args) {
            // Example usage
            BottomView root = new BottomView(1);
            root.left = new BottomView(2);
            root.right = new BottomView(3);
            root.left.left = new BottomView(4);
            root.left.right = new BottomView(5);
            root.right.right = new BottomView(6);
            root.right.right.left = new BottomView(7);

            Solution1 sol = new Solution1();
            ArrayList<Integer> bottomView = sol.bottomView(root);
            System.out.println("Bottom view of the binary tree: " + bottomView); // Output will be [4, 2, 7, 6, 3]
        }
    }


