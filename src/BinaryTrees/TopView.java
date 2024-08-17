package BinaryTrees;

import java.util.*;

public class TopView {
    // Definition for a binary tree node
        int data;
        TopView left, right;

        TopView(int item) {
            data = item;
            left = right = null;
        }
    }

    // Pair class to hold node and its horizontal distance
    class Pair {
        TopView node;
        int hd; // horizontal distance

        Pair(TopView node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    class Solution {
        // Function to return a list of nodes visible from the top view from left to right in Binary Tree
        public static ArrayList<Integer> topView(TopView root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) return ans;

            Map<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0)); // Start with the root node at horizontal distance 0

            while (!q.isEmpty()) {
                Pair it = q.remove();
                int hd = it.hd; // Horizontal distance of the current node
                TopView temp = it.node; // Current node
                // If the horizontal distance is not yet in the map, add it
                if (!map.containsKey(hd)) {
                    map.put(hd, temp.data);
                }
                // Add left child to the queue with horizontal distance hd - 1
                if (temp.left != null) {
                    q.add(new Pair(temp.left, hd - 1));
                }
                // Add right child to the queue with horizontal distance hd + 1
                if (temp.right != null) {
                    q.add(new Pair(temp.right, hd + 1));
                }
            }
            // Extract the top view nodes from the map
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }
            return ans;
        }

        public static void main(String[] args) {
            TopView root = new TopView(1);
            root.left = new TopView(2);
            root.right = new TopView(3);
            root.left.left = new TopView(4);
            root.left.right = new TopView(5);
            root.right.right = new TopView(6);

            ArrayList<Integer> topView = topView(root);
            System.out.println("Top view of the binary tree: " + topView);
            // Output will be [4, 2, 1, 3, 6]
        }
    }
